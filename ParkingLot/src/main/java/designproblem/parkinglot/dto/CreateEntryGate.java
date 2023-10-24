package designproblem.parkinglot.dto;

import designproblem.parkinglot.models.GateStatus;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Data
public class CreateEntryGate {
    private GateStatus entryGateStatus;
    private String GateLocation;
}
