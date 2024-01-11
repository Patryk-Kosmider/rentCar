import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.Car;
import pl.pjatk.CarStorage;
import pl.pjatk.CarType;

import java.util.ArrayList;


public class CarTests {

    @Test
    public void createNewCar(){
        Car testCar = new Car("BMW", "E36", "12121", CarType.PREMIUM);
        Assertions.assertEquals("BMW", testCar.getMarka());
        Assertions.assertEquals("E36", testCar.getModel());
        Assertions.assertEquals("12121", testCar.getVIN());
        Assertions.assertEquals(CarType.PREMIUM, testCar.getCarType());
    }

    @Captor
    ArgumentCaptor<Car> carArgumentCaptor;

    @Mock
    private CarStorage carStorage;

    @Test
    public void testAddCarToStorage(){
        Mockito.doNothing().when(carStorage).addNewCarToStorage(Mockito.any(Car.class));

    }


}
