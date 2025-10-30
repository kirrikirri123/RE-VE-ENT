package REVENT.service;

import REVENT.repository.RentalRegistry;
import REVENT.enity.Item;
import REVENT.enity.Member;

import java.util.HashMap;
import java.util.Scanner;

public class Rental extends RentalRegistry {
    // hanterar hyrestid och priser och kopplar ihop item och member.
    private Item rentalItem;
    private int rentDays;

    public Rental() {
    }

    public Rental(Item rentalItem, int rentDays) {
        this.rentalItem = rentalItem;
        this.rentDays = rentDays;
    }
    public int getRentDays(){
        return rentDays;
    }
    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }
    public void setRentalItem(Item rentalItem) {
        this.rentalItem = rentalItem;}
//_____________________________________________________________________________________

    public Rental newRental(Item rentalItem, int rentDays){
        Rental rental = new Rental(rentalItem,rentDays);
        return rental;
    }
    public int rentDaysChoice(Scanner scan) {
        System.out.println("Hur många dagar önskas hyra?");
        int days = scan.nextInt();
        return days;
    }

    public void rentalsToList(Member member,Rental rentalItem) {
        rentalList.put(member,rentalItem);
        addHistory(rentalItem,member);
    }

    public void addHistory(Rental rentalItem, Member member) {
        member.getHistoryMember().add(rentalItem);
    }

    public void newRentAddRentListAndMemHistory(Item rentalItem, int rentDays, Member member){
        rentalsToList(member,newRental(rentalItem,rentDays));
        // kan man göra hela kedjan i denna metod?
    }

    public void printRentalsList() {
         System.out.println(rentalList); // uppdatera med Map.Entry metod!
        }

    //Avsluta uthyrning.
    public int endRentalCountDays(Member member){
    return rentalList.get(member).rentDays;
    }

//___________________________________________________________________________
//Priceing
// Kalla på rentalobjeketet. get dayprice och get.days.
// Eller ska man ta in objektet som inparameter och göra om i metodern?
public double priceDay(double dayPrice,int days) {
    //priset i item gånger days från renalitem = totaltpris.
    if(30>= days){ int month =0;
        for(int i=0,j=30;i< days;i++,j++){
            if(j==30||j==60||j==90||j==120||j==150|| j==180){
                month++;}}
        priceMonth(dayPrice,month);
    }
    return dayPrice * days;

}
 public double priceMonth(double dayPrice,int months) {
     return (months*30)*dayPrice / 2; // om de ksa bli uskrift av denna kör printf(%.f2)

 }
    public int discountFebruary() {
        int feb = 0;
        for (int i = 0; i <= 12; i++) {
            if (i == 2) {
                feb -= 2; }
        }        return feb;}


    @Override
    public String toString() {
        return " Hyresobjekt: " + this.rentalItem.getName() + ". Planerad hyrestid i dagar: " + this.rentDays+" .";

    }
}


