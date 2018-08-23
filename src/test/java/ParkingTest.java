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
    public void should_return_message_success_when_input_car_in_many_park(){
        // Given
        Car car = new Car();
        car.setCarNumber("粤C123456");
        ParkManager parkManager = new ParkManager();
        // When
        String parkingMessage = parkManager.parking(car);
        // Then
        Assert.assertEquals("success", parkingMessage);
    }
}
