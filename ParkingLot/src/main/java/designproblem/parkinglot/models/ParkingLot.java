package designproblem.parkinglot.models;

import jakarta.servlet.http.PushBuilder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<Floor> floors = new ArrayList<>();
    private List<EntryGate> entryGates = new ArrayList<>();
    private  List<ExitGate> exitGates = new ArrayList<>();


    public static ParkingLotBuilder builder(){
        return new ParkingLotBuilder();
    }

    public static class ParkingLotBuilder{
        private ParkingLot parkingLot = new ParkingLot();

        public ParkingLotBuilder name(String name){
            this.parkingLot.name = name;
            return this;
        }

        public ParkingLotBuilder address(String address){
            this.parkingLot.address = address;
            return this;
        }

        public ParkingLotBuilder withFloors(List<Floor> floors){
            this.parkingLot.floors = floors;
            return this;
        }

        public ParkingLotBuilder EntryGates(List<EntryGate> entryGates){
            this.parkingLot.entryGates = entryGates;
            return this;
        }

        public ParkingLotBuilder ExitGates(List<ExitGate> exitGates){
            this.parkingLot.exitGates = exitGates;
            return this;
        }

        public ParkingLot build(){
            ParkingLot parkingLot1 = new ParkingLot();
            parkingLot1.name       = this.parkingLot.name;
            parkingLot1.address    = this.parkingLot.address;
            parkingLot1.floors     = this.parkingLot.floors;
            parkingLot1.entryGates = this.parkingLot.entryGates;
            parkingLot1.exitGates  = this.parkingLot.exitGates;
            parkingLot1.id         = UUID.randomUUID();
            parkingLot1.createdAt  = LocalDateTime.now();
            return parkingLot1;
        }
    }
}
