package REVENT.database;

import REVENT.Rental;
import REVENT.enity.Item;
import REVENT.enity.Member;

import java.util.HashMap;


public class RentalRegistry {
    protected HashMap<Rental,Member> RentalList = new HashMap<Rental,Member>();

public RentalRegistry(){}


    public HashMap<Rental, Member> getRentalList() {
        return RentalList;
 }

}
