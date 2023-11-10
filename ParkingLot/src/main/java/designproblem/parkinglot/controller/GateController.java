package designproblem.parkinglot.controller;

import designproblem.parkinglot.dto.CreateEntryGate;
import designproblem.parkinglot.models.EntryGate;
import designproblem.parkinglot.services.EntryGateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/entry-gate")
public class GateController {

    private EntryGateService entryGateService;

    @PostMapping
    public EntryGate createEntryGate(@RequestBody CreateEntryGate createEntryGate) {

        //Basic Request Validation

        //Transformation to Gate Model
        EntryGate entryGate = createEntryGate.transform();
        return entryGateService.saveEntryGate(entryGate);
    }
}
