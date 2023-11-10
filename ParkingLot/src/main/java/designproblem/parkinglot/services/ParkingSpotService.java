package designproblem.parkinglot.services;

import designproblem.parkinglot.models.ParkingLot;
import designproblem.parkinglot.models.ParkingSpot;
import designproblem.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;
    public List<ParkingSpot> createParkingSpots(List<ParkingSpot> parkingSpots){
        List<ParkingSpot> persistedParkingSpots =  parkingSpotRepository.saveAll(parkingSpots);
        return persistedParkingSpots;
    }

    public List<ParkingSpot> createParkingSpots(ParkingLot parkingLot){
        List<ParkingSpot> pSpots = new ArrayList<>();
        parkingLot.getFloors()
                .forEach(floor -> pSpots.addAll(floor.getSpots()));
        parkingSpotRepository.saveAll(pSpots);
        return pSpots;
    }

    public List<ParkingSpot> getAllParkingSpotsOnFloor(int floorNumber){
        return parkingSpotRepository.getAllSpotsOnFloor(floorNumber);
    }
}
