import java.util.*;

public class Park {

    private Map<String,Car> carMap = new HashMap<String, Car>();
    private Integer max_scrop = 10;
    private Integer parkCode;

    public String parking(Car car){
        String code = "false";
        if (car != null) {
            if(carMap.size()<max_scrop) {
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
        return (carMap.size() >= max_scrop)?true:false;
    }

    public Integer getParkCode() {
        return parkCode;
    }

    public void setParkCode(Integer parkCode) {
        this.parkCode = parkCode;
    }

    public Integer getMax_scrop() {
        return max_scrop;
    }

    public void setMax_scrop(Integer max_scrop) {
        this.max_scrop = max_scrop;
    }

    public int getEmptySize(){
        return max_scrop - carMap.size();
    }
}
