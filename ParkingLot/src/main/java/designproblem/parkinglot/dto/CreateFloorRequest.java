package designproblem.parkinglot.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@ToString
@Data
public class CreateFloorRequest {
    private int floorNumber;
    private List<CreateParkingSpotRequest> spots;
}
