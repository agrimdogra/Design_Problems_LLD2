package designproblem.parkinglot.services;

import designproblem.parkinglot.exceptions.GateAlreadyExistException;
import designproblem.parkinglot.models.EntryGate;
import designproblem.parkinglot.repositories.EntryGateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EntryGateService {

    private EntryGateRepository entryGateRepository;
    private UserService userService;
    private OperatorService operatorService;
    public EntryGate saveEntryGate(EntryGate entryGate){

        userService.saveUser(entryGate.getOperator().getUser());
        operatorService.saveOperator(entryGate.getOperator());


        //service Validations
         Optional<EntryGate> entryGate1 =  entryGateRepository.findEntryGate(entryGate.getGateNumber());
         if (entryGate1.isPresent()){
             throw new GateAlreadyExistException();
         }


        // call repository
        EntryGate persistedEntryGate = entryGateRepository.save(entryGate);
         return persistedEntryGate;

    }

    public Optional<EntryGate> getEntryGate(){
        return entryGateRepository.getFirst();
    }
}
