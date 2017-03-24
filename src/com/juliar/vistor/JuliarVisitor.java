package com.juliar.vistor;

import com.juliar.ImportsInterface;
import com.juliar.codegenerator.InstructionInvocation;
import com.juliar.controlflow.ControlFlowAdjacencyList;
import com.juliar.errors.LogMessage;
import com.juliar.nodes.*;
import com.juliar.pal.Primitives;
import com.juliar.parser.juliarBaseVisitor;
import com.juliar.parser.juliarParser;
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
public class JuliarVisitor extends juliarBaseVisitor<Node>
{
    private List<Node> instructionList = new ArrayList<>();
    private HashMap<String, Node> functionNodeMap = new HashMap<String, Node>();
    private Stack<Node> funcContextStack = new Stack<Node>();
    private Queue<String> callStack = new ArrayDeque<>();
    private SymbolTable symbolTable = SymbolTable.CreateSymbolTable();
    private ControlFlowAdjacencyList cfa = new ControlFlowAdjacencyList();
    private ImportsInterface importsInterfaceCallback;
    private boolean skimImports = false;
    private int currentLineNumber = 0;

    public InstructionInvocation instructions(){
        return new InstructionInvocation(instructionList, functionNodeMap);
    }

    public JuliarVisitor(ImportsInterface cb, boolean skip){
        importsInterfaceCallback = cb;
        skimImports = skip;
    }

    @Override
    public Node visitCompileUnit(juliarParser.CompileUnitContext ctx) {

        CompliationUnitNode node = new CompliationUnitNode();

        new IterateOverContext(ctx, this, node);

        instructionList.add(node);
        cfa.walkGraph();
        symbolTable.dumpSymbolTable();

        return node;
    }

    @Override
    public Node visitStatement(juliarParser.StatementContext ctx) {
        StatementNode node = new StatementNode();
        /*
        for (ParseTree t : ctx.children){
            if (t instanceof juliarParser.EndLineContext){
                continue;
            }

            currentLineNumber = ctx.start.getLine();
            t.accept(this);
        }
        */

        new IterateOverContext(ctx, this, node);

        return node;
    }




    @Override
    public Node visitEndLine(juliarParser.EndLineContext ctx) {
        for(ParseTree t : ctx.children){
            t.accept(this);
        }
        return null;
    }


