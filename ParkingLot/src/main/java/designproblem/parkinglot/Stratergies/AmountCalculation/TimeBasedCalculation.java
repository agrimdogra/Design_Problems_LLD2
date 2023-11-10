package designproblem.parkinglot.Stratergies.AmountCalculation;

import designproblem.parkinglot.models.Ticket;
import designproblem.parkinglot.models.Vehicle;
import designproblem.parkinglot.models.VehicleType;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@Component
public class TimeBasedCalculation implements ParkingAmountCalculation{

    private static final Long HOUR = 60L;

    private final Map<VehicleType, Double> firstHourPrices = new HashMap<>();
    private final Map<VehicleType, Double> pricesPerHour = new HashMap<>();

    public TimeBasedCalculation() {

        firstHourPrices.put(VehicleType.SMALL, 50.0);
        firstHourPrices.put(VehicleType.MEDIUM, 100.0);
        firstHourPrices.put(VehicleType.LARGE, 200.0);

        pricesPerHour.put(VehicleType.SMALL, 30.0);
        pricesPerHour.put(VehicleType.MEDIUM, 60.0);
        pricesPerHour.put(VehicleType.LARGE, 120.0);
    }

    @Override
    public Double calculateAmount(Ticket ticket, LocalDateTime exitTime) {
        Double price;
        Double pricePerHour;
        Duration duration = Duration.between(exitTime, ticket.getInTime());
        long parkingTime =  duration.toMinutes();
        if (parkingTime < HOUR){
            return  firstHourPrices.get(ticket.getVehicle().getVehicleType());
        }
        price = firstHourPrices.get(ticket.getVehicle().getVehicleType());
        pricePerHour = pricesPerHour.get(ticket.getVehicle().getVehicleType());

        price += (parkingTime - HOUR)*pricePerHour;
        return price;
    }
}
