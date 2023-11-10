package designproblem.parkinglot.repositories;

import designproblem.parkinglot.models.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InvoiceRepository {
    private List<Invoice> invoices = new ArrayList<>();
    public Invoice save(Invoice invoice){
        invoices.add(invoice);
        return invoice;
    }

    public Optional<Invoice> getInvoiceById(UUID id){
        return invoices.stream()
                .filter(invoice->(invoice.getId() == id))
                .findFirst();
    }
}
