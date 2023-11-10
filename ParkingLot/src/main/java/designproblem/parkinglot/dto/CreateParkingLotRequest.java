package designproblem.parkinglot.dto;

import designproblem.parkinglot.models.Floor;
import designproblem.parkinglot.models.ParkingLot;
import designproblem.parkinglot.models.ParkingSpot;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Getter
@ToString(callSuper = true)
@Data
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private List<CreateFloorRequest> floors;
    private List<CreateEntryGate> entryGates;
    private List<CreateExitGate> exitGates;


    public ParkingLot toParkingLot(){
        List<Floor> floors1 = floors.stream().map(floor->
                {
                    ParkingSpot.spotCounter = 0;
                    return Floor.builder()
                            .floorNumber(floor.getFloorNumber())
                            .withSpots(floor.getSpots().stream()
                                    .map(spot ->
                                            ParkingSpot.builder()
                                                    .number(++ParkingSpot.spotCounter)
                                                    .floorNumber(floor.getFloorNumber())
                                                    .spotType(spot.getSpotType())
                                                    .spotStatus(spot.getSpotStatus())
                                                    .build()
                                    ).map(parkingSpot -> (ParkingSpot) parkingSpot.setId()).toList())
                            .build();
                }
        ).toList();



        return ParkingLot.builder()
                .name(name)
                .address(address)
                .withFloors(floors1)
                .build();
    }

}
