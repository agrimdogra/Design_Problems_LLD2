package designproblem.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Invoice extends BaseModel{
    private LocalDateTime exitTime;
    private ExitGate exitGate;
    private Ticket ticket;

    private Double TotalAmount;
    private List<Payment> payments = new ArrayList<>();

}
