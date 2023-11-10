package designproblem.parkinglot.repositories;

import designproblem.parkinglot.models.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();

    public Vehicle save(Vehicle vehicle){
        vehicles.add(vehicle);
        return vehicle;
    }

    public Optional<Vehicle> getVehicleByNumber(String vehicleNumber){
        return vehicles.stream()
                .filter(vehicle -> vehicle.getVehicleNumber().equals(vehicleNumber))
                .findFirst();
    }
}
