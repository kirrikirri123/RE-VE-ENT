package REVENT.utils;

import REVENT.enity.Item;

import java.util.Scanner;

public class Menu {



    public void startMenuChoice(){
        System.out.println("RevENTs uthyrning");
        System.out.println("[1] Medlemmar: Skapa ny medlem, gör förändringar i medlemslista." +
                "\n[2] Produkter: Lägg till eller ta bort produkter. " +
                "\n[3] Uthyrning : Ny uthyrning." +
                "\n[4] Ekomoni : Intäkter." +
                "\n[5] Avsluta");
        System.out.println("Skriv siffra sedan enter.");
    }

    /*public void productMenu(Scanner scan) {
        System.out.println("Produkter");
        System.out.println(" Gör ett val: \n[1] Visa alla prdukter. [2] Visa endast dräkter. [3] Visa endast hoppborgar.[4] Sök och ta bort produkt. [5] Åter huvudmeny");
        String itemSort = scan.next();
        switch (itemSort) {
            case "1" -> rentalService.printItemList();
            case "2" -> for(Item it:) ;
            case "3" -> ;
            case "4" -> rentalService.removeItemfromList(, scan); // hur göra med input inom switchn?
            case "5" -> System.out.println("Åter huvudmeny");
        }
    }*/

    public void memberMenu(){

    }

    public void rentalMenu(){
        System.out.println("Uthyrning");
        //nuvarande uthyrningar
        //Historik
    }

    public void economyMenu(){
        //Summera intäkter
        System.out.println("Ekonomi");
    }
}
