package pl.pjatk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    public String marka;
    public String model;
    public String VIN;
    public CarType carType;

    @Autowired
    private CarStorage carStorage;

    public Car(String marka, String model, String VIN, CarType carType){
        this.marka = marka;
        this.model = model;
        this.VIN = VIN;
        this.carType = carType;

        carStorage.addNewCarToStorage(this);
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getVIN() {
        return VIN;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
