package designProblems.tictactoe.Strategies.winningStratergy;

import designProblems.tictactoe.Models.Board;
import designProblems.tictactoe.Models.BoardCell;
import designProblems.tictactoe.Models.Symbol;

public class ColumnWinStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, BoardCell move) {
        int col = move.getColumn();
        int size = board.getSize();
        Symbol symbol = move.getSymbol();
        for (int row=0; row<size; row++){
            if ( !(board.getCells().get(row).get(col).getSymbol() == symbol )  )
                return false;
        }
        return true;
    }
}
