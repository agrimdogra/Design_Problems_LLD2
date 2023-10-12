package TestTicTacToe;

import designProblems.tictactoe.Models.*;
import designProblems.tictactoe.Strategies.moveStratergy.RandomPlayingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TicTacToeTest {
    private static final Integer BOARD_SIZE = 3;    //Screaming Case (all caps)
    @Test
    public void testBoard(){
        int size = 5;
        Board board = new Board(size);
        Assertions.assertEquals(board.getCells().size(), size, "The columns are not correct");
        Assertions.assertEquals(board.getCells().get(0).size(), size, "The rows are not correct");
    }

    @Test
    public void testCreateGame(){

        //Complex Construction of a Game, and no validation done.  "Better to use Builder Design Pattern"

        /**
         *         Board board = new Board(BOARD_SIZE);
         *         Player HumanPlayer = new HumanPlayer(Symbol.X, "Agrim", "agrim.dogra@sap.com", "photo");
         *         Player BotPlayer = new BotPlayer(Symbol.O, Level.MEDIUM, new RandomPlayongStratergy());
         *         Game game = new Game(board, List.of(HumanPlayer, BotPlayer) , GameStatus.IN_PROGRESS);
         */

    }

    @Test
    public void testCreateGame2(){
        Game game = Game.builder()
                .withSize(3)
                .withPlayer( new HumanPlayer(Symbol.X, "Agrim", "agrim.dogra@sap.com", "photo") )
                .withPlayer( new BotPlayer(Symbol.O, Level.MEDIUM, new RandomPlayingStrategy() ) )
                .build();
        System.out.println(game);
    }


    @Test
    public void testCreateGame3(){
        Game game = Game.builder()
                .withSize(3)
                .withPlayer( new HumanPlayer(Symbol.X, "Agrim", "agrim.dogra@sap.com", "photo") )
                .withPlayer( BotPlayer.BotPlayerBuilder()
                        .O()
                        .level(Level.HARD)
                        .strategy()
                        .build()
                )
                .build();
        System.out.println(game);
    }

    @Test
    public void printBoard(){
        Board board = new Board(3);
        board.printBoard();
        board.updateBoard(new BoardCell(2,2,Symbol.X));
        board.updateBoard(new BoardCell(2,1,Symbol.O));
        board.updateBoard(new BoardCell(1,1,Symbol.O));
        board.updateBoard(new BoardCell(1,2,Symbol.O));
        board.printBoard();
        System.out.println("Empty cells list");
        List<BoardCell> empty = board.getEmptyCells();
        System.out.println(board.getEmptyCells().size());
    }


}
