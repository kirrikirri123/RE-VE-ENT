package REVENT.pricepolicy;

public class PrivateIndividual implements PricePolicy{


    @Override
    public void priceVAT() { //*1,25
//riktigtpris * denna metod = betalningen som ska in.
    }

    @Override
    public double discount(double x) {
        return x * 0.8; }

}
