import java.util.List;

public abstract class ParkingBoyAbstract {

    protected List<Park> parks = ParkingLot.getParks();

    protected Car pickUp(String carNumber) {
        Car car = null;
        for(Park park : parks){
            car = park.pickUp(carNumber);
            if (car != null){
                break;
            }
        }
        return car;
    }

    protected abstract String parking(Car car);
}
