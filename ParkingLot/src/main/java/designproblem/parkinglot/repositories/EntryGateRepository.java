package designproblem.parkinglot.repositories;

import designproblem.parkinglot.models.EntryGate;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Data
public class EntryGateRepository {

    private List<EntryGate> entryGates = new ArrayList<>();



    public EntryGate save(EntryGate entryGate){
        entryGates.add(entryGate);
        return entryGate;
    }

    public Optional<EntryGate> findEntryGate(int number){
        return entryGates.stream()
                .filter(gate->gate.getGateNumber() == number)
                .findFirst();
    }

    public Optional<EntryGate> getFirst() {
        return entryGates.stream().findFirst();
    }
}
