package REVENT.service;

import REVENT.enity.BouncyCastle;
import REVENT.enity.Item;
import REVENT.enity.MascotCostume;
import REVENT.database.Inventory;

public class RentalService extends Inventory {
    //hanterar uthyrningsmetoder


    public void bookRental(String userRentalChoice) {
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
    }

    public void addItemToList(Item item) {
        getItemsList().add(item);
    }

    public void removeItemfromList(Item item) {
        getItemsList().remove(item); // grund metod. ej körbar
    }

    public void newMascotItem(String name, String description, double day, double weekend, double month, String season) {
        Item item = new MascotCostume(name, description, day, weekend, month, season);
        addItemToList(item);
    }

    public void newBouncyItem(String name, String description, double day, double weekend, double month, boolean indoor) {
        Item item = new BouncyCastle(name, description, day, weekend, month, indoor);
        addItemToList(item);
    }
    public void printItemList(){
        for(Item item:itemsList){
            System.out.println(item);
        }
    }


    public void defaultList() { // För testning.
        newBouncyItem("Kungliga slottet","Stor hoppborg,för 15 barn",1000,2500,15000, false);
        newBouncyItem("Slott"," Liten hoppborg,för max 7 barn",450,1200,8500, false);
        newMascotItem("Nallebjörn","Kramgo, lurvig brunbjörn", 200,500,2000,"Året om");
        newMascotItem("Tomten","Premium tomtedräkt. Kvalitetskläder naturligt skägg. Inga skor medföljer.", 1000,1800,6000,"Jul");
    }
}
