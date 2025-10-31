package REVENT.service;

import REVENT.enity.BouncyCastle;
import REVENT.enity.Item;
import REVENT.enity.MascotCostume;
import REVENT.repository.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalService extends Inventory {
    //hanterar Item-funktioner kopplade till uthyrning.

    public void addItemToList(Item item) {
        getItemsList().add(item);
    }

    public void searchProd() {
        System.out.println("Vilken produkt?");
    }

    public List<Item> searchItemByName(String prod) {
        List<Item> foundI = new ArrayList<>();
        for (Item i : itemsList) {
            if (i.getName().equalsIgnoreCase(prod)) {
                foundI.add(i);} }
        return foundI;
    }

    public Item searchItemByNameReturnItem(String prod) {
        Item foundItem = null;
        for (Item it : itemsList) {
            if (it.getName().equalsIgnoreCase(prod)) {
                foundItem = it;
            }
        }
        return foundItem;}

    public void checkListPrintItemsFound(String prod) { // onödigt krånglig då Itemslist är en ArrayList?
    List<Item> foundMatches = searchItemByName(prod);
    if (foundMatches.size() >= 2) {
        System.out.println("Hittade flera matchningar.");
        for (int i = 0; i < foundMatches.size(); i++) {
            System.out.println("Nr." + i + foundMatches.get(i).getName());} // Måste fixa metod för att välja mellan dessa val?
    } else if (foundMatches.isEmpty()) {
        System.out.println("Hittade ingen matchning.");
    } else {
        for (Item item : foundMatches) {
            System.out.println("Hittade " + item.getName() + " med dagspris: " + item.getDayPrice());
        }}}

    public int searchItemGetListIndex(String prod){
        int indexItem=0;
        for(int i = 0; i < itemsList.size();i++){
            if(itemsList.get(i).getName().equalsIgnoreCase(prod)){
                indexItem = i;}}
           return indexItem; } //Tagit in prodnamn, kollat av listan. Sparat index där prodnamn har match och returnerar detta.

    public void removeItemFromList(String prod, Scanner scan) {
        List<Item> removeI = searchItemByName(prod); //listan som returneras sparas i denna lista.
        if(removeI.isEmpty()){System.out.println("Hittade ingen match."); return;}
        for (Item item : removeI){
                System.out.println("Hittade produkten: " + item.getName() + ", " + item.getDescription() + "." +
                        " Ska produkten tas bort från listan? JA / NEJ");
                String removeUser = scan.nextLine();
                if (removeUser.equalsIgnoreCase("ja")){
        itemsList.removeAll(removeI);
        System.out.println(" Produkt borttagen.");}
        System.out.println(" Se aktuell lista:");printItemList();
    }}

    public void newMascotItem(String name, String description, double day, String season) {
        Item item = new MascotCostume(name, description, day, season);
        addItemToList(item);
    }

    public void newBouncyItem(String name, String description, double day, boolean indoor) {
        Item item = new BouncyCastle(name, description, day, indoor);
        addItemToList(item);
    }

    public void printItemList(){
        if(itemsList.isEmpty()){System.out.println("Inga produkter att visa.");}
        for(Item item:itemsList){
            System.out.println(item);
        }
    }

    public void printItemGroup(String attribut){
        for(Item it : itemsList) {
            if (it.getDescription().contains(attribut)){
                System.out.println(it);}}
            }

    public void defaultList() { // För testning.
        newBouncyItem("Kungliga slottet"," Stor hoppborg,för max 15 barn",1000, false);
        newBouncyItem("Slott"," Liten hoppborg, för max 7 barn",450, true);
        newBouncyItem("UltimateXtreme"," Maxad hoppupplevelse, för max 8 vuxna",3500, false);
        newMascotItem("Nallebjörn"," Kramgo, lurvig brunbjörndräkt", 200,"Året om");
        newMascotItem("Tomten"," Premium tomtedräkt. Kvalitetskläder naturligt skägg. Inga skor medföljer.", 1000,"Jul");
    }
}
