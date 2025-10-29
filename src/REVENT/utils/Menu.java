package REVENT.utils;

import REVENT.Rental;
import REVENT.enity.Item;
import REVENT.service.MemberService;
import REVENT.service.RentalService;

import java.util.Scanner;

public class Menu {

    MemberService memberService = new MemberService();
    RentalService rentalService = new RentalService();
    Rental rental = new Rental();

    public void startMenuChoice() {
        System.out.println(
        """
         RevENTs uthyrning
        [1] Medlemmar : Skapa ny medlem, gör förändringar i medlemslista.
        [2] Produkter : Se produkter, gör förändringar i produktlista.
        [3] Uthyrning : Ny uthyrning.
        [4] Ekomoni : Intäkter.
        [5] Avsluta.
        Skriv siffra sedan enter.""");
    }

    public void defaultListForTest() {
        memberService.defaultList();// default medlemmar för att det ska finnas nånting att testa med.
        rentalService.defaultList();//default produkter för att det ska finnas nånting att testa med.
    }

    public void productMenu(Scanner scan) {
        System.out.println("Produkter");
        System.out.println(" Gör ett val: \n[V] Visa alla produkter. [D] Dräkter. [H] Hoppborgar. [N] Ny produkt. [S] Sök och ta bort produkt. [B] Backa till Huvudmeny");
        String itemSort = scan.next();
        switch (itemSort.toUpperCase()) {
            case "V" : rentalService.printItemList(); break;
            case "D" : for(Item it : rentalService.getItemsList()) {
                 if (it.toString().contains("Säsong")) {
                    System.out.println(it);}} break;
            case "H" : for(Item it : rentalService.getItemsList()) {
                if (it.toString().contains("inomhusbruk")) {
                    System.out.println(it);}} break;
            case "N" : System.out.println("Ny produkt\n Under uppbyggnad"); break;
            case "S" : scan.nextLine();
            rentalService.searchProd();
            String userSearchProd = scan.nextLine();
            rentalService.removeItemFromList(userSearchProd,scan);
            scan.nextLine();break;
            case "B" : System.out.println("Backar");break;
            default:
                System.out.println("Något blev fel. V = Alla produkter, D = Dräkter, H= Hoppborgar, S = Sök/ ta bort produkt, B = Bakåt till Huvudmeny.");
                scan.nextLine();
                break;
        }
    }

    public void memberMenu(Scanner scan) {

        System.out.println("Medlemmar\n Välj åtgärd: [NP] Ny medlem - Privatperson, [NF] Ny medlem - Förening, [S] Sök medlem, [U] Uppdatera / ta bort befintlig medlem. [H] Historik - medlemsspecifik. [B] Backa till Huvudmeny");
        String memberActionChoice = scan.next();
        switch (memberActionChoice.toUpperCase()) {
            case "NP":
                System.out.println("Ny medlem. Ange personnummer och för och efternamn separerat med mellanslag.");
                String memberId = scan.next();
                String memberFname = scan.next() + " ";
                String memberLname = scan.next(); // blir begränsande i stavningen. Många möjligheter till fel alt om en person har flera förnamn/efternamn.. Ändra till nextLine?
                memberService.newMember(memberId, memberFname + memberLname, "Privat");
                scan.nextLine();
                break;
            case "NF":
                System.out.println("Ny medlem - Förening. Ange organisationsnummer och Namn på föreningen separerat med mellanslag.");
                String socMemberId = scan.next();
                String socMemberName = scan.nextLine();
                memberService.newMember(socMemberId, socMemberName, "Förening");
                scan.nextLine();
                break;
            case "S":
                System.out.println("Sökning i medlemslistan.");
                scan.nextLine(); //städare
                memberService.searchInfo();
                String userSearch = scan.nextLine();
                memberService.printSearchMemberReg(userSearch);
                scan.nextLine();
                break;
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
                    memberService.searchInfo();
                    String userUpdate = scan.nextLine();
                    memberService.updateMember(userUpdate,scan);
                    }
                break;
            case "H": System.out.println("Medlemshistorik");
               scan.nextLine(); //städare
                        memberService.searchInfo();
                String userHistory = scan.nextLine();
                memberService.searchMemberByNameId(userHistory);
                //memberService.getMemberHistory(memberService.searchMemberReg(userHistory));
                        break;
            case "B":
                System.out.println("Backar");break;
            case "A":
               memberService.printMemberReg();
                 break;
            default:
                System.out.println("Något blev fel. N = Ny medlem. S = Söka medlem. U = Uppdatera medlem. H = Historik. B =  Bakåt till huvudmeny.");
                scan.nextLine();
                break;
        }
    }

    public void rentalMenu(Scanner scan) {
        System.out.println("Uthyrning");
        System.out.println("[N] Ny uthyrning.[A] Avsluta uthyrning. [H] Historik - uthyrningar . [B] Backa till huvudmeny");
        scan.nextLine(); //städare
        String userRentalChoice = scan.nextLine();
        switch (userRentalChoice.toUpperCase()){

            case "N" : System.out.println("Ny uthyrning.");
            System.out.println("Vilken kund?\n Om det är en helt ny kund,gå åter till Huvudmenyn och välj Medlemmar på nr.1");
            String userMemberInput = scan.nextLine();
            memberService.searchMemberByNameId(userMemberInput); //returnerar templista där hittad medlem finns. borde tas in i annan metod..
                rentalService.searchProd();
                String userProdRental = scan.nextLine();
                rentalService.searchItemByName(userProdRental); // returnerar templista där produkten är hittad.
                int rentDayInput = rental.rentDaysChoice(scan);
                System.out.println("Granska bokning: "+ rentalService.searchItemByName(userProdRental).getFirst().getName() + " uthyres till "+ memberService.searchMemberByNameId(userMemberInput).getFirst().getName() +" i "+ rentDayInput + " dagar.");
                System.out.println("Bekräfta med J för att boka. Annars X.");
                String validateChoice = scan.next();
                if(validateChoice.equalsIgnoreCase("J")) {

                    System.out.println("Simulering av att skapa nytt rentalobjekt");
                    // rental.newRental(,);
                    // rental.rentalsToList(rentalService.searchItemByName(userProdRental).getFirst(), memberService.searchMemberByNameId(userMemberInput).getFirst());
                }else{System.out.println("Ångrat dig? Inget har bokat. Påbörja din bokning igen.");}
            waitForEnter(scan);

            break;
            case "A" : System.out.println("Avsluta uthyrning"); break;
            case "H" : System.out.println("Uthyrningshistorik");
            rental.printRentalsList();
            break;
            case "?" :
            case "B" : System.out.println("Backar");break;
            default:
                System.out.println("Något blev fel. N = Ny utyrning. A = Avsluta uthyrning. H = Historik. B = Bakåt till huvudmeny.");
                scan.nextLine();
                break;
        }
    }

    public void economyMenu() {
        //Summera intäkter
        System.out.println("Ekonomi");
    }

public void waitForEnter(Scanner scan){ scan.nextLine(); }
}


