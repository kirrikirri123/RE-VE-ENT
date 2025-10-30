package REVENT.repository;

import REVENT.service.Rental;
import REVENT.enity.Member;

import java.util.HashMap;


public class RentalRegistry {
    protected HashMap<Rental,Member> rentalList = new HashMap<Rental,Member>();

public RentalRegistry(){}


    public HashMap<Rental, Member> getRentalList() {
        return rentalList;
 }

}
