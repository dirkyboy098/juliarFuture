package com.juliar.vistor;
import com.juliar.ImportsInterface;
import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.controlflow.ControlFlowAdjacencyList;
import com.juliar.errors.LogMessage;
import com.juliar.nodes.*;
import com.juliar.pal.Primitives;
import com.juliar.parser.JuliarBaseVisitor;
import com.juliar.parser.JuliarParser;
import com.juliar.symbolTable.SymbolTable;
import com.juliar.symbolTable.SymbolTypeEnum;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
    private List<Node> instructionList = new ArrayList<>();
    private HashMap<String, Node> functionNodeMap = new HashMap<String, Node>();
    private Stack<Node> funcContextStack = new Stack<Node>();
    private Stack<String> callStack = new Stack<>();

    private SymbolTable symbolTable = SymbolTable.CreateSymbolTable();
    private ControlFlowAdjacencyList cfa = new ControlFlowAdjacencyList();
    private ImportsInterface importsInterfaceCallback;
    private boolean skimImports = false;
    private int currentLineNumber = 0;

    public InstructionInvocation instructions(){
        return new InstructionInvocation(instructionList, functionNodeMap);
    }

    public Visitor(ImportsInterface cb, boolean skip){
        importsInterfaceCallback = cb;
        skimImports = skip;
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
            cfa.walkGraph();

            //symbolTable.dumpSymbolTable();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
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
        if (text.equals("subtract") || text.equals("-")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {

                    Node n = node.MakeNode(
                                Operation.subtract,
                                ctx.types(0).accept(this),
                                ctx.types(1).accept(this));
                    n.AddInst( funcContextStack, n);
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.subtract, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
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
        //symbolTable.addLevel( functionDeclNode.getNodeName(), funcName, SymbolTypeEnum.functionDecl);

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

    @Override
    public Node visitLessthan(JuliarParser.LessthanContext ctx){
        //if_icmplt
        return null;
    }
    @Override

    public Node visitGreaterthan(JuliarParser.GreaterthanContext ctx){
        //if_icmpgt
        return null;
    }
    @Override

    public Node visitLessthanorequalto(JuliarParser.LessthanorequaltoContext ctx){

        //if_icmple
        return null;
    }
    @Override

    public Node visitGreaterthanorequalto(JuliarParser.GreaterthanorequaltoContext ctx){
        //if_icmpge
        return null;
    }

    @Override
    public Node visitThreeway(JuliarParser.ThreewayContext ctx){
        return null;
    }

    public Node visitModulo(JuliarParser.ModuloContext ctx) {

        String text = ctx.moduli().getText();
        if (text.equals("modulo") || text.equals("%")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    instructionList.add(node.MakeNode(
                            Operation.modulo,
                            ctx.types(0).accept(this),
                            ctx.types(1).accept(this)));
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
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
        if (text.equals("divide") || text.equals("/")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    if (!funcContextStack.empty()) {
                        FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                        functionDeclNode.AddInst(node.MakeNode(
                                Operation.divide,
                                ctx.types(0).accept(this),
                                ctx.types(1).accept(this)));
                    }
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.divide, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }

        return null;
    }

    @Override
    public Node visitMultiply(JuliarParser.MultiplyContext ctx) {

        String text = ctx.multiplication().getText();
        if (text.equals("multiply") || text.equals("*")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                    functionDeclNode.AddInst(node.MakeNode(
                            Operation.multiply,
                            ctx.types(0).accept(this),
                            ctx.types(1).accept(this)));
                }catch( Exception ex){
                    new LogMessage(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> data = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    data.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.multiply, data);
                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }

        return null;
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
            if ( name.equals( "import" )) {
               cacheImports( node.getText() );

            }
        }

        FinalNode terminalNode = new FinalNode(node);

        IterateOverContext context = new IterateOverContext() {
            @Override
            public void action(Node pt) {
                terminalNode.AddInst(pt);
            }
        };

        //context.iterateOverChildren( node, this );
        return new FinalNode(node);
    }

    @Override
    public Node visitAssignmentExpression(JuliarParser.AssignmentExpressionContext ctx) {
        AssignmentNode node = new AssignmentNode(null);
        IterateOverContext context = new IterateOverContext(ctx, this, node);
        return node;
    }

    @Override
    public Node visitReassignmentExpression(JuliarParser.ReassignmentExpressionContext ctx) {
        VariableReassignmentNode node = new VariableReassignmentNode();
        new IterateOverContext( ctx, this, node);
        return node;
    }

    @Override
    public Node visitIfExpr(JuliarParser.IfExprContext ctx) {
        IfExprNode node = new IfExprNode();
        Node parent = findFirstNestingNode();
        symbolTable.addLevel( "if" + "_" + ifDeclCount++ );
        iterateWrapper( ctx, this, node);
        symbolTable.popScope();
        return node;
    }

    private Node findFirstNestingNode() {
        Object object[] = funcContextStack.toArray();
        int index = object.length - 1;
        Node parent = null;
        for (; index >0; index--) {
            if(object[index] instanceof FunctionDeclNode || object[index] instanceof IfExprNode){
                parent = (Node)object[index];
            }
        }
        return parent;
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
    public Node visitComparisonOperator(JuliarParser.ComparisonOperatorContext ctx) {
        BooleanOperatorNode booleanOperatorNode = new BooleanOperatorNode();
        new IterateOverContext(ctx, this, booleanOperatorNode);
        return booleanOperatorNode;
    }

    @Override
    public Node visitExpression(JuliarParser.ExpressionContext ctx) {
        ExpressionNode node = new ExpressionNode();
        new IterateOverContext(ctx, this , node);
        return node;
    }

    @Override
    public Node visitVariabledeclartion(JuliarParser.VariabledeclartionContext ctx) {
        VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode();
        new IterateOverContext(ctx, this , variableDeclarationNode);
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
        String variableName = ctx.ID().getText();

        VariableNode variableNode = new VariableNode(variableName, null);

        Object[] funcStackArray =  funcContextStack.toArray();
        int length = funcStackArray.length - 1;
        Boolean isStatement = false;
        Boolean isVariableDecl = false;
        int index = length;
        SymbolTypeEnum symbolTypeEnum = null;

        Node variableDeclarationParent = null;
        for (; index >0; index--){
            if (funcStackArray[index] instanceof VariableDeclarationNode){
                variableDeclarationParent = (VariableDeclarationNode) funcStackArray[ index ];
                // We are creating the variable and adding it to the symbol table.
                // This will automatically throw an exception if creating a symbol with
                // same name at same scope.
                symbolTypeEnum = SymbolTypeEnum.variableDecl;
                continue;
            }

            if ( funcStackArray[index] instanceof PrimitiveNode && isVariableDecl == false){
                continue;
            }

            if ( funcStackArray[index] instanceof IfExprNode){
                if ( symbolTypeEnum != null && symbolTypeEnum == SymbolTypeEnum.variableDecl){
                    symbolTable.addChild( variableNode );
                }
                break;
            }

            if (funcStackArray[index] instanceof FunctionDeclNode){
                symbolTypeEnum = SymbolTypeEnum.variableRef;
                break;
            }
        }

        if (symbolTypeEnum == SymbolTypeEnum.variableDecl ) {
            //symbolTable.addLevel( variableDeclarationParent.getNodeName(), variableName, symbolTypeEnum);
        }
        /*
        else if (!symbolTable.doesSymbolExistAtScope( ((Node) funcStackArray[index]).getNodeName(), variableName ) ){
            //symbolTable.addLevel( ((Node) funcStackArray[index]).getNodeName(), variableName, symbolTypeEnum);
            assert true : "something is wrong";
        }
        */
        return iterateWrapper(ctx, this, variableNode);
    }

    @Override
    public Node visitReturnValue(JuliarParser.ReturnValueContext ctx) {
        ReturnValueNode node = new ReturnValueNode();

        new IterateOverContext(ctx, this, node);

        return node;
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        importBuffer.append( builder );
        skimImports = true;
        importsInterfaceCallback.createTempCallback( importBuffer.toString(), this.currentLineNumber);
    }

    private StringBuilder importBuffer = new StringBuilder();

    class IterateOverContext {

        public IterateOverContext(){
        }

        public IterateOverContext(ParserRuleContext ctx, Visitor visitor, Node parent){
            this();
            iterateOverChildren( ctx, visitor, parent);
        }


        public void iterateOverChildren(ParserRuleContext ctx, Visitor visitor, Node parent) {
            funcContextStack.push( parent );
            for (Iterator<ParseTree> pt = ctx.children.iterator(); pt.hasNext(); ) {
                ParseTree parseTree = pt.next();
                Node node = parseTree.accept( visitor );

                if (node != null) {
                    action(node);
                    parent.AddInst( node );
                }
            }
            funcContextStack.pop();
        }

        /*
         this method will be overriden in implementation.
         */
        public void action(Node node){
        /*
        empty body
        */
        }
    }
}
