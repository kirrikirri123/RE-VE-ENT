package REVENT.pricepolicy;

public class PrivateInduvidual implements PricePolicy{


    @Override
    public void priceVAT() { //*1,25
//riktigtpris * denna metod = betalningen som ska in.
    }

    @Override
    public void discount() { //*0,8
    //totaltpris * denna metod = riktigt pris.
    }

}
