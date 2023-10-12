package designProblems.tictactoe.Strategies.moveStratergy;

import designProblems.tictactoe.Models.Board;
import designProblems.tictactoe.Models.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements MoveStartegy {
    @Override
    public BoardCell makeMove(Board board) {
        // Get List of empty cells
        List<BoardCell> emptyCells = board.getEmptyCells();

        //Select a random cell;
        int number = (int) (Math.random() * emptyCells.size() );
        BoardCell cell = emptyCells.get(number);
        return new BoardCell(cell.getRow(), cell.getColumn());
    }
}
