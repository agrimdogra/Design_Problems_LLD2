package designproblem.parkinglot.models;
import java.time.LocalDateTime;

public class Ticket extends BaseModel{
    private LocalDateTime inTime;
    private EntryGate entryGate;
    private ParkingSlot parkingSlot;
    private Vehicle vehicle;

}
