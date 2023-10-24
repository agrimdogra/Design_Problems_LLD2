package designproblem.parkinglot.dto;

import designproblem.parkinglot.models.GateStatus;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CreateExitGate {
    private GateStatus entryGateStatus;
    private String GateLocation;

}
