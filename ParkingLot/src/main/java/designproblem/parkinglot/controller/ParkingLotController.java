package designproblem.parkinglot.controller;

import ch.qos.logback.classic.Logger;
import designproblem.parkinglot.dto.CreateParkingLotRequest;
import designproblem.parkinglot.models.ParkingLot;
import designproblem.parkinglot.services.ParkingLotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/parking-lot")
public class ParkingLotController {
    private ParkingLotService parkingLotService;


    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest parkingLotRequest){
        validate(parkingLotRequest);
        log.info(parkingLotRequest.toString());
        ParkingLot parkingLot = transform(parkingLotRequest);
        return parkingLotService.createParkingLot(parkingLot);
    }

    public void validate(CreateParkingLotRequest parkingLotRequest){
        if (parkingLotRequest.getFloors().isEmpty()  ||  parkingLotRequest.getEntryGates().isEmpty()  || parkingLotRequest.getExitGates().isEmpty() ){
            throw new RuntimeException("Invalid Input, Number of Floors or Gates cannot be zero");
        }
    }

    public ParkingLot transform(CreateParkingLotRequest parkingLotRequest){
        return parkingLotRequest.toParkingLot();
    }

}
