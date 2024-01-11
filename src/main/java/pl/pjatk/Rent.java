package pl.pjatk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Rent {
    public String userName;
    public Car car;
    public LocalDate fromWhen;
    public LocalDate toWhen;

    @Autowired
    private RentalStorage rentalStorage;

    public Rent(String userName, Car car, LocalDate fromWhen, LocalDate toWhen){
        this.userName = userName;
        this.car = car;
        this.fromWhen = fromWhen;
        this.toWhen = toWhen;
        rentalStorage.addNewRent(this);
    }

    public String getUserName() {
        return userName;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getFromWhen() {
        return fromWhen;
    }

    public LocalDate getToWhen() {
        return toWhen;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setFromWhen(LocalDate fromWhen) {
        this.fromWhen = fromWhen;
    }

    public void setToWhen(LocalDate toWhen) {
        this.toWhen = toWhen;
    }


}
