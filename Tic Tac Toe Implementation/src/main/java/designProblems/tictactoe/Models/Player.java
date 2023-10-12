package designProblems.tictactoe.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class Player {
    private Symbol symbol;
    public abstract BoardCell makeMove(Board board);
}
