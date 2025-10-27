package REVENT.enity;

public class BouncyCastle extends Item {
    private boolean indoorUse;


    public BouncyCastle(){}
    public BouncyCastle(String name,String description,double day,double weekend, double month,boolean indoorUse){
        super(name, description, day, weekend, month);

        this.indoorUse = indoorUse;
    }

    public boolean isIndoorUse() {
        return indoorUse;
    }
    public void setIndoorUse(boolean indoorUse){
        this.indoorUse = indoorUse;

    }
    @Override
    public String toString(){
    return "Produktnamn: "+ this.name + "."+ this.description + ". Godkänd för inomhusbruk: "+ this.indoorUse + ".\n Hyra - Dag: " + this.dayPrice +". Helg: "+ this.weekendPrice + ". Månad: "+ this.monthlyPrice+".";
}}
