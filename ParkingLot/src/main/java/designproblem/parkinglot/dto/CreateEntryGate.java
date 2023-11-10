package designproblem.parkinglot.dto;

import designproblem.parkinglot.models.*;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@ToString
@Data
public class CreateEntryGate {
    private String operatorName;
    private String phoneNumber;
    private String eMail;
    private GateStatus entryGateStatus;
    private String gateLocation;

    public EntryGate transform() {
        Operator operator = Operator.builder()
                .user(User.builder()
                        .name(operatorName)
                        .email(eMail)
                        .phoneNumber(phoneNumber)
                        .id(UUID.randomUUID())
                        .build())
                .id(UUID.randomUUID())
                .roles(List.of(Role.OPERATOR))
                .build();

        return EntryGate.builder()
                .gateStatus(entryGateStatus)
                .gateNumber(1)
                .location(gateLocation)
                .id(UUID.randomUUID())
                .operator(operator)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
