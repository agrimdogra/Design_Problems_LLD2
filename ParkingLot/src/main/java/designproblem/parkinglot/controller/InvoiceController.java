package designproblem.parkinglot.controller;

import designproblem.parkinglot.dto.CreateInvoice;
import designproblem.parkinglot.exceptions.TicketNotFoundException;
import designproblem.parkinglot.models.Invoice;
import designproblem.parkinglot.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/parking-invoice")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;

    @PostMapping
    public Invoice createParkingInvoice(@RequestBody CreateInvoice createInvoice){
        //Request Validation
        if (createInvoice.getTicketId() == null){
            throw new TicketNotFoundException();
        }

        Invoice invoice = invoiceService.createInvoice(createInvoice);

        return null;
    }


}
