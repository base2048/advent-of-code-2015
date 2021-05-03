package day25;

public class Challenge {

    private final int x, y;
    private final int code = 20151125;

    public Challenge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Challenge(int[] coordsXY) {
        this.x = coordsXY[0];
        this.y = coordsXY[1];
    }

    public long solvePart1() {
        return getCode(x, y);
    }

    public String solvePart2() {
        return "Großvati, es hat geschneit!";
    }

    private long getCode(int targetX, int targetY) {
        int currX = 1;
        int currY = 1;
        long currentValue = code;

        while (!(currX == targetX && currY == targetY)) {
            currX++;
            currY--;

            if (currY == 0) {
                currY = currX;
                currX = 1;
            }

            currentValue = (currentValue * 252533) % 33554393;
        }
        return currentValue;
    }
}
