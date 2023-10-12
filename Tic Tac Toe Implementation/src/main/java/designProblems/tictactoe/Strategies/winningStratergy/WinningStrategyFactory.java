package designProblems.tictactoe.Strategies.winningStratergy;

import java.util.ArrayList;
import java.util.List;

public class WinningStrategyFactory {
    public static List<WinningStrategy> getWinningStrategies(List<WinningTypes> winningTypes){
        List<WinningStrategy> winningStrategies = new ArrayList<>();
        winningTypes
                .forEach(type->{
                    switch (type){
                        case ROW -> winningStrategies.add(new RowWinStrategy());
                        case COLUMN -> winningStrategies.add(new ColumnWinStrategy());
                        case DIAGONAL -> winningStrategies.add(new DiagonalWinStrategy());
                    }
                });
        return winningStrategies;
    }
}
