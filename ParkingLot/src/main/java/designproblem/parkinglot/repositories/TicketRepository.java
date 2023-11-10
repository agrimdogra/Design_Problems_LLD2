package designproblem.parkinglot.repositories;

import designproblem.parkinglot.models.Operator;
import designproblem.parkinglot.models.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class TicketRepository {
    private List<Ticket> tickets = new ArrayList<>();

    public Ticket save(Ticket ticket){
        tickets.add(ticket);
        return ticket;
    }

    public Optional<Ticket> getTicketById(UUID ticketId){
        return tickets.stream()
                .filter(tic->(tic.getId() == ticketId))
                .findFirst();
    }

}
