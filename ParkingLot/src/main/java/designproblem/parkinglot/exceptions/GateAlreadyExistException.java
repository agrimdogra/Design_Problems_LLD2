package designproblem.parkinglot.exceptions;

public class GateAlreadyExistException extends RuntimeException {
    public GateAlreadyExistException() {
        super("A gate with same gate number exist");
    }
}
