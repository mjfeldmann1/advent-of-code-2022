import java.util.ArrayList;
import java.util.List;

public class Day4 {
    public static int part1(List<String> lines) {
        List<RangePair> rangePairs = new ArrayList<>();
        for (String line : lines) {
            rangePairs.add(lineToRangePair(line));
        }

        int numFullyOverlappingRanges = 0;
        for (RangePair rangePair : rangePairs) {
            numFullyOverlappingRanges += rangePair.hasFullyOverlappingRange() ? 1 : 0;
        }
        return numFullyOverlappingRanges;
    }

    public static int part2(List<String> lines) {
        List<RangePair> rangePairs = new ArrayList<>();
        for (String line : lines) {
            rangePairs.add(lineToRangePair(line));
        }

        int numPartiallyOverlappingRanges = 0;
        for (RangePair rangePair : rangePairs) {
            numPartiallyOverlappingRanges += rangePair.hasPartiallyOverlappingRange() ? 1 : 0;
        }
        return numPartiallyOverlappingRanges;
    }

    private static RangePair lineToRangePair(String line) {
        String[] rangeStrings = line.split(",");
        String[] firstRangeValues = rangeStrings[0].split("-");
        int firstRangeStart = Integer.parseInt(firstRangeValues[0]);
        int firstRangeEnd = Integer.parseInt(firstRangeValues[1]);
        Range firstRange = new Range(firstRangeStart, firstRangeEnd);

        String[] secondRangeValues = rangeStrings[1].split("-");
        int secondRangeStart = Integer.parseInt(secondRangeValues[0]);
        int secondRangeEnd = Integer.parseInt(secondRangeValues[1]);
        Range secondRange = new Range(secondRangeStart, secondRangeEnd);

        return new RangePair(firstRange, secondRange);
    }
}

class RangePair {
    Range firstRange;
    Range secondRange;
    public RangePair(Range firstRange, Range secondRange) {
        this.firstRange = firstRange;
        this.secondRange = secondRange;
    }

    public boolean hasFullyOverlappingRange() {
        return firstRange.fullyContainsRange(secondRange) || secondRange.fullyContainsRange(firstRange);
    }

    public boolean hasPartiallyOverlappingRange() {
        return firstRange.partiallyContainsRange(secondRange);
    }
}

class Range {
    int start;
    int end;
    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean fullyContainsRange(Range otherRange) {
        return (otherRange.start >= start && otherRange.end <= end);
    }

    boolean partiallyContainsRange(Range otherRange) {
        return !((otherRange.start > end && otherRange.end > end) || (otherRange.start < start && otherRange.end < start));
    }
}
