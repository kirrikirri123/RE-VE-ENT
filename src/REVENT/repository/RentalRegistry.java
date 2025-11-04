package REVENT.repository;

import REVENT.enity.Rental;
import REVENT.enity.Member;

import java.util.HashMap;


public class RentalRegistry {
    private HashMap<Member,Rental> rentalList = new HashMap<Member,Rental>();// borde ändras till <Member,List<Rental> .med Rentalobjekts lista som värde så kan samma medlem hyra flera saker.

public RentalRegistry(){}

    public HashMap<Member,Rental> getRentalList() {
        return rentalList;
 }

}
