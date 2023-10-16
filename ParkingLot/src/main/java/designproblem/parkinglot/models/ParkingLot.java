package designproblem.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<Floor> floors = new ArrayList<>();
    private List<EntryGate> entryGates = new ArrayList<>();
    private  List<ExitGate> exitGates = new ArrayList<>();
}
