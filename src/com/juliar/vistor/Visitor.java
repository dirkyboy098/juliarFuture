package com.juliar.vistor;

import com.juliar.ImportsInterface;
import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.errors.Logger;
import com.juliar.nodes.*;
import com.juliar.pal.Primitives;
import com.juliar.parser.JuliarBaseVisitor;
import com.juliar.parser.JuliarParser;
import com.juliar.symboltable.SymbolTable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by donreamey on 10/21/16.
 */
public class Visitor extends JuliarBaseVisitor<Node>
{
    private static int functionDeclCount = 0;
    private static int ifDeclCount = 0;
    private static int whileDeclCount = 0;
    private static int classDeclCount = 0;
    private List<Node> instructionList = new ArrayList<>();
    private HashMap<String, Node> functionNodeMap = new HashMap<>();
    private Stack<Node> funcContextStack = new Stack<>();
    private Stack<String> callStack = new Stack<>();
    private SymbolTable symbolTable = SymbolTable.createSymbolTable( this );
    private ImportsInterface importsInterfaceCallback;
    private List<String> errorList = new ArrayList<>();
    private HashMap<String, UserDefinedTypeNode> declaredClasses = new HashMap<>();
    private StringBuilder importBuffer = new StringBuilder();

    public InstructionInvocation instructions(){
        return new InstructionInvocation(instructionList, functionNodeMap);
    }

    public Visitor(ImportsInterface cb, boolean skip){
        importsInterfaceCallback = cb;
    }

    @Override
    public Node visitCompileUnit(JuliarParser.CompileUnitContext ctx) {

        CompliationUnitNode node = new CompliationUnitNode();
        try {
            callStack.push ( node.getNodeName() );
            symbolTable.addLevel( node.getNodeName() );

            new IterateOverContext(ctx, this, node);

            instructionList.add(node);

            popScope( node.getType() );
            //cfa.walkGraph();
            //symbolTable.dumpSymbolTable();
        }
        catch(Exception ex){
            Logger.log( ex.getMessage() );
        }
        return node;
    }

    private void popScope(NodeType nodeType){
            switch ( nodeType) {
                case FunctionDeclType:
                    functionDeclCount--;
                    break;
                case IfExprType:
                    ifDeclCount--;
                    break;
                case WhileExpressionType:
                    whileDeclCount--;
                    break;
                case UserDefinedDeclarationType:
                    classDeclCount--;
                    break;
                default:
                    return;
            }

        symbolTable.popScope();
    }

    @Override
    public Node visitStatement(JuliarParser.StatementContext ctx) {
        StatementNode node = new StatementNode();
        new IterateOverContext(ctx, this, node);
        return node;
    }

    @Override
    public Node visitEndLine(JuliarParser.EndLineContext ctx) {
        FinalNode finalNode = new FinalNode();
        new IterateOverContext(ctx, this, finalNode);
        return finalNode;
    }

    //TODO need to refactor and combine vistAdd and visitSubtract
    @Override
    public Node visitAdd(JuliarParser.AddContext ctx) {
        return iterateWrapper(ctx, this , new AggregateNode());
    }

    @Override
    public Node visitSummation(JuliarParser.SummationContext ctx) {
        return iterateWrapper( ctx, this, new SummationType());
    }

