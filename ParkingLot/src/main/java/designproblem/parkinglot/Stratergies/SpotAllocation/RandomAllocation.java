package designproblem.parkinglot.Stratergies.SpotAllocation;

import designproblem.parkinglot.models.*;
import designproblem.parkinglot.services.ParkingLotService;
import designproblem.parkinglot.services.ParkingSpotService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RandomAllocation implements ParkingLotAllocation {
    @Override
    public ParkingSpot allocateParkingLot(ParkingLotService parkingLotService, ParkingSpotService parkingSpotService, Vehicle vehicle) {

        int floor = getRandomFloor(parkingLotService.getFirstParkingLot());
        ParkingSpot parkingSpot = getRandomSpot(parkingSpotService, vehicle,  floor);

        return parkingSpot;
    }

    private ParkingSpot getRandomSpot(ParkingSpotService parkingSpotService, Vehicle vehicle, int floor) {
        List<ParkingSpot> spots =  parkingSpotService.getAllParkingSpotsOnFloor(floor).stream()
                .filter(parkingSpot -> (parkingSpot.getSpotType().toString().equals(vehicle.getVehicleType().toString() )  && parkingSpot.getSpotStatus() == SpotStatus.VACANT) )
                .toList();
        return spots.get(0);
    }

    private int getRandomFloor(Optional<ParkingLot> firstParkingLot) {
        ParkingLot parkingLot;
        if (firstParkingLot.isEmpty()){
            throw new RuntimeException("Parking lot is empty and cannot create a allocation of spot");
        }
        else {
            parkingLot = firstParkingLot.get();
        }

        int numberOfFloors = parkingLot.getFloors().size();
        return (int) (Math.random() * (numberOfFloors - 1) + 1  );
    }
}
