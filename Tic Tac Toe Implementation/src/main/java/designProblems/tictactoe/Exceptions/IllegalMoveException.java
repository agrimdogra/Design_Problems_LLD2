package designProblems.tictactoe.Exceptions;

public class IllegalMoveException extends RuntimeException{
    public IllegalMoveException(String message) {
        super(message);
    }
}
