package designproblem.parkinglot.exceptions;

public class InvalidVehicleException extends RuntimeException {
    public InvalidVehicleException() {
        super("Vehicle number cannot be empty to create a parking ticket");
    }
}
