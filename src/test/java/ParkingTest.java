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
        Car parkedCar = new Car();
        parkedCar.setCarNumber(carNumber);
        park.parking(parkedCar);
        //When
        Car car = park.pickUp(carNumber);
        //Then
        Assert.assertNotNull(car);
        Assert.assertEquals(carNumber,car.getCarNumber());

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
    public void should_return_message_false_when_park_is_full_and_input_car(){
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
    public void should_return_2_false_when_park1_is_full_and_input_car(){
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


    @Test
    public void should_return_car_when_pick_up_in_many_park(){
        // Given
        String carNumber = "粤C123456";
        Car parkedCar = new Car();
        parkedCar.setCarNumber(carNumber);
        ParkManager parkManager = new ParkManager();
        parkManager.parking(parkedCar);
        // When
        Car car = parkManager.pickUp(carNumber);
        // Then
        Assert.assertNotNull(car);
        Assert.assertEquals(carNumber,car.getCarNumber());
    }

    @Test
    public void should_return_car_when_pick_up_in_many_park_and_all_park_isfull(){
        // Given
        ParkManager parkManager = new ParkManager();
        for(int i=0;i<10;i++){
            Car car = new Car();
            car.setCarNumber("粤C123456"+i);
            parkManager.parking(car);
        }
        String carNumber = "粤C123456";
        String parkedCarNumber = "粤C1234565";
        Car parkedCar = new Car();
        parkedCar.setCarNumber(carNumber);
        Car car = parkManager.pickUp(parkedCarNumber);
        // When
        String parkingMessage = parkManager.parking(car);
        // Then
        Assert.assertEquals("1",parkingMessage);
    }
}
