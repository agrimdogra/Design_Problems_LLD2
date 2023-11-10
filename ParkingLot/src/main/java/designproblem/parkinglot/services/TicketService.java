package designproblem.parkinglot.services;

import designproblem.parkinglot.Stratergies.SpotAllocation.ParkingLotAllocation;
import designproblem.parkinglot.Stratergies.SpotAllocation.RandomAllocation;
import designproblem.parkinglot.dto.CreateTicket;
import designproblem.parkinglot.models.*;
import designproblem.parkinglot.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TicketService {
    private TicketRepository ticketRepository;
    private UserService userService;
    private VehicleService vehicleService;
    private EntryGateService entryGateService;
    private ParkingSpotService parkingSpotService;
    private ParkingLotService parkingLotService;

    @Qualifier("randomAllocation")
    private ParkingLotAllocation parkingLotAllocation;
    public Ticket saveTicket(CreateTicket createTicket) {

        User user       =  getVehicleUser(createTicket);
        Vehicle vehicle =  getVehicle(createTicket.getVehicleNumber(), createTicket.getVehicleType());
        ParkingSpot parkingSpot = getParkingSpot(parkingLotService, parkingSpotService, vehicle);

        Ticket ticket =  Ticket.builder()
                .inTime(LocalDateTime.now())
                .entryGate(entryGateService.getEntryGate()
                        .orElseThrow(() -> new RuntimeException("Gate not Found")))
                .vehicle(getVehicle(createTicket.getVehicleNumber(), createTicket.getVehicleType() ))
                .vehicleUser(getVehicleUser(createTicket))
                .parkingSlot(parkingSpot)
                .build();
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> getPersistedTicket(UUID id){
        return ticketRepository.getTicketById(id);
    }

    private ParkingSpot getParkingSpot(ParkingLotService parkingLotService, ParkingSpotService parkingSpotService, Vehicle vehicle) {
        return parkingLotAllocation.allocateParkingLot(parkingLotService, parkingSpotService,vehicle);
    }

    private Vehicle getVehicle(String vehicleNumber, VehicleType vehicleType) {
        Vehicle vehicle1;
        Optional<Vehicle> vehicle = vehicleService.fetchVehicle(vehicleNumber);
        if (vehicle.isPresent())
            vehicle1 = vehicle.get();
        else {
            vehicle1 = Vehicle.builder()
                    .vehicleNumber(vehicleNumber)
                    .vehicleType(vehicleType)
                    .id(UUID.randomUUID())
                    .build();
            vehicle1 = vehicleService.saveVehicle(vehicle1);
        }
        return vehicle1;
    }

    private User getVehicleUser(CreateTicket createTicket) {
        User user1;
        Optional<User> user = userService.fetchUser(createTicket.getEMail());
        if(user.isPresent())
            user1 = user.get();
        else {
            user1 = User.builder()
                    .id(UUID.randomUUID())
                    .name(createTicket.getUserName())
                    .email(createTicket.getEMail())
                    .phoneNumber(createTicket.getUserPhoneNumber())
                    .build();
            user1 = userService.saveUser(user1);
        }
        return user1;
    }
}
