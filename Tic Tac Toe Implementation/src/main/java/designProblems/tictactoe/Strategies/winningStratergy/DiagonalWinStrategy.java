package designProblems.tictactoe.Strategies.winningStratergy;

import designProblems.tictactoe.Models.Board;
import designProblems.tictactoe.Models.BoardCell;
import designProblems.tictactoe.Models.Symbol;

public class DiagonalWinStrategy implements WinningStrategy{
    @Override
    public boolean checkWin(Board board, BoardCell move) {
        boolean b = checkDiagonal1(board,move);
        boolean b2 = checkDiagonal2(board,move);
        return(b || b2);
    }

    private boolean checkDiagonal2(Board board, BoardCell move) {
        int size = board.getSize();
        int row = size-1;
        int col = 0;

        while(row >= 0){
            if(!(board.getCells().get(row).get(col).getSymbol() == move.getSymbol()))
                return false;
            else {
                row -= 1;
                col += 1;
            }
        }
        return true;
    }

    private boolean checkDiagonal1(Board board, BoardCell move) {
        int size = board.getSize();
        if (!(move.getRow()== move.getColumn()))
            return false;
        for(int row=0; row<size; row++){
            if (!(board.getCells().get(row).get(row).getSymbol() == move.getSymbol()))
                return false;
        }
        return true;
    }
}