    //TODO need to refactor and combine vistAdd and visitSubtract
    @Override
    public Node visitAdd(juliarParser.AddContext ctx) {

        String text = ctx.summation().getText();
        if (text.equals("add") || text.equals("+")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                    functionDeclNode.AddInst(node.MakeNode(
                            Operation.add,
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
                AggregateNode aggregateNode = new AggregateNode(Operation.add, data);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }
        return null;
    }

    @Override
    public Node visitSubtract(juliarParser.SubtractContext ctx) {
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
    public Node visitFunctionDeclaration(juliarParser.FunctionDeclarationContext ctx) {
        String funcName = ctx.funcName().getText();
        FunctionDeclNode functionDeclNode = new FunctionDeclNode(funcName, new ArrayList<Node>());

        callStack.add( funcName );
        symbolTable.AddLevel( callStack.peek(), funcName, SymbolTypeEnum.functionDecl);

        new IterateOverContext(ctx, this, functionDeclNode);

        callStack.remove();

        functionNodeMap.put(funcName, functionDeclNode);

        return functionDeclNode;
    }

    @Override
    public Node visitFunctionCall(juliarParser.FunctionCallContext ctx) {
        /*
        Node parent = funcContextStack.peek();
        String caller = null;

        if (parent instanceof  FunctionDeclNode) {
            caller = ((FunctionDeclNode) parent).getFunctionName();
        }

        if (parent instanceof  AssignmentNode){
            caller = "assignment";//((AssignmentNode) parent).getVariableNode().variableName;
        }

        String callee = ctx.funcName().ID().getText();
        cfa.addNode( caller, callee);

        FunctionCallNode node = new FunctionCallNode( callee );
        node.AddInst(funcContextStack , node);
        */
        FunctionCallNode node = new FunctionCallNode();
        new IterateOverContext(ctx, this, node);

        return node;
    }

    @Override
    public Node visitEqualequal(juliarParser.EqualequalContext ctx){
        //ifeq or if_acmpeq
        /*String text = ctx.().getText();
        if (text.equals("add") || text.equals("+")){
            if (ctx.types().size() == 2) {
                BinaryNode node = new BinaryNode();
                try {
                    FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                    functionDeclNode.AddInst(node.MakeNode(
                            Operation.add,
                            ctx.types(0).accept(this),
                            ctx.types(1).accept(this)));
                }catch( Exception ex){
                    new PrintError(ex.getMessage(),ex);
                }
            }

            if (ctx.types().size() > 2){
                List<IntegralTypeNode> getIntegralValue = new ArrayList<>();

                for ( int i = 0; i< ctx.types().size(); i++) {
                    getIntegralValue.add((IntegralTypeNode) ctx.types(i).accept(this));
                }
                AggregateNode aggregateNode = new AggregateNode(Operation.add, getIntegralValue);

                FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();
                functionDeclNode.AddInst( aggregateNode );
            }
        }
        return null;*/
        return null;

    }

    @Override
    public Node visitLessthan(juliarParser.LessthanContext ctx){
        //if_icmplt
        return null;
    }
    @Override
    public Node visitGreaterthan(juliarParser.GreaterthanContext ctx){
        //if_icmpgt
        return null;
    }
    @Override
    public Node visitLessthanorequalto(juliarParser.LessthanorequaltoContext ctx){

        //if_icmple
        return null;
    }
    @Override
    public Node visitGreaterthanorequalto(juliarParser.GreaterthanorequaltoContext ctx){
        //if_icmpge
        return null;
    }
    @Override
    public Node visitThreeway(juliarParser.ThreewayContext ctx){
        return null;
    }

    public Node visitModulo(juliarParser.ModuloContext ctx) {

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

        //return super.visitAdd(ctx);
        return null;
    }
    @Override
    public Node visitDivide(juliarParser.DivideContext ctx) {

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

        //return super.visitAdd(ctx);
        return null;
    }


    @Override
    public Node visitMultiply(juliarParser.MultiplyContext ctx) {

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
    public Node visitTypes(juliarParser.TypesContext ctx) {
        //IntegralTypeNode integralTypeNode = new IntegralTypeNode();
        IterateOverContext context = new IterateOverContext(){
            @Override
            public void action(Node node) {
                if (node instanceof JTerminalNode) {
                    IntegralType integralType = ((JTerminalNode)node).getIntegralType();
                    int x = 2;
                }
            }
        };
   //     context.iterateOverChildren( ctx.primitiveTypes(), this, );
   //     IntegralTypeNode itn = new IntegralTypeNode(null);
        return null;
    }



    @Override
    public Node visitPrimitives(juliarParser.PrimitivesContext ctx) {
        if (ctx != null) {

            FunctionDeclNode functionDeclNode = (FunctionDeclNode) funcContextStack.peek();

            PrimitiveNode primitiveNode = new PrimitiveNode();

            IterateOverContext context = new IterateOverContext() {
                @Override
                public void action(Node pt) {
                    primitiveNode.AddInst(pt);
                }
            };

      //      context.iterateOverChildren( ctx, this );

            functionDeclNode.AddInst( primitiveNode );
        }

        return null;
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

        JTerminalNode terminalNode = new JTerminalNode(node);

        IterateOverContext context = new IterateOverContext() {
            @Override
            public void action(Node pt) {
                terminalNode.AddInst(pt);
            }
        };

        //context.iterateOverChildren( node, this );
        return new JTerminalNode(node);
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

    @Override
    public Node visitAssignmentExpression(juliarParser.AssignmentExpressionContext ctx) {
        //String operator = ctx.equalsign().getText();
        AssignmentNode node = new AssignmentNode(null);

        IterateOverContext context = new IterateOverContext();

        context.iterateOverChildren( ctx, this, node);

        //funcContextStack.pop();
        //node.AddInst(funcContextStack, node);

        return node;
    }

    @Override
    public Node visitNumericTypes(juliarParser.NumericTypesContext ctx) {
        return super.visitNumericTypes(ctx);
    }

    @Override
    public Node visitPrimitiveTypes(juliarParser.PrimitiveTypesContext ctx) {
        PrimitiveNode node = new PrimitiveNode();
        new IterateOverContext(ctx, this, node);
        return node;
    }

    @Override
    public Node visitEqualsign(juliarParser.EqualsignContext ctx) {
        return new EqualSignNode();
    }

    @Override
    public Node visitExpression(juliarParser.ExpressionContext ctx) {
        return super.visitExpression(ctx);
    }

    @Override
    public Node visitVariabledeclartion(juliarParser.VariabledeclartionContext ctx) {
        VariableDeclarationNode variableDeclarationNode = new VariableDeclarationNode();
        new IterateOverContext(ctx, this , variableDeclarationNode);
        return variableDeclarationNode;
    }

    @Override
    public Node visitKeywords(juliarParser.KeywordsContext ctx) {

        KeywordNode keywordNode = new KeywordNode();
        new IterateOverContext(ctx, this, keywordNode);

        return keywordNode;
    }

    @Override
    public Node visitVariable(juliarParser.VariableContext ctx) {
        String variableName = ctx.ID().getText();

        VariableNode variableNode = new VariableNode(variableName, null);

        symbolTable.AddLevel(callStack.peek(), variableName, SymbolTypeEnum.variableDecl);
        new IterateOverContext(ctx, this, variableNode);

        return variableNode;
    }

    @Override
    public Node visitReturnValue(juliarParser.ReturnValueContext ctx) {
        ReturnValueNode valueNode = null;

        if (ctx.variable() != null) {
            valueNode = new ReturnValueNode( SymbolTypeEnum.variableRef, ctx.variable().getText());
        }
        else if(ctx.functionCall() != null) {
            valueNode = new ReturnValueNode(SymbolTypeEnum.functionCall, ctx.functionCall().getText());
        }

        funcContextStack.peek().AddInst( valueNode );

        return null;
    }






    class IterateOverContext {
        public String name;
        public Node data;

        public IterateOverContext(){
        }

        public IterateOverContext(ParserRuleContext ctx, JuliarVisitor visitor, Node parent){
            this();
            iterateOverChildren( ctx, visitor, parent);
        }

        public void iterateOverChildren(ParserRuleContext ctx, JuliarVisitor visitor, Node parent) {
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
