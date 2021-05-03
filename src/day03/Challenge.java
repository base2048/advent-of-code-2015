package day03;

import java.util.*;

public class Challenge {

    private final List<Character> moves;

    public Challenge(List<Character> moves) {
        this.moves = moves;
    }

    public int solvePart1() {
        Set<Integer> visited = new HashSet<>();
        int[] position = new int[]{0, 0};

        visited.add(calculatePositionHash(position));
        moves.forEach(move -> visited.add(calculatePositionHash(this.move(move, position))));

        return visited.size();
    }

    public int solvePart2() {
        Set<Integer> visited = new HashSet<>();

        int[] positionBinarySanta = new int[]{0, 0};
        int[] positionOrganicSanta = new int[]{0, 0};
        visited.add(calculatePositionHash(positionBinarySanta));

        for (int i = 0; i < moves.size(); i++)
            visited.add(i % 2 == 0
                    ? calculatePositionHash(move(moves.get(i), positionBinarySanta))
                    : calculatePositionHash(move(moves.get(i), positionOrganicSanta)));

        return visited.size();
    }

    private int[] move(Character move, int[] position) {
        switch (move) {
            case '>' -> position[0]++;
            case 'v' -> position[1]++;
            case '<' -> position[0]--;
            case '^' -> position[1]--;
        }
        return position;
    }

    private Integer calculatePositionHash(int[] position) {
        return position[0] + (position[1] << 12);
    }
}
