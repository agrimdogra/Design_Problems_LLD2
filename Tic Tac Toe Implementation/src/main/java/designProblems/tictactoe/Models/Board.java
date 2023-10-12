package designProblems.tictactoe.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
@ToString
public class Board {
    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initializeBoard(size);
    }

    private List<List<BoardCell>> initializeBoard(int size) {
        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0,size).forEach(row->{
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0,size).forEach(column->{
                rowCells.add(new BoardCell(row,column));
            });
            cells.add(rowCells);
        });
        return cells;
    }

    public Boolean isEmpty(int row, int col) {
        return cells.get(row).get(col).getSymbol() == null;

    }

    public void updateBoard(BoardCell move) {
        cells.get(move.getRow()).get(move.getColumn()).setSymbol(move.getSymbol());
    }

    public void printBoard(){
        System.out.println("=====================================");
        for (List<BoardCell> row : cells) {
            for (BoardCell cell : row) {
                System.out.print("| " + getSymbol(cell) + " | ");
            }
            System.out.println();
        }
        System.out.println("=====================================");
    }

    private String getSymbol(BoardCell cell) {
        if (cell.getSymbol() == null){
            return " ";
        }
        return cell.getSymbol().toString();
    }

    public List<BoardCell> getEmptyCells() {
        return cells.stream().flatMap(Collection::stream)
                .filter(cell->cell.getSymbol() == null)
                .toList();
    }

}