    @Override
    public Node visitSubtract(JuliarParser.SubtractContext ctx) {
        String text = ctx.subtraction().getText();
        if ("subtract".equals(text) || "-".equals(text)){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {

                    Node n = node.makeNode(
                                Operation.subtract,
                                ctx.types(0).accept(this),
                                ctx.types(1).accept(this));
                    n.addInst( funcContextStack, n);
                }catch( Exception ex){
                    Logger.log(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.subtract, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.addInst( aggregateNode );
            }
        }
        return null;
    }

    @Override
    public Node visitFunctionDeclaration(JuliarParser.FunctionDeclarationContext ctx) {
        String funcName = ctx.funcName().getText();
        FunctionDeclNode functionDeclNode = new FunctionDeclNode(funcName, new ArrayList<Node>());

        callStack.push( funcName );
        symbolTable.addLevel( funcName + "_" +functionDeclCount++ );

        new IterateOverContext(ctx, this, functionDeclNode);

        callStack.pop();
        popScope( functionDeclNode.getType() );

        functionNodeMap.put(funcName, functionDeclNode);

        return functionDeclNode;
    }

    @Override
    public Node visitFunctionCall(JuliarParser.FunctionCallContext ctx) {
        FunctionCallNode node = new FunctionCallNode();
        new IterateOverContext(ctx, this, node);

        return node;
    }

    @Override
    public Node visitEqualequal(JuliarParser.EqualequalContext ctx){
        EqualEqualSignNode node = new EqualEqualSignNode();
        new IterateOverContext(ctx, this, node);
        return node;
    }

    private Node handleBooleanOperatorNode( ParserRuleContext ctx){
        BooleanOperatorNode booleanOperatorNode = new BooleanOperatorNode();
        iterateWithTryCatch( ctx, booleanOperatorNode);
        return booleanOperatorNode;
    }

    @Override
    public Node visitLessthan(JuliarParser.LessthanContext ctx){
        return handleBooleanOperatorNode( ctx );
    }
    @Override

    public Node visitGreaterthan(JuliarParser.GreaterthanContext ctx){
        return handleBooleanOperatorNode( ctx );
    }
    @Override

    public Node visitLessthanorequalto(JuliarParser.LessthanorequaltoContext ctx){
        return handleBooleanOperatorNode( ctx );
    }

    @Override
    public Node visitGreaterthanorequalto(JuliarParser.GreaterthanorequaltoContext ctx){
        return handleBooleanOperatorNode( ctx );
    }

    @Override
    public Node visitBooleanAndOperator(JuliarParser.BooleanAndOperatorContext ctx) {
        return super.visitBooleanAndOperator(ctx);
    }

    @Override
    public Node visitThreeway(JuliarParser.ThreewayContext ctx){
        return null;
    }

    @Override
    public Node visitModulo(JuliarParser.ModuloContext ctx) {

        String text = ctx.moduli().getText();
        if ("modulo".equals(text) || "%".equals(text)){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    instructionList.add(node.makeNode(
                            Operation.modulo,
                            ctx.types(0).accept(this),
                            ctx.types(1).accept(this)));
                }catch( Exception ex){
                    Logger.log(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.modulo, data);

                instructionList.add( aggregateNode );
            }
        }

        return null;
    }

    @Override
    public Node visitDivide(JuliarParser.DivideContext ctx) {

        String text = ctx.division().getText();
        if ("divide".equals(text) || "/".equals(text)){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    if (!funcContextStack.empty()) {
                        FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                        functionDeclNode.addInst(node.makeNode(
                                Operation.divide,
                                ctx.types(0).accept(this),
                                ctx.types(1).accept(this)));
                    }
                }catch( Exception ex){
                    Logger.log(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.divide, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.addInst( aggregateNode );
            }
        }

        return null;
    }

    @Override
    public Node visitMultiply(JuliarParser.MultiplyContext ctx) {
        MulitiplyNode node = new MulitiplyNode();
        iterateWrapper( ctx, this, node);
        return node;
    }

    @Override
    public Node visitTypes(JuliarParser.TypesContext ctx) {
        IntegralTypeNode integralTypeNode = new IntegralTypeNode();

        IterateOverContext context = new IterateOverContext();
        context.iterateOverChildren( ctx.primitiveTypes(), this, integralTypeNode );

        return integralTypeNode;
    }

    @Override
    public Node visitPrimitives(JuliarParser.PrimitivesContext ctx) {
        PrimitiveNode primitiveNode = new PrimitiveNode();
        IterateOverContext context = new IterateOverContext();
        context.iterateOverChildren(ctx, this, primitiveNode);
        return primitiveNode;
    }

    @Override
    public Node visitTerminal(TerminalNode node) {
        Node n = funcContextStack.peek();
        if (n instanceof FunctionDeclNode) {
            String name = ((FunctionDeclNode) n).getFunctionName();
            if ("import".equals(name)) {
               cacheImports( node.getText() );

            }
        }
        return new FinalNode(node);
    }

    @Override
    public Node visitBreakKeyWord(JuliarParser.BreakKeyWordContext ctx) {
        return iterateWrapper( ctx, this, new BreakExprNode());
    }

