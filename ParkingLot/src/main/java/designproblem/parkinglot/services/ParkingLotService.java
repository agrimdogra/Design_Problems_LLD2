package designproblem.parkinglot.services;

import designproblem.parkinglot.models.ParkingLot;
import designproblem.parkinglot.models.ParkingSpot;
import designproblem.parkinglot.repositories.ParkingLotRepository;
import designproblem.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotService parkingSpotService;
    public ParkingLot createParkingLot(ParkingLot parkingLot){
        List<ParkingSpot> parkingSpots = parkingSpotService.createParkingSpots(parkingLot);
        ParkingLot persistedLot = parkingLotRepository.save(parkingLot);

        return persistedLot;
    }

    public Optional<ParkingLot> getFirstParkingLot(){
        return parkingLotRepository.getFirstParkingLot();
    }
}
