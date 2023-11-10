package designproblem.parkinglot.repositories;

import designproblem.parkinglot.models.ParkingSpot;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class ParkingSpotRepository {
    private List<ParkingSpot> parkingSpotsDb = new ArrayList<>();

    public List<ParkingSpot> saveAll(List<ParkingSpot> parkingSpots){
        parkingSpotsDb.addAll(parkingSpots);
        return  parkingSpots;
    }

    public List<ParkingSpot> getAllSpotsOnFloor(int floorNumber){
        return parkingSpotsDb.stream()
                .filter(spot->spot.getFloorNumber() == floorNumber)
                .toList();
    }
}
