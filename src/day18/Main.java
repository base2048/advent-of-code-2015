package day18;

import utils.Timer;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Challenge challenge = new Challenge(Parser.parse(new File("./src/day18/data.txt")));

        Timer.startTimer();
        System.out.print("Result part 1: " + challenge.solvePart1() + " | ");   // 814
        Timer.printTimer(1);

        Timer.startTimer();
        System.out.print("Result part 2: " + challenge.solvePart2() + " | ");   // 924
        Timer.printTimer(2);

    }
}
