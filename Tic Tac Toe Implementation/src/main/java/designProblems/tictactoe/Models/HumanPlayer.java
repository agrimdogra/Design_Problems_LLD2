package designProblems.tictactoe.Models;

import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor
public class HumanPlayer extends Player{
    private User user;

    public HumanPlayer(Symbol symbol, String name, String email, String photo){
        super(symbol);
        UserRegistery userRegistery = UserRegistery.getInstance();
        if (userRegistery.getUser(email) != null){
            this.user = userRegistery.getUser(email);
        }
        else {
            this.user = new User(name, email, photo);
            userRegistery.addUser(this.user);
        }
    }

    @Override
    public BoardCell makeMove(Board board) {
        System.out.println("Enter row and column");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new BoardCell(row, column, getSymbol());
    }


    /**
     * Implementing Builder pattern
     */


}
