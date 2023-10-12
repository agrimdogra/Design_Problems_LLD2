package designProblems.tictactoe.Strategies.moveStratergy;

import designProblems.tictactoe.Models.Board;
import designProblems.tictactoe.Models.BoardCell;

import java.util.List;

public class MinMaxMoveStrategy implements MoveStartegy {
    @Override
    public BoardCell makeMove(Board board) {
        return null;
    }

    public static class EmptyCellPlayingStratergy implements MoveStartegy {
        @Override
        public BoardCell makeMove(Board board) {
            List<BoardCell> emptyCells = board.getEmptyCells();
            BoardCell cell = emptyCells.get(0);
            return new BoardCell(cell.getRow(), cell.getColumn());
        }
    }
}
