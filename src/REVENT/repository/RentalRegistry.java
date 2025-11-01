package REVENT.repository;

import REVENT.service.Rental;
import REVENT.enity.Member;

import java.util.HashMap;


public class RentalRegistry {
    protected HashMap<Member,Rental> rentalList = new HashMap<Member,Rental>();// borde ändras till <Member,List<Rental> .med Rentalobjekts lista som värde så kan samma medlem hyra flera saker.

public RentalRegistry(){}

    public HashMap<Member,Rental> getRentalList() {
        return rentalList;
 }
    public void setRentalList(HashMap<Member,Rental> rentalList) {
        this.rentalList = rentalList;
    }
}
