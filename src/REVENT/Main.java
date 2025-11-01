package REVENT;
import REVENT.utils.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         Menu menu = new Menu();
        boolean isRunning = true;
        menu.defaultListForTest();
        while (isRunning) {
           menu.startMenuChoice();
           String userChoice = scan.nextLine();
            switch (userChoice) {
                case "1": menu.memberMenu(scan); break;
                case "2": menu.productMenu(scan); break;
                case "3": menu.rentalMenu(scan); break;
                case "4": menu.economyMenu(); break;
                case "5":System.out.println("Avsluta programmet"); isRunning = false; break;
                default: System.out.println("Något blev fel. Försök igen. Välj mellan [1] till [5]");
            }
        }// utanför loop..

                   } // utanför programmet..

    }




