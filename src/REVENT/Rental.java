package REVENT;

import REVENT.database.RentalRegistry;
import REVENT.enity.Item;
import REVENT.enity.Member;

import java.util.HashMap;

public class Rental extends RentalRegistry {
    // ska hålla koll på hyrestiden och koppla ihop item och member.
    private Item rentalItem;
    private int rentDays;

    public Rental() {
    }

    public Rental(Item rentalItem, int rentDays) {
        this.rentalItem = rentalItem;
        this.rentDays = 1; // Lägg metod som tar in valda tiden från objektet?
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }
    public void setRentalItem(Item rentalItem) {
        this.rentalItem = rentalItem;}


    public Rental newRental(Item rentalItem, int rentDays){ // Varför ha denna nr man har konstruktor?
        Rental rental = new Rental(rentalItem,rentDays);
        return rental;
    }
    public void rentalsToList(Rental rentalItem, Member member) {
        RentalList.put(rentalItem, member); // Kopplar rental och member mål- item + dagar kopplas med member
        addHistory(rentalItem,member); // borde ju då bli samma item och member och inte dubblera sig.
    }
    public void newRentAddRentListAndMemHistory(Item rentalItem, int rentDays, Member member){
        rentalsToList(newRental(rentalItem,rentDays),member);
        // kan man göra hela kedjan i denna metod?
        //nytt objekt, koppla objekt till member i rentlista och lägg rentalitem i members historik.
    }

    public void addHistory(Rental rentalItem, Member member) {
        member.getHistoryMember().add(rentalItem); // Lägger rental objektet i historiken hos medlem.
    }

    public void printRentalsList() {
        for (int i = 0; i < RentalList.size(); i++) {
            System.out.println(i);
        }

/*
    public int rentalTime(String rentTime) {
        //if (rentTime.isEmpty()) throw Exeption av nått slag.
        return 1;
    }
public void connectTime() {
    // ta emot ett item och en medlem (Nytt objekt skapas för hyrandet? Varje Item för hyra blir unikt till den member? eller ska man jobba med saldo?)
    //Greja med tid
    //Lägg till item och tid i history.


    public int rentMonthly() {
        //discount february?
        int feb = 0;
        for (int i = 0; i <= 12; i++) {
            if (i == 2) {
                feb -= 2;
            }
        }
        return feb;
    }


*/

    }


public void defaultRentalList(){//för testning
      //RentalList.put(,);
    }

}
    //metod. Ska rental vara ett hyrestidsobjekt som består av värdet av objekt item och objekt  member tillsammans med en tids vaiabel?

