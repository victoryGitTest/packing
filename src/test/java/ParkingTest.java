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
        ParkingBoy parkingBoy = new ParkingBoy();
        // When
        String parkingMessage = parkingBoy.parking(car);
        // Then
        Assert.assertNotEquals("false",parkingMessage);
    }

    @Test
    public void should_return_message_false_when_park_is_full_and_input_car(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        for(int i=0;i<30;i++){
            Car car = new Car();
            car.setCarNumber("粤C123456"+i);
            parkingBoy.parking(car);
        }
        Car car = new Car();
        car.setCarNumber("粤C123456");
        // When
        String parkingMessage = parkingBoy.parking(car);
        // Then
        Assert.assertEquals("false", parkingMessage);
    }

    @Test
    public void should_return_2_false_when_park1_is_full_and_input_car(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        for(int i=0;i<10;i++){
            Car car = new Car();
            car.setCarNumber("粤C123456"+i);
            parkingBoy.parking(car);
        }
        Car car = new Car();
        car.setCarNumber("粤C123456");
        // When
        String parkingMessage = parkingBoy.parking(car);
        // Then
        Assert.assertEquals("2", parkingMessage);
    }


    @Test
    public void should_return_car_when_pick_up_in_many_park(){
        // Given
        String carNumber = "粤C123456";
        Car parkedCar = new Car();
        parkedCar.setCarNumber(carNumber);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.parking(parkedCar);
        // When
        Car car = parkingBoy.pickUp(carNumber);
        // Then
        Assert.assertNotNull(car);
        Assert.assertEquals(carNumber,car.getCarNumber());
    }

    @Test
    public void should_return_1_when_park1_is_full_and_have_pick_up_and_input_car(){
        // Given
        ParkingBoy parkingBoy = new ParkingBoy();
        for(int i=0;i<10;i++){
            Car car = new Car();
            car.setCarNumber("粤C123456"+i);
            parkingBoy.parking(car);
        }
        String carNumber = "粤C123456";
        String parkedCarNumber = "粤C1234565";
        Car parkedCar = new Car();
        parkedCar.setCarNumber(carNumber);
        Car car = parkingBoy.pickUp(parkedCarNumber);
        // When
        String parkingMessage = parkingBoy.parking(car);
        // Then
        Assert.assertEquals("1",parkingMessage);
    }

    @Test
    public void should_return_message_parkCode_when_parking_car_by_smartParkingBoy(){
        // Given
        Car onecar = new Car();
        onecar.setCarNumber("粤C123456");
        SmartParkingBoy parkingBoy = new SmartParkingBoy();
        parkingBoy.parking(onecar);
        Car anotherCar = new Car();
        anotherCar.setCarNumber("粤C123456");
        // When
        String parkingMessage = parkingBoy.parking(anotherCar);
        // Then
        Assert.assertEquals("2",parkingMessage);
    }
}
