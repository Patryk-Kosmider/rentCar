package pl.pjatk;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;

@Component
public class RentalStorage {

    private ArrayList<Rent> rentalStorage;

    public void setRentalStorage(ArrayList<Rent> rentalStorage){
        this.rentalStorage = rentalStorage;
    }

    public void addNewRent(Rent rent){
        rentalStorage.add(rent);
    }

    public ArrayList<Rent> getRentList(){
        return rentalStorage;
    }

    public void deleteRentFromList(Car car){
        Iterator<Rent> iterator = rentalStorage.iterator();
        while(iterator.hasNext()){
            Rent rent = iterator.next();
            if(rent.getCar() == car){
                iterator.remove();
            }
        }
    }

}
