package designproblem.parkinglot.services;

import designproblem.parkinglot.models.ParkingLot;
import designproblem.parkinglot.models.ParkingSpot;
import designproblem.parkinglot.repositories.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;
    public ParkingLot createParkingLot(ParkingLot parkingLot){
        ParkingLot persistedLot = parkingLotRepository.save(parkingLot);
        return persistedLot;
    }
}
