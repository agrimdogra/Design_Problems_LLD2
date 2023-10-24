package designproblem.parkinglot.dto;

import designproblem.parkinglot.models.SpotStatus;
import designproblem.parkinglot.models.SpotType;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CreateParkingSpotRequest {
    private SpotType spotType;
    private SpotStatus spotStatus;
}
