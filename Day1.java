import java.util.List;
import java.util.PriorityQueue;

public class Day1 {
    static int getCalorieSum(List<String> lines, int numberOfSums) {
        PriorityQueue<Integer> largestSums = new PriorityQueue<>();
        int currentCalorieCount = 0;
        for (String line: lines) {
            if (isLineEmpty(line)) {
                largestSums.add(currentCalorieCount);
                if (largestSums.size() > numberOfSums) {
                    largestSums.remove();
                }
                currentCalorieCount = 0;
            } else {
                currentCalorieCount += Integer.parseInt(line);
            }
        }
        return largestSums.stream().reduce(0, Integer::sum);
    }

    private static boolean isLineEmpty(String line) {
        return line.equals("");
    }
}
