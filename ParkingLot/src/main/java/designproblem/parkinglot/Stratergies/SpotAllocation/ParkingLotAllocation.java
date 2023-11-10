package designproblem.parkinglot.Stratergies.SpotAllocation;

import designproblem.parkinglot.models.ParkingSpot;
import designproblem.parkinglot.models.Vehicle;
import designproblem.parkinglot.services.ParkingLotService;
import designproblem.parkinglot.services.ParkingSpotService;
import org.springframework.stereotype.Component;

@Component
public interface ParkingLotAllocation {
    public ParkingSpot allocateParkingLot(ParkingLotService parkingLotService, ParkingSpotService parkingSpotService, Vehicle vehicle);
}
