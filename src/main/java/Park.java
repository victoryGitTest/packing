import java.util.*;

public class Park {

    private Map<String,Car> carMap = new HashMap<String, Car>();
    private final Integer MAX_SCROP = 10;
    private Integer parkCode;

    public String parking(Car car){
        String code = "false";
        if (car != null) {
            if(carMap.size()<MAX_SCROP) {
                carMap.put(car.getCarNumber(), car);
                code = "success";
            }
        }
        return code;
    }

    public Car pickUp(String carNumber){
        Car car = null;
        if (carMap.containsKey(carNumber)){
            car = carMap.get(carNumber);
            carMap.remove(carNumber);
        }
        return car;
    }

    public boolean isFull(){
        return (carMap.size() >= MAX_SCROP)?true:false;
    }

    public Integer getParkCode() {
        return parkCode;
    }

    public void setParkCode(Integer parkCode) {
        this.parkCode = parkCode;
    }
}
