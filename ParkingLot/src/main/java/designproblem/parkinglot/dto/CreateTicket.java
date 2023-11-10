package designproblem.parkinglot.dto;

import designproblem.parkinglot.models.Ticket;
import designproblem.parkinglot.models.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CreateTicket {
    String vehicleNumber;
    VehicleType vehicleType;
    String UserName;
    String UserPhoneNumber;
    String eMail;

}
