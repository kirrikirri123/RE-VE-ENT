package REVENT;

public interface PricePolicy {
    //Ska implementeras i två klasser.
    //Ska man skapa två klasser, en för privatperson en för föreningar?

    public void priceVAT();
    public void discount();// if tomte hyrs på sommaren tex.
    public void priceDay();
    public void priceWeekend();
    public void priceMonth();

}
