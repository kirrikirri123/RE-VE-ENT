package REVENT;

public class Rental {
    // ska hålla koll på hyrestiden och koppla ihop item och member.
    private int rentTime;


    public Rental (){}

   /* public Rental(String time){
        this.rentTime = rentalTime(time);
    }

/*public int rentalTime(String rentTime){
        //if (rentTime.isEmpty()) throw Exeption av nått slag.

return ;
    }*/
public int rentMonthly(){
     //discount february?
        int feb =0;
        for(int i=0; i <=12 ;i++){
        if(i == 2){feb-=2;}
        }return feb; }

public void addHistory(){
        // lägg till Rental objekt i members privata history lista?
}


    //metod. Ska rental vara ett hyrestidsobjekt som består av värdet av objekt item och objekt  member tillsammans med en tids vaiabel?
}
