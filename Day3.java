import java.util.*;
import java.util.stream.Collectors;

public class Day3 {

    public static int part1(List<String> lines) {
        List<Character> duplicateLetters = new ArrayList<>();
        for (String line : lines) {
            duplicateLetters.add(findDuplicateCharacter(line));
        }
        int sum = 0;
        for (Character letter : duplicateLetters) {
            sum += getLetterPriority(letter);
        }
        return sum;
    }

    // Each List<String> in groups has a size of 3
    public static int part2(List<List<String>> groups) {
        List<Character> lettersInCommon = new ArrayList<>();
        for (List<String> group : groups) {
            lettersInCommon.add(findLetterInCommon(group));
        }
        int sum = 0;
        for (Character letter : lettersInCommon) {
            sum += getLetterPriority(letter);
        }
        return sum;
    }

    private static char findLetterInCommon(List<String> group) {
        // We'll store letters as our keys and how many times we have
        // uniquely seen the letter in each group as our value
        Map<Character, Integer> letterToQuantityMap = new HashMap<>();

        for (String rucksack : group) {
            // Keep track of seen characters for each rucksack so we only
            // add non-duplicate letters to our letterToQuantityMap
            Set<Character> seenCharacters = new HashSet<>();

            for (char letter : rucksack.toCharArray()) {
                if (!seenCharacters.contains(letter)) {
                    int quantity = letterToQuantityMap.getOrDefault(letter, 0);
                    letterToQuantityMap.put(letter, ++quantity);
                }
                seenCharacters.add(letter);
            }
        }
        // Find the entry with a value equal to the size of our group (each group contained
        // that character)
        return letterToQuantityMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == group.size())
                .collect(Collectors.toList())
                .get(0)
                .getKey();
    }

    private static char findDuplicateCharacter(String line) {
        String firstHalf = line.substring(0, line.length() / 2);
        String secondHalf = line.substring(line.length() / 2);
        Set<Character> firstHalfUniqueCharacters = new HashSet<>();
        for (char letter : firstHalf.toCharArray()) {
            firstHalfUniqueCharacters.add(letter);
        }
        for (char letter : secondHalf.toCharArray()) {
            if (firstHalfUniqueCharacters.contains(letter)) {
                return letter;
            }
        }
        throw new IllegalArgumentException("Invalid line - must contain duplicate character in each half");
    }

    // A-Z characters are 65-90 in int form
    // a-z characters are 97-122 in int form
    // We need to return 1-26 for a-z and
    // 27-52 for A-Z
    public static int getLetterPriority(char letter) {
        if (Character.isUpperCase(letter)) {
            return letter - 38;
        } else {
            return letter - 96;
        }
    }
}
