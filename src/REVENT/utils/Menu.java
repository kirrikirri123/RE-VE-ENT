package REVENT.utils;

import REVENT.enity.Item;
import REVENT.service.MemberService;
import REVENT.service.RentalService;

import java.util.Scanner;

public class Menu {

    MemberService memberService = new MemberService(); //Det enda objektet vi vill ha av denna klass.
    RentalService rentalService = new RentalService(); // Det enda objektet vi vill ha av denna klass.

    public void startMenuChoice() {
        System.out.println("RevENTs uthyrning");
        System.out.println("[1] Medlemmar: Skapa ny medlem, gör förändringar i medlemslista." +
                "\n[2] Produkter: Lägg till eller ta bort produkter. " +
                "\n[3] Uthyrning : Ny uthyrning." +
                "\n[4] Ekomoni : Intäkter." +
                "\n[5] Avsluta");
        System.out.println("Skriv siffra sedan enter.");
    }

    public void defaultListForTest() {
        memberService.defaultList();// default medlemmar för att det ska finnas nånting att testa med.
        rentalService.defaultList();//default produkter för att det ska finnas nånting att testa med.
    }

    public void productMenu(Scanner scan) {
        System.out.println("Produkter");
        System.out.println(" Gör ett val: \n[1] Visa alla produkter. [2] Visa dräkter. [3] Visa hoppborgar.[4] Sök och ta bort produkt. [H] Huvudmeny");
        String itemSort = scan.next();
        switch (itemSort) {
            case "1" : rentalService.printItemList(); break;
            case "2" : for(Item it : rentalService.getItemsList()) {
                 if (it.toString().contains("Säsong")) {
                    System.out.println(it);}} break;
            case "3" : for(Item it : rentalService.getItemsList()) {
                if (it.toString().contains("inomhusbruk")) {
                    System.out.println(it);}} break;
            case "4" : scan.nextLine();
            rentalService.searchProd();
            String userSearchProd = scan.nextLine();
            rentalService.removeItemfromList(userSearchProd, scan);
            scan.nextLine();break;
            case "5" :
            case "h" :
            case "H" : System.out.println("Åter huvudmeny");break;
            default:
                System.out.println("Något blev fel. 1 = Alla produkter, 2 = Dräkter, 3 = Hoppborgar, 4 = Sök/ ta bort produkt, H = Huvudmeny.");
                scan.nextLine();
                break;
        }
    }

    public void memberMenu(Scanner scan) {

        System.out.println("Medlemslista\n Välj åtgärd: [N] Ny medlem, [S] Sök medlem, [U] Uppdatera / ta bort befintlig medlem.[H] Huvudmeny");
        String memberActionChoice = scan.next();
        switch (memberActionChoice) {
            case "n":
            case "N":
                System.out.println("Ny Medlem. Ange personnummer och för och efternamn separerat med mellanslag.");
                String memberId = scan.next();
                String memberFname = scan.next() + " ";
                String memberLname = scan.next(); // blir begränsande i stavningen. Många möjligheter till fel.
                memberService.newMemberIndividual(memberId, memberFname + memberLname, "Privat");
                scan.nextLine();
                break;
            case "s":
            case "S":
                System.out.println("Sökning i Medlemslistan.");
                scan.nextLine(); //städare
                memberService.searchInfo();
                String userSearch = scan.nextLine();
                memberService.searchMemberReg(userSearch);
                scan.nextLine();
                break;
            case "u":
            case "U":
                System.out.println("Uppdateringar. Vill du ta bort en medlem ur listan helt? Ange X, enter." +
                        "\n Önskar du uppdatera befintlig medlemsinfo? Ange U, sedan enter.");
                scan.nextLine(); // städare
                String userChangeMem = scan.nextLine();
                if (userChangeMem.equalsIgnoreCase("X")) {
                    memberService.searchInfo();
                    String userRemove = scan.nextLine();
                    memberService.removeMember(userRemove, scan);
                } else if (userChangeMem.equalsIgnoreCase("U")) {
                    System.out.println("Under uppbyggnad.");
                }
                scan.nextLine();
                break;
            case "h":
            case "H":
                System.out.println("Åter huvudmeny");break;
            case "A":
                memberService.printMemberReg();
                break;
            default:
                System.out.println("Något blev fel. N = Ny medlem, S = Söka medlem, U = Uppdatera medlem, H = Huvudmeny.");
                scan.nextLine();
                break;
        }
    }


    public void rentalMenu() {
        System.out.println("Uthyrning");
        //nuvarande uthyrningar
        //Historik
    }

    public void economyMenu() {
        //Summera intäkter
        System.out.println("Ekonomi");
    }
}
