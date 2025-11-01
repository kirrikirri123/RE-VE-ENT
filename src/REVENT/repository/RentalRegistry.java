package REVENT.repository;

import REVENT.service.Rental;
import REVENT.enity.Member;

import java.util.HashMap;


public class RentalRegistry { // borde ändras till en lista av Rentalobjekt som värde så kan samma medlem hyra flera saker.
    protected HashMap<Member,Rental> rentalList = new HashMap<Member,Rental>();

public RentalRegistry(){}


    public HashMap<Member,Rental> getRentalList() {
        return rentalList;
 }
    public void setRentalList(HashMap<Member,Rental> rentalList) {
        this.rentalList = rentalList;
    }
}
