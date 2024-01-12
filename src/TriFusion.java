import java.util.Arrays;

class TriFusion {
    Integer[] sort(Integer... input) {
        if (input.length == 1) return new Integer[]{input[0]};
        if (input.length == 2) return sort(input[0], input[1]);
        int middle = input.length / 2;
        Integer[] part1 = Arrays.copyOfRange(input, 0, middle);
        Integer[] part2 = Arrays.copyOfRange(input, middle, input.length);
        return sort(sort(part1), sort(part2));
    }

    private Integer[] sort(Integer[] part1, Integer[] part2) {
        Integer[] result = new Integer[part1.length + part2.length];
        Integer[] indexes = new Integer[]{0, 0};
        for (int i = 0; i < result.length; i++)
            mergeCurrentNumber(result, i, part1, part2, indexes);
        return result;
    }

    private void mergeCurrentNumber(Integer[] result, int i, Integer[] part1, Integer[] part2, Integer[] indexes) {
        final boolean currentNumberIsMerged = mergeCurrentNumberFromPart0(result, i, part1, part2, indexes);
        if (currentNumberIsMerged) return;
        mergeCurrentNumberFromPart1(result, i, part1, part2, indexes);
    }

    private void mergeCurrentNumberFromPart1(Integer[] result, int i, Integer[] part1, Integer[] part2, Integer[] indexes) {
        if (canMergeFromPart0(part1, part2, indexes)) return;
        indexes[1] = chooseNumberFrom(part2, result, i, indexes[1]);
    }

    private boolean mergeCurrentNumberFromPart0(Integer[] result, int i, Integer[] part1, Integer[] part2, Integer[] indexes) {
        if (!canMergeFromPart0(part1, part2, indexes)) return false;
        indexes[0] = chooseNumberFrom(part1, result, i, indexes[0]);
        return true;
    }

    private boolean canMergeFromPart0(Integer[] part1, Integer[] part2, Integer[] indexes) {
        if (indexes[0] >= part1.length) return false;
        if (indexes[1] >= part2.length) return true;
        return part1[indexes[0]] < part2[indexes[1]];
    }

    private int chooseNumberFrom(Integer[] part, Integer[] result, int i, int partIdx) {
        result[i] = part[partIdx];
        partIdx++;
        return partIdx;
    }

    private Integer[] sort(int input1, int input2) {
        if (input1 > input2) return new Integer[]{input2, input1};
        return new Integer[]{input1, input2};
    }
}
