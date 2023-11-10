package designproblem.parkinglot.services;

import designproblem.parkinglot.models.Operator;
import designproblem.parkinglot.models.Vehicle;
import designproblem.parkinglot.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleService {
    private VehicleRepository vehicleRepository;

    public Optional<Vehicle> fetchVehicle(String vehicleNumber) {
        return vehicleRepository.getVehicleByNumber(vehicleNumber);
    }

    public Vehicle saveVehicle(Vehicle vehicle){
        Optional<Vehicle> vehicle1= vehicleRepository.getVehicleByNumber(vehicle.getVehicleNumber());
        return vehicle1.orElseGet(() -> vehicleRepository.save(vehicle));
    }
}
