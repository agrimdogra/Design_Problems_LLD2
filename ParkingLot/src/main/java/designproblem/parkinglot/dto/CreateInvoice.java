package designproblem.parkinglot.dto;

import designproblem.parkinglot.models.Invoice;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class CreateInvoice {
    private UUID ticketId;

}
