package pl.pjatk;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class RentalService {

    private final double dayRentBase = 100;
    private RentalStorage rentalStorage;
    private CarStorage carStorage;

    public RentalService(RentalStorage rentalStorage, CarStorage carStorage){
        this.rentalStorage = rentalStorage;
        this.carStorage = carStorage;
    }

    public boolean doesCarExist(Car carToCheck) {
        ArrayList<Car> cars = carStorage.getCarStorageList();
        for (Car car : cars){
            if(car == carToCheck){
                return false;
            }

        }
        return true;
    }

    public double estimatePriceForRent(String VIN){
        ArrayList<Car> cars = carStorage.getCarStorageList();
        double estimatedPrice = 0;
        for (Car car : cars){
            if(car.getVIN() == VIN){
                estimatedPrice = dayRentBase * car.getCarType().getPriceRatio();
            }

        }
        return estimatedPrice;
    }

    public boolean isRentAvailable(Car car, LocalDate dateFrom, LocalDate dateTo) {
        ArrayList<Rent> rents = rentalStorage.getRentList();
        for (Rent rent : rents){
            if(rent.getCar() == car){
                if(rent.getToWhen().isBefore(dateFrom) || rent.getFromWhen().isAfter(dateTo)){
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public Rent rentACar(String userName, Car car, LocalDate fromWhen, LocalDate toWhen){
        if((isRentAvailable(car, fromWhen, toWhen)) == true && doesCarExist(car) == true){
            return new Rent(userName, car, fromWhen, toWhen);
        } else {
            throw new RuntimeException("There was a problem with renting");
        }
    }


}