    @Override
    public Node visitAssignmentExpression(JuliarParser.AssignmentExpressionContext ctx) {
        AssignmentNode node = new AssignmentNode(null);

        IterateOverContext iterateOverContext = new IterateOverContext(){
            @Override
            public void action(Node parent, Node child) {
                // Set the integral type of the expression for type checking the right hand
                // side of the expression during parsing and at runtime.
                if (child instanceof VariableDeclarationNode) {
                    VariableDeclarationNode variableDeclarationNode = (VariableDeclarationNode) child;
                    parent.setVariableTypeByIntegralType(variableDeclarationNode.getIntegralType());
                }

                if ( parent instanceof AssignmentNode && parent.getInstructions().size() >= 2 && parent.getInstructions().get(0) instanceof VariableDeclarationNode){
                    if ( parent.getInstructions().get(0).getInstructions().get(0) instanceof  UserDefinedTypeNode){
                        parent.getInstructions().get(0).getInstructions().get(0).getInstructions().get(2).getIntegralType();
                        return;
                    }
                    else {
                        VariableNode variableNode = (VariableNode) parent.getInstructions().get(0).getInstructions().get(1);
                        variableNode.getIntegralType();
                        /* if (parent.getIntegralType() != variableNode.getIntegralType()) {
                           throw new RuntimeException( "invalide types used in expressioin");
                        }*/
                    }
                }

                if (child instanceof PrimitiveNode && parent.getIntegralType() != null && parent.getIntegralType() != child.getIntegralType()){
                    throw new RuntimeException( "invald types used in expression" );
                }
            }
        };

        iterateOverContext.iterateOverChildren(ctx, this, node);
        return node;
    }

    @Override
    public Node visitReassignmentExpression(JuliarParser.ReassignmentExpressionContext ctx) {
        VariableReassignmentNode node = new VariableReassignmentNode();

        //TODO see if the node is in tye Symboltable and if it can be accessed. The original node with the type.
        iterateWrapper(ctx, this, node);
        if (symbolTable.doesChildExistAtScope( node.getInstructions().get(0))){
            VariableNode variableNode = (VariableNode)symbolTable.getNode( node.getInstructions().get(0) );
            node.getInstructions().get(0).setVariableTypeByIntegralType( variableNode.getIntegralType() );
        }
        return node;
    }

    @Override
    public Node visitLogicalAndExpression(JuliarParser.LogicalAndExpressionContext ctx) {
        return handleBooleanOperatorNode( ctx );
    }

    @Override
    public Node visitIfExpr(JuliarParser.IfExprContext ctx) {
        IfExprNode node = new IfExprNode();
        symbolTable.addLevel( "if" + "_" + ifDeclCount++ );

        iterateWrapper( ctx, this, node);

        symbolTable.popScope();

        return node;
    }

    @Override
    public Node visitNotExpression(JuliarParser.NotExpressionContext ctx) {
        return handleBooleanOperatorNode( ctx );
    }

    @Override
    public Node visitRelationalExpression(JuliarParser.RelationalExpressionContext ctx) {
        return iterateWithTryCatch( ctx , new RelationalNode());
    }

    @Override
    public Node visitNumericTypes(JuliarParser.NumericTypesContext ctx) {
        return super.visitNumericTypes(ctx);
    }

    @Override
    public Node visitPrimitiveTypes(JuliarParser.PrimitiveTypesContext ctx) {
        PrimitiveNode node = new PrimitiveNode();
        new IterateOverContext(ctx, this, node);
        return node;
    }

    @Override
    public Node visitEqualsign(JuliarParser.EqualsignContext ctx) {
        return new EqualSignNode();
    }

       @Override
    public Node visitExpression(JuliarParser.ExpressionContext ctx) {
        ExpressionNode node = new ExpressionNode();
        new IterateOverContext(ctx, this , node);
        return node;
    }

    @Override
    public Node visitVariableDeclaration(JuliarParser.VariableDeclarationContext ctx) {
        VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode();

        new IterateOverContext(ctx, this , variableDeclarationNode);
        VariableNode variableNode;

        if ( variableDeclarationNode.getInstructions().get(0) instanceof  UserDefinedTypeNode){
            variableNode = (VariableNode) variableDeclarationNode.getInstructions().get(0).getInstructions().get(2);
            variableNode.setVariableType( ctx.children.get(0).getChild(0).getText() );
        }
        else if (variableDeclarationNode.getInstructions().size() >= 2) {
            variableNode = (VariableNode) variableDeclarationNode.getInstructions().get(1);
            variableNode.setVariableType(ctx.children.get(0).getText());
        }

        return variableDeclarationNode;
    }

    @Override
    public Node visitKeywords(JuliarParser.KeywordsContext ctx) {
        KeywordNode keywordNode = new KeywordNode();
        new IterateOverContext(ctx, this, keywordNode);

        return keywordNode;
    }

    @Override
    public Node visitBooleanExpression(JuliarParser.BooleanExpressionContext ctx) {
        BooleanNode node = new BooleanNode();
        IterateOverContext iterateOverContext =  new IterateOverContext( ){
            @Override
            public void action(Node node) {
                super.action(node);
            }
        };

        iterateOverContext.iterateOverChildren(ctx, this, node);

        node.determineBooleanComparisionType();

        return node;
    }

