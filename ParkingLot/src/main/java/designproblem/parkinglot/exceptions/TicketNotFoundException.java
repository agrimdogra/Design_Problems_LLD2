package designproblem.parkinglot.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException() {
        super("No ticket found, ticket is required to generate an invoice.");
    }
}
