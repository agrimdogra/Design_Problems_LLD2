package designProblems.tictactoe.Exceptions;

public class InvalidPlayersException extends RuntimeException{
    public InvalidPlayersException(String message) {
        super(message);
    }
}
