package REVENT;

import REVENT.enity.Item;
import REVENT.enity.Member;

public class Rental {
    // ska hålla koll på hyrestiden och koppla ihop item och member.
    private Item rentingItem;
    private int rentTime;

    public Rental (){}

    public Rental(Item rentingItem, int rentTime){
        this.rentingItem = rentingItem;
       this.rentTime = 1; // Lägg metod som tar in valda tiden från objektet?
    }


    public int rentalTime(String rentTime){
            //if (rentTime.isEmpty()) throw Exeption av nått slag.
            return 1 ;
        }


public int rentMonthly(){
     //discount february?
        int feb =0;
        for(int i=0; i <=12 ;i++){
        if(i == 2){feb-=2;}
        }return feb; }

public void addHistory(){
        // lägg till Rental objekt i members privata history lista?
}

public void rent(Item item, Member member){
    // ta emot ett item och en medlem (Nytt objekt skapas för hyrandet? Varje Item för hyra blir unikt till den member? eller ska man jobba med saldo?)
    //Greja med tid
    //Lägg till item och tid i history.
}

public void rentDay(){}
public void rentWeekend(){}
public void rentMonth(){}

    //metod. Ska rental vara ett hyrestidsobjekt som består av värdet av objekt item och objekt  member tillsammans med en tids vaiabel?
}
