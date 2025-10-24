package REVENT.enity;

abstract public class Item {
    protected String name;
    protected String description;
    protected double dayPrice;
    protected double weekendPrice;
    protected double monthlyPrice;

    public Item (){}
    public Item(String name,String description,double day,double weekend, double month){
        this.name = name;
        this.description = description;
        this.dayPrice = day;
        this.weekendPrice = weekend;
        this.monthlyPrice = month;
        }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getDayPrice() {
        return dayPrice;
    }
    public void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }
    public double getWeekendPrice() {
        return weekendPrice;
    }
    public void setWeekendPrice(double weekendPrice) {
        this.weekendPrice = weekendPrice;
    }
    public double getMonthlyPrice() {
        return monthlyPrice;
    }
    public void setMonthlyPrice(double monthlyPrice) {
        this.monthlyPrice = monthlyPrice;
    }
}
