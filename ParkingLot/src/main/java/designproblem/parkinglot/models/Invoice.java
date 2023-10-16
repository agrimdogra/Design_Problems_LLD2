package designproblem.parkinglot.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice extends BaseModel{
    private LocalDateTime exitTime;
    private ExitGate exitGate;
    private Ticket ticket;

    private Double TotalAmount;
    private List<Payment> payments = new ArrayList<>();

}
