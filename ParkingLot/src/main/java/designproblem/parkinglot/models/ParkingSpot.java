package designproblem.parkinglot.models;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Builder
@Getter
@Accessors(chain = true)
public class ParkingSpot extends BaseModel{
    public static Integer spotCounter = 0;
    private int number;
    private int floorNumber;
    private SpotType spotType;
    private SpotStatus spotStatus;
}
