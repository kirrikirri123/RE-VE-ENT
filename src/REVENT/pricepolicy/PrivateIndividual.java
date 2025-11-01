package REVENT.pricepolicy;

public class PrivateIndividual implements PricePolicy{


    @Override
    public String priceVAT(double x) {
        double inkVAT = x * 1.25;
        double diff = inkVAT - x;
        return "Totalkostnad: " + inkVAT +" kr.\nínkl. moms 25 % : "+ diff +" kr.";}

    @Override
    public double discount(double x) {
        return x * 0.7; }

}
