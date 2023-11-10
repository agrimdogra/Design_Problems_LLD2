package designproblem.parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Vehicle extends BaseModel{
    private String vehicleNumber;
    private VehicleType vehicleType;
}
