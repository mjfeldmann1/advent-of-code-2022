import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Day5 {
    public static String part1(List<String> lines) {
        List<Stack<Character>> stacks = createInitialStacks();
        for (String line : lines) {
            int quantityToMove = parseQuantityToMove(line);
            int stackFrom = parseStackFrom(line);
            int stackTo = parseStackTo(line);

            for (int i = 0; i < quantityToMove; i++) {
                stacks.get(stackTo).push(stacks.get(stackFrom).pop());
            }
        }
        return getTopOfEachStack(stacks);
    }

    public static String part2(List<String> lines) {
        List<Stack<Character>> stacks = createInitialStacks();
        for (String line : lines) {
            int quantityToMove = parseQuantityToMove(line);
            int stackFrom = parseStackFrom(line);
            int stackTo = parseStackTo(line);

            Stack<Character> tempStack = new Stack<>();
            for (int i = 0; i < quantityToMove; i++) {
                tempStack.push(stacks.get(stackFrom).pop());
            }
            while (!tempStack.isEmpty()) {
                stacks.get(stackTo).push(tempStack.pop());
            }
        }
        return getTopOfEachStack(stacks);
    }

    private static String getTopOfEachStack(List<Stack<Character>> stacks) {
        StringBuilder topOfEachStackStringBuilder = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            topOfEachStackStringBuilder.append(stack.peek());
        }
        return topOfEachStackStringBuilder.toString();
    }

    private static int parseQuantityToMove(String line) {
        return Integer.parseInt(line.split(" from ")[0].split(" ")[1]);
    }

    private static int parseStackFrom(String line) {
        return Integer.parseInt(line.split(" from ")[1].split(" to ")[0]) - 1;
    }

    private static int parseStackTo(String line) {
        return Integer.parseInt(line.split(" from ")[1].split(" to ")[1]) - 1;
    }

    private static List<Stack<Character>> createInitialStacks() {
        Stack<Character> stack1 = createStackWithCharacters(Arrays.asList('Z', 'P', 'M', 'H', 'R'));
        Stack<Character> stack2 = createStackWithCharacters(Arrays.asList('P', 'C', 'J', 'B'));
        Stack<Character> stack3 = createStackWithCharacters(Arrays.asList('S', 'N', 'H', 'G', 'L', 'C', 'D'));
        Stack<Character> stack4 = createStackWithCharacters(Arrays.asList('F', 'T', 'M', 'D', 'Q', 'S', 'R', 'L'));
        Stack<Character> stack5 = createStackWithCharacters(Arrays.asList('F', 'S', 'P', 'Q', 'B', 'T', 'Z', 'M'));
        Stack<Character> stack6 = createStackWithCharacters(Arrays.asList('T', 'F', 'S', 'Z', 'B', 'G'));
        Stack<Character> stack7 = createStackWithCharacters(Arrays.asList('N', 'R', 'V'));
        Stack<Character> stack8 = createStackWithCharacters(Arrays.asList('P', 'G', 'L', 'T', 'D', 'V', 'C', 'M'));
        Stack<Character> stack9 = createStackWithCharacters(Arrays.asList('W', 'Q', 'N', 'J', 'F', 'M', 'L'));

        return new ArrayList<>(Arrays.asList(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9));
    }

    private static Stack<Character> createStackWithCharacters(List<Character> characters) {
        Stack<Character> stack = new Stack<>();
        for (Character character : characters) {
            stack.push(character);
        }
        return stack;
    }
}
