import org.junit.Assert;
import org.junit.Test;

public class ParkingTest {

    @Test
    public void should_return_message_success_when_input_car() {
        // Given
        Car car = new Car();
        car.setCarNumber("粤C123456");
        Park park = new Park();
        // When
        String parkingMessage = park.parking(car);
        // Then
        Assert.assertEquals("success", parkingMessage);
    }


    @Test
    public void should_return_car_when_input_carNumber(){
        //Given
        String carNumber = "粤C123456";
        Park park = new Park();
        Car car = new Car();
        car.setCarNumber(carNumber);
        park.parking(car);
        //When
        Car retcar = park.pickUp(carNumber);
        //Then
        Assert.assertNotNull(retcar);
        Assert.assertEquals(carNumber,retcar.getCarNumber());

    }

    @Test
    public void should_return_message_parkCode_when_input_car_in_many_park(){
        // Given
        Car car = new Car();
        car.setCarNumber("粤C123456");
        ParkManager parkManager = new ParkManager();
        // When
        String parkingMessage = parkManager.parking(car);
        // Then
        Assert.assertNotEquals("false",parkingMessage);
    }

    @Test
    public void should_return_message_false_when_park_is_full_and_input_car() throws Exception{
        // Given
        ParkManager parkManager = new ParkManager();
        for(int i=0;i<30;i++){
            Car car = new Car();
            car.setCarNumber("粤C123456"+i);
            parkManager.parking(car);
        }
        Car car = new Car();
        car.setCarNumber("粤C123456");
        // When
        String parkingMessage = parkManager.parking(car);
        // Then
        Assert.assertEquals("false", parkingMessage);
    }

    @Test
    public void should_return_2_false_when_park1_is_full_and_input_car() throws Exception{
        // Given
        ParkManager parkManager = new ParkManager();
        for(int i=0;i<10;i++){
            Car car = new Car();
            car.setCarNumber("粤C123456"+i);
            parkManager.parking(car);
        }
        Car car = new Car();
        car.setCarNumber("粤C123456");
        // When
        String parkingMessage = parkManager.parking(car);
        // Then
        Assert.assertEquals("2", parkingMessage);
    }
}
