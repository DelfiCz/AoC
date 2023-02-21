package days;

import importer.AdventOfCodeInputImporter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Day02b extends AbstractDay {

    public Day02b() {
        super(2022, 2, 1);
    }

    enum RPS {
        ROCK, PAPER, SCISSORS
    }

    enum GameState {
        WIN, DRAW, LOSE
    }

    private static final Map<String, RPS> rpsMap = Map.of(
            "A", RPS.ROCK,
            "B", RPS.PAPER,
            "C", RPS.SCISSORS
    );

    private static final Map<String, GameState> gameState = Map.of(
            "X", GameState.LOSE,
            "Y", GameState.DRAW,
            "Z", GameState.WIN
    );

    /* RPS matrix, win = 6, draw = 3, lose = 0 and choosing Rock = 1, Paper = 2, Scissors = 3
    * Oponent plays ->      Rock     Paper    Scissors
    * Player plays win     6 + 2     6 + 3     6 + 1
    * Player plays lose    0 + 3     0 + 1     0 + 2
    * Player plays draw    3 + 1     3 + 2     3 + 3
    */
    private static Map<RPS, Map<GameState, Integer>> rpsScoreMatrix = Map.of(
            RPS.ROCK, Map.of(GameState.WIN, 8, GameState.LOSE, 3, GameState.DRAW, 4),
            RPS.PAPER, Map.of(GameState.WIN, 9, GameState.LOSE, 1, GameState.DRAW, 5),
            RPS.SCISSORS, Map.of(GameState.WIN, 7, GameState.LOSE, 2, GameState.DRAW, 6)
    );

    @Override
    public long solution(AdventOfCodeInputImporter input) {
        String line;
        int score = 0;
        while ((line = input.readLine()) != null) {
            String[] move = line.split(" ");
            score += rpsScoreMatrix.get(rpsMap.get(move[0])).get(gameState.get(move[1]));
        }

        return score;
    }


}
