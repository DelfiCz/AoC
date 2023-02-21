package days;

import importer.AdventOfCodeInputImporter;

import java.io.IOException;

public abstract class AbstractDay {

    private final int year;
    private final int day;
    private final int input;

    protected AbstractDay(int year, int day, int input) {
        this.year = year;
        this.day = day;
        this.input = input;
    }

    public abstract long solution(AdventOfCodeInputImporter input);

    public void printSolution() {
        try {
            AdventOfCodeInputImporter input = new AdventOfCodeInputImporter(this.getYear(), this.getDay(), this.getInput());
            long solutionResult = this.solution(input);
            input.close();
            System.out.printf("Solution for year %d, day %d, part %d: %d%n", year, day, this.input, solutionResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    public int getInput() {
        return input;
    }
}
