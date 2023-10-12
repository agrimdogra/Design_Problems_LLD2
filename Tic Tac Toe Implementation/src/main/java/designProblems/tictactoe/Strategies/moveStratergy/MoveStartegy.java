package designProblems.tictactoe.Strategies.moveStratergy;

import designProblems.tictactoe.Models.Board;
import designProblems.tictactoe.Models.BoardCell;

public interface MoveStartegy {
    public BoardCell makeMove(Board board);
}
