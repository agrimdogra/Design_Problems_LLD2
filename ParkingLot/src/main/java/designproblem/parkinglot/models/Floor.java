package designproblem.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class Floor extends BaseModel{
    private int floorNumber;
    private List<ParkingSlot> spots = new ArrayList<>();
    private List<PaymentCounter> paymentCounters = new ArrayList<>();
    private Display displayBoard;
}
