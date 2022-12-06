import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {
    public static int part1(List<String> lines) {
        // We only have one line in our input
        String line = lines.get(0);
        return findFirstMarker(line, 4);
    }

    public static int part2(List<String> lines) {
        // We only have one line in our input
        String line = lines.get(0);
        return findFirstMarker(line, 14);
    }

    private static int findFirstMarker(String line, int uniqueNumberOfCharacters) {
        Set<Character> seenCharactersInCurrentWindow = new HashSet<>();
        for (int i = 0; i < line.length() - uniqueNumberOfCharacters; i++) {
            seenCharactersInCurrentWindow.clear();
            for (int j = i; j < i + uniqueNumberOfCharacters; j++) {
                char currentCharacter = line.charAt(j);
                if (seenCharactersInCurrentWindow.contains(currentCharacter)) {
                    break;
                } else {
                    seenCharactersInCurrentWindow.add(currentCharacter);
                    if (seenCharactersInCurrentWindow.size() == uniqueNumberOfCharacters) {
                        return j + 1;
                    }
                }
            }
        }
        return -1;
    }
}
