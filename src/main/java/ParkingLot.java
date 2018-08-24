import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static List<Park> parks;

    public static List<Park> getParks(){
        if (parks == null){
            parks = new ArrayList<Park>();
            for(int i=0;i<3;i++){
                Park park = new Park();
                park.setParkCode(i+1);
                parks.add(park);
            }
        }
        return parks;
    }
}
