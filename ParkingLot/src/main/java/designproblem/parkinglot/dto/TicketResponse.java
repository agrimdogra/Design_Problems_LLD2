package designproblem.parkinglot.dto;

import designproblem.parkinglot.models.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
@Builder
@Getter
@Setter
@AllArgsConstructor
public class TicketResponse {
    private UUID ticketId;
    private LocalDateTime entryTime;
    private String operatorName;
    private UUID operatorId;
    private int entryGateNumber;
    private String entryGateLocation;
    private int exitGateNumber;
    private UUID parkingSpotId;
    private int parkingFloor;
    private int spotNumber;
    private SpotType spotType;
    private String vehicleNumber;
    private UUID vehicleId;
    private VehicleType vehicleType;
    private String vehicleUser;
    private String userPhoneNumber;

    public static TicketResponse transform(Ticket ticket) {
        return TicketResponse.builder()
                .ticketId(ticket.getId())
                .entryTime(ticket.getInTime())
                .operatorName(ticket.getEntryGate().getOperator().getUser().getName())
                .operatorId(ticket.getEntryGate().getOperator().getId())
                .entryGateNumber(ticket.getEntryGate().getGateNumber())
                .entryGateLocation(ticket.getEntryGate().getLocation())
                .parkingSpotId(ticket.getParkingSlot().getId())
                .parkingFloor(ticket.getParkingSlot().getFloorNumber())
                .spotNumber(ticket.getParkingSlot().getNumber())
                .spotType(ticket.getParkingSlot().getSpotType())
                .vehicleNumber(ticket.getVehicle().getVehicleNumber())
                .vehicleId(ticket.getVehicle().getId())
                .vehicleType(ticket.getVehicle().getVehicleType())
                .vehicleUser(ticket.getVehicleUser().getName())
                .userPhoneNumber(ticket.getVehicleUser().getPhoneNumber())
                .build();
    }
}
