package days;

import importer.AdventOfCodeInputImporter;


import java.util.Map;

public class Day02 extends AbstractDay{

    public Day02() {
        super(2022, 2, 1);
    }

    enum RPS {
        ROCK, PAPER, SCISSORS
    }

    private static final Map<String, RPS> rpsMap = Map.of(
            "A", RPS.ROCK,
            "B", RPS.PAPER,
            "C", RPS.SCISSORS,
            "X", RPS.ROCK,
            "Y", RPS.PAPER,
            "Z", RPS.SCISSORS
    );

    /* RPS matrix, win = 6, draw = 3, lose = 0 and choosing Rock = 1, Paper = 2, Scissors = 3
    * Oponent plays ->       Rock     Paper    Scissors
    * Player plays rock     3 + 1     0 + 1     6 + 1
    * Player plays paper    6 + 2     3 + 2     0 + 2
    * Player plays scissors 0 + 3     6 + 3     3 + 3
    */
    private static Map<RPS, Map<RPS, Integer>> rpsScoreMatrix = Map.of(
            RPS.ROCK, Map.of(RPS.ROCK, 4, RPS.PAPER, 1, RPS.SCISSORS, 7),
            RPS.PAPER, Map.of(RPS.ROCK, 8, RPS.PAPER, 5, RPS.SCISSORS, 2),
            RPS.SCISSORS, Map.of(RPS.ROCK, 3, RPS.PAPER, 9, RPS.SCISSORS, 6)
    );

    @Override
    public long solution(AdventOfCodeInputImporter input) {
        String line;
        int score = 0;
        while ((line = input.readLine()) != null) {
            String[] move = line.split(" ");
            score += rpsScoreMatrix.get(rpsMap.get(move[1])).get(rpsMap.get(move[0]));
        }

        return score;
    }


}
