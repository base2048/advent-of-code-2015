package day20;

public class Challenge {

    private final int targetNumPresents;

    public Challenge(int targetNumPresents) {
        this.targetNumPresents = targetNumPresents;
    }

    public int solvePart1() {
        int[] houseNumbers = new int[1_000_000];

        for (int elf = 1; elf < houseNumbers.length; elf++)
            for (int hnr = elf; hnr < houseNumbers.length; hnr += elf)
                houseNumbers[hnr] += elf * 10;

        /*
         * An immediate comparison is not possible,
         * since houses aren't supplied continuously.
         */
        for (int hnr = 1; hnr < houseNumbers.length; hnr++)
            if (houseNumbers[hnr] >= targetNumPresents) return hnr;

        return 0;
    }

    public int solvePart2() {
        int[] houseNumbers = new int[1_000_000];

        for (int elf = 1; elf < houseNumbers.length; elf++)
            for (int hnr = elf; hnr < elf * 50 + 1; hnr += elf)
                if (hnr < houseNumbers.length) houseNumbers[hnr] += elf * 11;

        for (int hnr = 1; hnr < houseNumbers.length; hnr++)
            if (houseNumbers[hnr] >= targetNumPresents) return hnr;

        return 0;
    }
}
