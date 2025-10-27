package REVENT.database;

import REVENT.enity.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    // Databas för produkter.
    protected List<Item> itemsList = new ArrayList<>();


    public Inventory (){}

    public List<Item> getItemsList(){
        return itemsList;
    }





}
