package REVENT.enity;

public class BouncyCastle extends Item {
    private String size;
    private boolean indoorUse;


    public BouncyCastle(){}
    public BouncyCastle(String name,String description,double day,double weekend, double month,String size,boolean indoorUse){
        super(name, description, day, weekend, month);
        this.size = size;
        this.indoorUse = indoorUse;
    }

    public String getSize(){
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public boolean isIndoorUse() {
        return indoorUse;
    }
    public void setIndoorUse(boolean indoorUse){
        this.indoorUse = indoorUse;

    }
}
