package designProblems.tictactoe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardCell {
    int row;
    int column;
    Symbol symbol;

    public BoardCell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
