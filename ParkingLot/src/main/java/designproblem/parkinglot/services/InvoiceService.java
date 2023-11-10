package designproblem.parkinglot.services;

import designproblem.parkinglot.Stratergies.AmountCalculation.ParkingAmountCalculation;
import designproblem.parkinglot.dto.CreateInvoice;
import designproblem.parkinglot.models.*;
import designproblem.parkinglot.repositories.InvoiceRepository;
import designproblem.parkinglot.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Getter
@Setter
public class InvoiceService {
    private InvoiceRepository invoiceRepository;
    private TicketService ticketService;
    private ParkingAmountCalculation parkingAmountCalculation;

    public InvoiceService(InvoiceRepository invoiceRepository, TicketService ticketService,  @Qualifier("timeBasedCalculation") ParkingAmountCalculation parkingAmountCalculation) {
        this.invoiceRepository = invoiceRepository;
        this.ticketService = ticketService;
        this.parkingAmountCalculation = parkingAmountCalculation;
    }

    public Invoice createInvoice(CreateInvoice createInvoice){
        Invoice invoice = transformDTO(createInvoice);
        return invoiceRepository.save(invoice);
    }

    private Invoice transformDTO(CreateInvoice createInvoice) {
        LocalDateTime exitTime = LocalDateTime.now();
        Optional<Ticket> ticket = ticketService.getPersistedTicket(createInvoice.getTicketId());
        Ticket ticket1 = ticket.orElseThrow(()->new RuntimeException("Invalid Ticket ID"));
        Double amountToBePaid = parkingAmountCalculation.calculateAmount(ticket1, exitTime);
        ExitGate exitGate = ExitGate.builder()
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .exitGateNumber(1)
                .paymentCounter(PaymentCounter.builder()
                        .id(UUID.randomUUID())
                        .createdAt(LocalDateTime.now())
                        .supportedPaymentTypes(List.of(PaymentType.UPI, PaymentType.DEBIT_CARD, PaymentType.CREDIT_CARD))
                        .build())
                .build();

        Invoice invoice = Invoice.builder()
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .exitTime(exitTime)
                .exitGate(exitGate)
                .ticket(ticket1)
                .TotalAmount(amountToBePaid)
                .build();

        return invoice;
    }

    public Invoice getInvoice(UUID id){
        Optional<Invoice> invoice =  invoiceRepository.getInvoiceById(id);
        return invoice.orElse(null);
    }
}
