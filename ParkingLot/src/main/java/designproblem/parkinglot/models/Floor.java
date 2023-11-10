package designproblem.parkinglot.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Data
public class Floor extends BaseModel{
    private int floorNumber;
    private List<ParkingSpot> spots = new ArrayList<>();
    private List<PaymentCounter> paymentCounters = new ArrayList<>();
    private Display displayBoard;

    public static FloorBuilder builder(){
        return new FloorBuilder();
    }

    public static class FloorBuilder{
        public Floor floor = new Floor();
        public FloorBuilder floorNumber(int floorNumber){
            this.floor.floorNumber = floorNumber;
            return this;
        }

        public FloorBuilder withSpots(List<ParkingSpot> spots){
            this.floor.spots = spots;
            return this;
        }

        public Floor build(){
            Floor floor1 = new Floor();
            floor1.floorNumber = this.floor.floorNumber;
            floor1.spots = this.floor.spots;
            floor1.id = UUID.randomUUID();
            return floor1;
        }
    }
}
