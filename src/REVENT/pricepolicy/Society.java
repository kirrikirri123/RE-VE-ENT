package REVENT.pricepolicy;

public class Society implements PricePolicy{


    @Override
    public String priceVAT(double x) {
        return "Totalkostnad: "+ x + "kr.\nexkl. moms.";
         }

    @Override
    public double discount(double x) {
        return x * 1;
    }
}