    @Override
    public Node visitCommand(JuliarParser.CommandContext ctx) {
        CommandNode commandNode = new CommandNode();
        new IterateOverContext(ctx, this , commandNode);
        return commandNode;
    }

    @Override
    public Node visitVariable(JuliarParser.VariableContext ctx) {
        Node iteratorNode;

        try {
            String variableName = "";

            if ( ctx.ID() != null ) {
                variableName = ctx.ID().getText();
            }

            VariableNode variableNode = new VariableNode(variableName);

            if (variableNode == null) {
                throw new RuntimeException("unable to create a variable");
            }

            Object[] funcStackArray = funcContextStack.toArray();
            int length = funcStackArray.length - 1;
            int index = length;

            for (; index >= 0; index--) {
                if (funcStackArray[index] instanceof VariableDeclarationNode) {
                    // We are creating the variable and adding it to the symbol table.
                    // This will automatically throw an exception if creating a symbol with
                    // same name at same scope.
                    symbolTable.addChild(variableNode);
                    break;
                }

                if (funcStackArray[index] instanceof UserDefinedTypeNode) {
                    assert true : "should not hit this";
                    // TODO
                    // user defined variables will need to be looked up in the class / variable map.
                    break;
                }

                if (funcStackArray[index] instanceof UserDefinedTypeVariableDeclNode) {
                    UserDefinedTypeVariableDeclNode temp = (UserDefinedTypeVariableDeclNode) funcStackArray[index];
                    variableNode.setParent(temp);
                    if (!symbolTable.doesChildExistAtScope(variableNode)) {
                        symbolTable.addChild(variableNode);
                    }
                    break;
                }

                if (funcStackArray[index] instanceof UserDefinedTypeVariableReference) {
                    handleUserDefinedTypeVariableReference(variableName, funcStackArray[index]);
                    break;
                }

                if (!symbolTable.doesChildExistAtScope(variableNode)) {
                    addError("The variable [" + variableName + "] is not declared at the scope");
                }
            }

            iteratorNode = iterateWrapper(ctx, this, variableNode);
        }
        catch( Exception ex) {
            throw ex;
        }

        return iteratorNode;
    }

    private void handleUserDefinedTypeVariableReference(String variableName, Object functionStackObject) {
        UserDefinedTypeVariableReference tempRef = (UserDefinedTypeVariableReference) functionStackObject;
        String objectName = tempRef.getObjectName();

        VariableNode objectVariable = new VariableNode( objectName );
        UserDefinedTypeVariableDeclNode parent = null;
        if (symbolTable.doesChildExistAtScope( objectVariable )){
            Node localVar = symbolTable.getNode( objectVariable );
            if (localVar instanceof VariableNode){
                VariableNode localVariableNode = (VariableNode)localVar;

                if ( localVariableNode.getParent() instanceof  UserDefinedTypeVariableDeclNode ) {
                    parent = (UserDefinedTypeVariableDeclNode) localVariableNode.getParent();
                }
            }
        }

        if ( parent == null ) {
            throw new RuntimeException( String.format( "The user defined variable %s does not have an accessible parent" , variableName ) );
        }

        String className = parent.getUserDefinedVariableTypeName();

        if ( declaredClasses.containsKey( className )){
            UserDefinedTypeNode userDefinedTypeNode = declaredClasses.get ( className );

            if ( !userDefinedTypeNode.getAllVariableNames().contains( variableName )) {
                addError( "the object [ " + className  + "]   does not have a varible [" + variableName + "] defined as part of its instance");
            }

            VariableNode tempVariableNode = new VariableNode( variableName );

            if ( !symbolTable.doesChildExistInHash( parent, tempVariableNode) ){
                symbolTable.addChild( tempVariableNode );
            }
        }
    }

    @Override
    public Node visitReturnValue(JuliarParser.ReturnValueContext ctx) {
        ReturnValueNode node = new ReturnValueNode();

        new IterateOverContext(ctx, this, node);

        return node;
    }

    @Override
    public Node visitWhileExpression(JuliarParser.WhileExpressionContext ctx) {
        symbolTable.addLevel( "while" + "_" + whileDeclCount++ );

        WhileExprNode whileExprNode = new WhileExprNode();
        iterateWrapper( ctx, this, whileExprNode);

        symbolTable.popScope();
        return whileExprNode;
    }

    public void addError(String error ){
        errorList.add( error );
    }

    public List<String> getErrorList(){
        return errorList;
    }


