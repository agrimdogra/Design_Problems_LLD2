package designProblems.tictactoe.Strategies.winningStratergy;

import designProblems.tictactoe.Models.Board;
import designProblems.tictactoe.Models.BoardCell;
import designProblems.tictactoe.Models.Symbol;

public interface WinningStrategy {
    public boolean checkWin(Board board, BoardCell move);
}
