package REVENT.service;

import REVENT.enity.BouncyCastle;
import REVENT.enity.Item;
import REVENT.enity.MascotCostume;
import REVENT.database.Inventory;
import REVENT.enity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalService extends Inventory {
    //hanterar uthyrningsmetoder


   /* public void bookRental(String userRentalChoice) {
        if (userRentalChoice.equalsIgnoreCase("boka")) {
        } //Val hur länge man vill boka. Sätta datum. Kunden får skriva in datum för start och stop. Vi beräknar från det hur många dagar?
        // eller ska man ha fasta förslag på  dag,  helg (3 dagar)  Måndag (lägg in variabel på vilken månad.)


        else if (userRentalChoice.equalsIgnoreCase("avsluta")) {
            stopRental("avsluta");
        }
    }
    public void stopRental(String userRentalChoice) {
        if (userRentalChoice.equalsIgnoreCase("avsluta")) {
            // vad ska  göras? om någon blir galet eller om kunden vill avsluta i förtid?
        } else if (userRentalChoice.equalsIgnoreCase("boka")) {
            bookRental("boka");
        }
    }*/

    public void addItemToList(Item item) {
        getItemsList().add(item);
    }
    public void searchProd(){
        System.out.println("Vilken produkt?");
    }
    public List<Item> searchItemByName(String prod){
        List<Item> foundI= new ArrayList<>();
        for(Item i : itemsList){
            if(i.getName().equals(prod)){
                foundI.add(i);}} return foundI;
    }

    public int searchItemGetListIndex(String prod){
        int indexItem=0;
        for(int i = 0; i < itemsList.size();i++){
            if(itemsList.get(i).getName().equals(prod)){
                indexItem = i;}}
           return indexItem; } //Tagit in prodnamn, kollat av listan. Sparat index där prodman har match och returnerar detta.

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
        System.out.println(" Se uppdaterad lista:");printItemList();
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

    public void defaultList() { // För testning.
        newBouncyItem("Kungliga slottet","Stor hoppborg,för 15 barn",1000, false);
        newBouncyItem("Slott"," Liten hoppborg,för max 7 barn",450, false);
        newMascotItem("Nallebjörn","Kramgo, lurvig brunbjörn", 200,"Året om");
        newMascotItem("Tomten","Premium tomtedräkt. Kvalitetskläder naturligt skägg. Inga skor medföljer.", 1000,"Jul");
    }
}
