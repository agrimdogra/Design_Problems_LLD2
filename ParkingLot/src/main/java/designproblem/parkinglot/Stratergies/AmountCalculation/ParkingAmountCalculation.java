package designproblem.parkinglot.Stratergies.AmountCalculation;

import designproblem.parkinglot.models.Ticket;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public interface ParkingAmountCalculation {
    public Double calculateAmount(Ticket ticket, LocalDateTime exitTime);
}
