import java.util.ArrayDeque;
import java.util.Deque;

public class IRExecutor {
    public static void execute(String irCode) {
        String[] instructions = irCode.split("\n");
        Deque<Integer> stack = new ArrayDeque<>();

        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");
            switch (parts[0]) {
                case "PUSH":
                    stack.push(Integer.parseInt(parts[1]));
                    break;
                case "ADD":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "SUB":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "MUL":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "DIV":
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    stack.push(dividend / divisor);
                    break;
                case "JZ":
                    if (stack.pop() == 0) {
                        int jumpTarget = Integer.parseInt(parts[1]);
                        if (jumpTarget < instructions.length) {
                            int newInstructionIndex = jumpTarget - 1;
                            continue;
                        }
                    }
                    break;
                case "JMP":
                    int jumpTarget = Integer.parseInt(parts[1]);
                    if (jumpTarget < instructions.length) {
                        int newInstructionIndex = jumpTarget - 1;
                        continue;
                    }
                    break;
                case "PRINT":
                    System.out.println("Resultado: " + stack.peek());
                    break;
            }
        }
    }
}
