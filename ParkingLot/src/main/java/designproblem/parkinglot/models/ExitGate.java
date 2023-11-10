package designproblem.parkinglot.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ExitGate extends Gate {
    private int exitGateNumber;
    private PaymentCounter paymentCounter;
}
