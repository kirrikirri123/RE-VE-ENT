package REVENT.repository;

import REVENT.enity.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    // Databas för produkter.
    private List<Item> itemsList = new ArrayList<>();

    public Inventory (){}

    public List<Item> getItemsList(){
        return itemsList;
    }
    public void setItemsList(List<Item> itemsList) {
        this.itemsList = itemsList;
    }
}
