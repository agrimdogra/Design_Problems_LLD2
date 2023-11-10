package designproblem.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class PaymentCounter extends BaseModel{
    private int number;
    private List<PaymentType> supportedPaymentTypes;
}
