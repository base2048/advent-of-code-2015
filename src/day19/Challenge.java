package day19;

import java.util.*;
import java.util.regex.*;

public class Challenge {

    private String inputMolecule;
    private List<Replacement> replacements;

    public Challenge(Object data) {
        try {
            this.inputMolecule = (String) data.getClass().getDeclaredField("molecule").get(data);
            this.replacements = (List<Replacement>) data.getClass().getDeclaredField("replacements").get(data);
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
        }
    }

    public int solvePart1() {
        return getDistinctMolecules().size();
    }

    public int solvePart2() {
        return getStepCounts();
    }

    public Set<String> getDistinctMolecules() {
        Set<String> molecules = new HashSet<>();

        for (Replacement rep : replacements) {
            Matcher matcher = Pattern.compile(rep.original).matcher(inputMolecule);
            while (matcher.find())
                molecules.add(inputMolecule.substring(0, matcher.start()) + rep.substitute + inputMolecule.substring(matcher.end()));
        }
        return molecules;
    }

    /*
     * Brute force solution not capable to solve in proper time.
     * Reverse engineering works only for this challenge.
     * Test input data will end in infinite loop!
     */
    private int getStepCounts() {
        replacements.sort((r1, r2) -> r2.substitute.length() - r1.substitute.length());
        String molecule = inputMolecule;
        int ctr = 0;

        while (!molecule.equals("e")) {
            for (Replacement rep : replacements) {
                if (molecule.contains(rep.substitute)) {
                    molecule = molecule.replaceFirst(rep.substitute, rep.original);
                    ctr++;
                }
            }
        }
        return ctr;
    }
}
