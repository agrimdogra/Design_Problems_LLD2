package designproblem.parkinglot.models;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket extends BaseModel {
    private LocalDateTime inTime;
    private EntryGate entryGate;
    private ParkingSpot parkingSlot;
    private Vehicle vehicle;
    private User vehicleUser;


}
