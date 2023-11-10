package designproblem.parkinglot.models;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class EntryGate extends Gate{
    private Display display;
}
