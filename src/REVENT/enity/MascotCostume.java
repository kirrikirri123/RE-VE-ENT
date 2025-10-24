package REVENT.enity;

public class MascotCostume extends Item {
    private String season;


    public MascotCostume(){}
    public MascotCostume(String name,String description,double day,double weekend, double month,String season){
        super(name, description, day, weekend, month);
        this.season = season;}

     public String getSeason(){
        return season;
        }

    public void setSeason(String season) {
        this.season = season;
    }
}

