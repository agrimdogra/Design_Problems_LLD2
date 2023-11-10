package designproblem.parkinglot.repositories;

import designproblem.parkinglot.models.ParkingLot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public class ParkingLotRepository {
    private List<ParkingLot> parkingLots = new ArrayList<>();
    public ParkingLot save(ParkingLot parkingLot){
        parkingLots.add(parkingLot);

        return parkingLot;
    }

    public List<ParkingLot> findAll(){
        return  parkingLots;
    }

    public Optional<ParkingLot> findById(UUID id){
        return parkingLots.stream()
                .filter(lot->(lot.getId().equals(id)) )
                .findFirst();
    }

    public Optional<ParkingLot> getFirstParkingLot() {
        return parkingLots.stream().findFirst();
    }
}