    @Override
    public Node visitUserDefinedTypeDecl(JuliarParser.UserDefinedTypeDeclContext ctx) {
        UserDefinedTypeNode userDefinedTypeNode = new UserDefinedTypeNode();

        symbolTable.addLevel( ctx.userDefinedTypeName().getText() );

        iterateWrapper( ctx, this, userDefinedTypeNode);

        if ( declaredClasses.containsKey( userDefinedTypeNode.getTypeName() ) ){
            throw new RuntimeException( "class " + userDefinedTypeNode.getTypeName() + "already exist at current scope");
        }

        declaredClasses.put(
                userDefinedTypeNode.getTypeName(),
                userDefinedTypeNode);

        symbolTable.popScope();

        return userDefinedTypeNode;
    }

    @Override
    public Node visitUserDefinedTypeKeyWord(JuliarParser.UserDefinedTypeKeyWordContext ctx) {
        KeywordNode keywordNode = new KeywordNode();
        return iterateWithTryCatch( ctx, keywordNode);
    }

    @Override
    public Node visitUserDefinedTypeName(JuliarParser.UserDefinedTypeNameContext ctx) {
        UserDefinedTypeNameNode userDefinedTypeNameNode = new UserDefinedTypeNameNode();
        return iterateWithTryCatch( ctx, userDefinedTypeNameNode );
    }

    @Override
    public Node visitUserDefinedTypeFunctionReference(JuliarParser.UserDefinedTypeFunctionReferenceContext ctx) {
        UserDefinedTypeFunctionReferenceNode node = new UserDefinedTypeFunctionReferenceNode();
        funcContextStack.push ( node );
        iterateWithTryCatch( ctx, node);
        funcContextStack.pop();

        return node;
    }

    private <S extends ParserRuleContext, T extends NodeImpl> T iterateWithTryCatch(S ctx, T node){
        try {
            iterateWrapper(ctx, this, node);
        }
        catch ( Exception ex){
            throw ex;
        }

        return node;
    }

    @Override
    public Node visitDeleteExpression(JuliarParser.DeleteExpressionContext ctx) {
        return super.visitDeleteExpression(ctx);
    }

    @Override
    public Node visitLogicalOrExpression(JuliarParser.LogicalOrExpressionContext ctx) {
        return super.visitLogicalOrExpression(ctx);
    }

    @Override
    public Node visitUserDefinedTypeVariableDecl(JuliarParser.UserDefinedTypeVariableDeclContext ctx) {
        UserDefinedTypeVariableDeclNode node = new UserDefinedTypeVariableDeclNode();
        return iterateWithTryCatch( ctx, node);
    }

    @Override
    public Node visitUserDefinedTypeResolutionOperator(JuliarParser.UserDefinedTypeResolutionOperatorContext ctx) {
        ResolutionNode resolutionNode = new ResolutionNode();
        return iterateWithTryCatch( ctx, resolutionNode);
    }

    @Override
    public Node visitUserDefinedTypeVariableReference(JuliarParser.UserDefinedTypeVariableReferenceContext ctx) {
        UserDefinedTypeVariableReference node = new UserDefinedTypeVariableReference();
        return iterateWithTryCatch( ctx, node);
    }


    private Node iterateWrapper(ParserRuleContext ctx, Visitor visitor, Node parent){
        IterateOverContext it = new IterateOverContext();
        it.iterateOverChildren(ctx, visitor, parent);
        return parent;
    }

    private void cacheImports( String fileName){
        StringBuilder builder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Primitives.stripQuotes( fileName ) ))){
            String line = bufferedReader.readLine();
            while ( line != null ){
                builder.append( line );
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            Logger.log(e);
        }

        importBuffer.append( builder );
        int currentLineNumber = 0;
        importsInterfaceCallback.createTempCallback( importBuffer.toString(), currentLineNumber);
    }

    class IterateOverContext {

        public IterateOverContext() {
        }

        public IterateOverContext(ParserRuleContext ctx, Visitor visitor, Node parent) {
            this();
            iterateOverChildren(ctx, visitor, parent);
        }


        public void iterateOverChildren(ParserRuleContext ctx, Visitor visitor, Node parent) {
            if ( ctx.children == null ){
                return;
            }
            funcContextStack.push(parent);

            for (Iterator<ParseTree> pt = ctx.children.iterator(); pt.hasNext(); ) {
                ParseTree parseTree = pt.next();
                Node node = parseTree.accept(visitor);

                if (node != null) {
                    action(parent, node);
                    action(node);
                    parent.addInst(node);
                }
            }

            funcContextStack.pop();
        }


        /*
         this method will be overridden in implementation.
         */
        public void action(Node node){
        /*
        empty body
        */
        }

        public void action(Node parent, Node child){
        /*
        empty body
        */
        }
    }
}
