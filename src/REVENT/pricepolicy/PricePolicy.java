package REVENT.pricepolicy;

public interface PricePolicy {
    //Ska implementeras i två klasser.
    //Ska man skapa två klasser, en för privatperson en för föreningar?

    String priceVAT(double x);
    double discount(double x);


}
