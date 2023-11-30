import org.antlr.v4.runtime.tree.TerminalNode;

public class IRGenerator extends SimpleLangBaseVisitor<Void> {
    private StringBuilder irCode = new StringBuilder();

    @Override
    public Void visitExpressionStatement(SimpleLangParser.ExpressionStatementContext ctx) {
        visit(ctx.expression());
        irCode.append("PRINT\n");
        return null;
    }

    @Override
    public Void visitIfStatement(SimpleLangParser.IfStatementContext ctx) {
        visit(ctx.expression());
        int elseLabel = irCode.length();
        irCode.append("JZ #\n");

        for (SimpleLangParser.StatementContext statementContext : ctx.statement()) {
            visit(statementContext);
        }

        if (ctx.ELSE() != null) {
            int endLabel = irCode.length();
            irCode.append("JMP #\n");
            irCode.replace(elseLabel, elseLabel + 1, Integer.toString(elseLabel + 2));
            for (SimpleLangParser.StatementContext statementContext : ctx.statement(1)) {
                visit(statementContext);
            }
            irCode.replace(endLabel, endLabel + 1, Integer.toString(endLabel + 1));
        } else {
            irCode.replace(elseLabel, elseLabel + 1, Integer.toString(irCode.length()));
        }

        return null;
    }

    @Override
    public Void visitExpression(SimpleLangParser.ExpressionContext ctx) {
        if (ctx.INT() != null) {
            irCode.append("PUSH " + ctx.INT().getText() + "\n");
        } else if (ctx.ID() != null) {
            irCode.append("PUSH " + ctx.ID().getText() + "\n");
        } else if (ctx.operator != null) {
            visit(ctx.expression(0));
            visit(ctx.expression(1));
            switch (ctx.operator.getType()) {
                case SimpleLangParser.ADD:
                    irCode.append("ADD\n");
                    break;
                case SimpleLangParser.SUB:
                    irCode.append("SUB\n");
                    break;
                case SimpleLangParser.MUL:
                    irCode.append("MUL\n");
                    break;
                case SimpleLangParser.DIV:
                    irCode.append("DIV\n");
                    break;
            }
        }
        return null;
    }

    public String getIRCode() {
        return irCode.toString();
    }
}
