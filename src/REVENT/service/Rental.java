package REVENT.service;

import REVENT.repository.RentalRegistry;
import REVENT.enity.Item;
import REVENT.enity.Member;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Rental extends RentalRegistry {
    // hanterar hyrestid och priser och kopplar ihop item och member.
    private Item rentalItem;
    private int rentDays;
    private LocalDate startOfRent;

    public Rental() {
    }

    public Rental(Item rentalItem, int rentDays, String startOfRent) { // metoden behöver ta in en String för att kunna skapa en Localdate.
        this.rentalItem = rentalItem;
        this.rentDays = rentDays;
        this.startOfRent = createDateOfRent(startOfRent);
    }

    public Rental(Item rentalItem, int rentDays) {
        this.rentalItem = rentalItem;
        this.rentDays = rentDays;
        this.startOfRent = LocalDate.now();
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }

    public void setRentalItem(Item rentalItem) {
        this.rentalItem = rentalItem;
    }
//_____________________________________________________________________________________

    public Rental newRental(Item rentalItem, int rentDays, String startOfRent) { // Valfritt datum skrivet YYYYMMDD!
        Rental rental = new Rental(rentalItem, rentDays, startOfRent);
        return rental;
    }

    public Rental newRental(Item rentalItem, int rentDays) { // Blir default dagens datum.
        Rental rental = new Rental(rentalItem, rentDays);
        return rental;
    }

    // skapa start
    public LocalDate createDateOfRent(String YYYYMMDD) {
        DateTimeFormatter styleDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datetOfRent = LocalDate.parse(YYYYMMDD, styleDate);
        return datetOfRent;
    }

    //önska antal
    public int rentDaysChoice(Scanner scan) {
        System.out.println("Hur många dagar önskas hyra?");
        int days = scan.nextInt();
        return days;
    }

    // byt antal
    public void changeRentDays(Member member, int x) {
        rentalList.get(member).setRentDays(x);
    }

    //visa valt antal
    public int rentalCountDays(Member member) {
        return rentalList.get(member).rentDays;
    }

    public double returnRentalDayPrice(Member member) {
        return rentalList.get(member).rentalItem.getDayPrice();
    }
     public String returnRentalitemName(Member member){
         String rentalitemName = null;
         for (Map.Entry<Member, Rental> entry : rentalList.entrySet()) {
             if (entry.getKey().equals(member)) {
                 rentalitemName = entry.getValue().rentalItem.getName();
             }} return rentalitemName;}

    public void chooseDateInfo(String when){
        System.out.println(when + " vilket datum? Skriv i formatet ÅÅÅÅ-MM-DD.");
    }
    public String userChooseDate(String dateStartString){
         return dateStartString.replace(' ','-');}


    public void rentalsToList(Member member, Rental rentalItem) {
        rentalList.put(member, rentalItem);
        addHistory(rentalItem, member);
    }

    public void addHistory(Rental rentalItem, Member member) {
        member.getHistoryMember().add(rentalItem);
    }
    public void newRentAddRentListAndMemHistory(Item rentalItem, int rentDays, Member member) {
        rentalsToList(member, newRental(rentalItem, rentDays));
        // kan man göra hela kedjan i denna metod?
    }

    public void printRentalsList() {
        for(Map.Entry<Member,Rental> entry :rentalList.entrySet()) {
            System.out.println(entry.getKey() + " - "+ entry.getValue());}}

    public void countActualDays(){
        // ta localdate start jämför mot localdate avsluta. utfallet ändrar attribut Rentdays
    }
    public void sumRentalsList() {
        for (Map.Entry<Member, Rental> entry : rentalList.entrySet()) {
             {System.out.println(entry.getKey()+ " "+ entry.getValue().rentalItem + ". Dagspris: " + entry.getValue().rentalItem.getDayPrice()+ "kr.");
             }}}


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
        return " Hyresobjekt: " + this.rentalItem.getName() + ". Planerad hyrestid i dagar: " + this.rentDays+". Datum för hyresstart: "+ this.startOfRent;

    }
}


