package REVENT.service;

import REVENT.repository.Inventory;

public class RentalService extends Inventory {
    //hanterar uthyrningsmetoder





public void bookRental(String userRentalChoice){
    if(userRentalChoice.equalsIgnoreCase("boka")){
            } //Val hur länge man vill boka. Sätta datum. Kunden får skriva in datum för start och stop. Vi beräknar från det hur många dagar?
    // eller ska man ha fasta förslag på  dag,  helg (3 dagar)  Måndag (lägg in variabel på vilken månad.)


    else if(userRentalChoice.equalsIgnoreCase("avsluta")){
        stopRental("avsluta");
    }
}

public void stopRental(String userRentalChoice) {
    if (userRentalChoice.equalsIgnoreCase("avsluta")) {
        // vad ska  göras? om någon blir galet eller om kunden vill avsluta i förtid?
    } else if (userRentalChoice.equalsIgnoreCase("boka")) {
        bookRental("boka");
    }}

public void addItemToList(){
    // lägg item i listan
}

public void removeItemfromList(){
    // ta bort från listan.
}



}
