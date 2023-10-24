package designproblem.parkinglot.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ParkingSpot extends BaseModel{
    public static Integer spotCounter = 0;
    private int number;
    private int floorNumber;
    private SpotType spotType;
    private SpotStatus spotStatus;
}
