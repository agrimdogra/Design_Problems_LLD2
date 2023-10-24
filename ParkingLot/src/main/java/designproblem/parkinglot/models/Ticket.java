package designproblem.parkinglot.models;
import java.time.LocalDateTime;

public class Ticket extends BaseModel{
    private LocalDateTime inTime;
    private EntryGate entryGate;
    private ParkingSpot parkingSlot;
    private Vehicle vehicle;
    private User vehicleUser;

}
