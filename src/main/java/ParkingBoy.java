import java.util.ArrayList;
import java.util.List;

public class ParkingBoy extends ParkingBoyAbstract{

    @Override
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
