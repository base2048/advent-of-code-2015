package day24;

import java.util.*;

public class Challenge {

    private final List<Integer> packages;
    private final int totalWeight;

    public Challenge(List<Integer> packages) {
        this.packages = packages;
        this.packages.sort((a, b) -> b - a);
        this.totalWeight = packages.stream().mapToInt(Integer::intValue).sum();
    }

    public long solvePart1() {
        int targetWeight = totalWeight / 3;
        return getQE(packages, 0, 1, targetWeight).qe;
    }

    public long solvePart2() {
        int targetWeight = totalWeight / 4;
        return getQE(packages, 0, 1, targetWeight).qe;
    }

    private Pair getQE(List<Integer> packages, int currentPackageCtr, long currentQE, int remainingWeight) {
        if (remainingWeight == 0) return new Pair(currentPackageCtr, currentQE);

        if (remainingWeight < 0) return new Pair(Integer.MAX_VALUE, Long.MAX_VALUE);
        if (packages.size() == 0) return new Pair(Integer.MAX_VALUE, Long.MAX_VALUE);

        List<Integer> trimmedPackages = packages.subList(1, packages.size());
        Pair crawler = getQE(trimmedPackages, currentPackageCtr, currentQE, remainingWeight);
        Pair collector = getQE(trimmedPackages,
                currentPackageCtr + 1,
                currentQE * packages.get(0),
                remainingWeight - packages.get(0));

        if (crawler.ctr < collector.ctr) return crawler;
        if (crawler.ctr > collector.ctr) return collector;
        return crawler.qe < collector.qe ? crawler : collector;
    }

    private static class Pair {
        int ctr;
        long qe;

        public Pair(int ctr, long qe) {
            this.ctr = ctr;
            this.qe = qe;
        }
    }
}
