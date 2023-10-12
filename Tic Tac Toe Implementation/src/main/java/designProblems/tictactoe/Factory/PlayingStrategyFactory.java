package designProblems.tictactoe.Factory;

import designProblems.tictactoe.Models.Level;
import designProblems.tictactoe.Strategies.moveStratergy.FirstCellMoveStrategy;
import designProblems.tictactoe.Strategies.moveStratergy.MoveStartegy;
import designProblems.tictactoe.Strategies.moveStratergy.RandomPlayingStrategy;

public class PlayingStrategyFactory {
    public static MoveStartegy getPlayingStrategy(Level level){
        switch (level){
            case EASY, HARD -> {
                return new RandomPlayingStrategy();
            }
            case MEDIUM -> {
                return new FirstCellMoveStrategy();
            }
            default -> throw new RuntimeException("Not a valid Level");
        }
    }
}
