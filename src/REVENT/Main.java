package REVENT;

import REVENT.service.MemberService;
import REVENT.service.RentalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
        MemberService memberService = new MemberService(); //Det enda objektet vi vill ha av denna klass.
        RentalService rentalService = new RentalService(); // Det enda objektet vi vill ha av denna klass.
        boolean isRunning = true;
        while(isRunning){
        System.out.println("RevENTs Uthyrning");
        System.out.println("[1] Medlemmar: Ny medlem , förändringar i nedlemsregister." +
                "\n[2] Produkter: Lägg till eller ta bort produkter. " +
                "\n[3] Uthyrning : Ny uthyrning." +
                "\n[4] Ekomoni : Se över intäkter från uthyrning." +
                "\n[5] Avsluta");
        System.out.println("Skriv din funktions siffra och enter.");
        int userChoice = scan.nextInt();


            switch(userChoice){
                case 1 : System.out.println("Medlemsregister"); break;
                case 2 : System.out.println("Produkter");break;
                case 3 : System.out.println("Uthyrning");break;
                case 4 : System.out.println("Ekonomi");break;
                case 5 : System.out.println("Avsluta programmet"); isRunning = false;
                break;
            }
            }
    }
}
