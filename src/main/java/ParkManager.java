import java.util.ArrayList;
import java.util.List;

public class ParkManager {

    private static List<Park> parks;

    static {
        if (parks == null){
            parks = new ArrayList<Park>();
            for(int i=0;i<3;i++){
                Park park = new Park();
                park.setParkCode(i+1);
                parks.add(park);
            }
        }
    }

    public String parking(Car car){
        String code = "false";
        Park park = null;
        for(Park item:parks){
            if (!item.isFull()){
                park = item;
                break;
            }
        }
        if (park != null){
            code = park.parking(car);
        }
        if (code.equals("success")){
            code = park.getParkCode()+"";
        }
        return code;
    }
}
