import java.util.List;

public class Day2 {

    static int part1(List<String> lines) {
        return lines.stream().mapToInt(Day2::getPart1Score).sum();
    }

    static int part2(List<String> lines) {
        return lines.stream().mapToInt(Day2::getPart2Score).sum();
    }

    static int getPart1Score(String codedRockPaperScissorsInput) {
        char myChoice = codedRockPaperScissorsInput.charAt(2);
        char opponentChoice = codedRockPaperScissorsInput.charAt(0);
        return duelResult(myChoice, opponentChoice) + scoreValueOf(myChoice);
    }

    static int getPart2Score(String codedRockPaperScissorsInput) {
        char opponentChoice = codedRockPaperScissorsInput.charAt(0);
        char myChoice = findMyChoice(codedRockPaperScissorsInput.charAt(2), opponentChoice);
        return duelResult(myChoice, opponentChoice) + scoreValueOf(myChoice);
    }

    /**
     * For myCode, X = lose, Y = draw, Z = win
     */
    static char findMyChoice(char myCode, char opponentChoice) {
        if (myCode == 'X') {
            if (opponentChoice == 'A') {
                // Opponent chose rock, so we choose scissors to lose
                return 'Z';
            } else if (opponentChoice == 'B') {
                // Opponent chose paper, so we chose rock to lose
                return 'X';
            } else {
                // Opponent chose scissors, so we choose paper to lose
                return 'Y';
            }
        } else if (myCode == 'Y') {
            if (opponentChoice == 'A') {
                return 'X';
            } else if (opponentChoice == 'B') {
                return 'Y';
            } else {
                return 'Z';
            }
        } else {
            if (opponentChoice == 'C') {
                // Opponent chose scissors, so we choose rock to win
                return 'X';
            } else if (opponentChoice == 'A') {
                // Opponent chose rock, so we choose paper to win
                return 'Y';
            } else {
                // Opponent chose paper, so we choose scissors to win
                return 'Z';
            }
        }
    }

    /**
     * For opponent choice, A = rock, B = paper, C = scissors
     * For my choice, X = rock, Y = paper, Z = scissors
     */
    static int duelResult(char myChoice, char opponentChoice) {
        if (myChoice == 'X') {
            if (opponentChoice == 'A') {
                // Tie (rock vs rock)
                return 3;
            } else if (opponentChoice == 'B') {
                // I lost (rock vs paper)
                return 0;
            } else {
                // I won (rock vs scissors)
                return 6;
            }
        } else if (myChoice == 'Y') {
            if (opponentChoice == 'B') {
                // Tie (paper vs paper)
                return 3;
            } else if (opponentChoice == 'C') {
                // I lost (paper vs scissors)
                return 0;
            } else {
                // I won (paper vs rock)
                return 6;
            }
        } else {
            if (opponentChoice == 'C') {
                // Tie (scissors vs scissors)
                return 3;
            } else if (opponentChoice == 'A') {
                // I lost (scissors vs rock)
                return 0;
            } else {
                // I won (scissors vs paper)
                return 6;
            }
        }
    }

    static int scoreValueOf(char myChoice) {
        switch (myChoice) {
            case 'X': return 1;
            case 'Y': return 2;
            case 'Z': return 3;
            default: return 0;
        }
    }
}
