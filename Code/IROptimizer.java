import java.util.ArrayList;
import java.util.List;

public class IROptimizer {
    public static String optimize(String irCode) {
        List<String> instructions = new ArrayList<>();
        StringBuilder optimizedIR = new StringBuilder();

        String[] lines = irCode.split("\n");
        for (String line : lines) {
            instructions.add(line.trim());
        }

        for (int i = 0; i < instructions.size(); i++) {
            String currentInstruction = instructions.get(i);
            optimizedIR.append(currentInstruction).append("\n");

            if (currentInstruction.startsWith("PUSH")) {
                int nextIndex = i + 1;
                if (nextIndex < instructions.size()) {
                    String nextInstruction = instructions.get(nextIndex);

                    if (nextInstruction.equals("POP") || nextInstruction.startsWith("STORE")) {
                        optimizedIR.delete(optimizedIR.lastIndexOf("PUSH"), optimizedIR.length());
                    }
                }
            }
        }

        return optimizedIR.toString();
    }
}
