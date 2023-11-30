import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    public static void main(String[] args) {
        try {
            SimpleLangLexer lexer = new SimpleLangLexer(CharStreams.fromFileName("input.txt"));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SimpleLangParser parser = new SimpleLangParser(tokens);

            SimpleLangParser.ProgramContext programContext = parser.program();

            IRGenerator irGenerator = new IRGenerator();
            irGenerator.visitProgram(programContext);
            String irCode = irGenerator.getIRCode();

            String optimizedIRCode = IROptimizer.optimize(irCode);

            IRExecutor.execute(optimizedIRCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
