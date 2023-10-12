package designProblems.tictactoe.Strategies.winningStratergy;

import designProblems.tictactoe.Models.Board;
import designProblems.tictactoe.Models.BoardCell;
import designProblems.tictactoe.Models.Symbol;

public class RowWinStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, BoardCell move) {
        int row = move.getRow();;
        int size = board.getSize();

        for (int c = 0; c< size; c++){
            if(! (board.getCells().get(row).get(c).getSymbol() == move.getSymbol()) ){
                return false;
            }

        }
        return true;
    }
}
