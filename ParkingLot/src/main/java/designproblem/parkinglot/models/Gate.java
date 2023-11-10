package designproblem.parkinglot.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Data
public abstract class Gate extends BaseModel{
    private Operator operator;
    private int gateNumber;
    private String location;
    private GateStatus gateStatus;
}
