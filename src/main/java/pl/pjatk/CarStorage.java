package pl.pjatk;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
@Component
public class CarStorage {
    private ArrayList<Car> carStorage = new ArrayList<>();

    public void setCarStorage (ArrayList<Car> carStorage){
        this.carStorage = carStorage;
    }

    public void addNewCarToStorage(Car car){
        carStorage.add(car);
    }

    public ArrayList<Car> getCarStorageList() {
        return carStorage;
    }

    public void deleteCarFromStorage(String VIN){
        Iterator<Car> iterator =  carStorage.iterator();
        while (iterator.hasNext()){
            Car car = iterator.next();
            if(car.getVIN() == VIN){
                iterator.remove();
            }
        }
    }

}
