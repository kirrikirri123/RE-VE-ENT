package REVENT.pricepolicy;

public class Society implements PricePolicy{


    @Override
    public void priceVAT() {
        //*1;
        //riktigtpris * denna metod = betalningen som ska in.

    }

    @Override
    public double discount(double x) {
        return x * 1;
    }
}
