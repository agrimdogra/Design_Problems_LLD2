package designproblem.parkinglot.controller;

import designproblem.parkinglot.dto.CreateTicket;
import designproblem.parkinglot.dto.TicketResponse;
import designproblem.parkinglot.exceptions.InvalidVehicleException;
import designproblem.parkinglot.models.Ticket;
import designproblem.parkinglot.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/parking-ticket")
public class TicketController {
    private TicketService ticketService;
    @PostMapping
    public TicketResponse createTicket(@RequestBody CreateTicket createTicket){
        // Request Validation
        if(createTicket.getVehicleNumber() == null)
            throw new InvalidVehicleException();

        // Transformation.
        // Direct Transformation not possible.

        Ticket ticket =  ticketService.saveTicket(createTicket);

        return TicketResponse.transform(ticket);
    }
}
