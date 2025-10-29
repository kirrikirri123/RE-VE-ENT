package REVENT.utils;

import REVENT.service.Rental;
import REVENT.enity.Item;
import REVENT.enity.Member;
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
            case "V" : rentalService.printItemList();
                waitForEnter(scan); break;
            case "D" : System.out.println("Dräkter");
                rentalService.printItemGroup("dräkt");
                waitForEnter(scan);break;
            case "H" : System.out.println("Hoppborgar");
                rentalService.printItemGroup("hopp");
                waitForEnter(scan); break;
            case "N" : System.out.println("Ny produkt\n Under uppbyggnad");  waitForEnter(scan);break;
            case "S" :
            rentalService.searchProd();
            String userSearchProd = scan.nextLine();
            rentalService.removeItemFromList(userSearchProd,scan);
            waitForEnter(scan);break;
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
                System.out.println("Medlem skapad.");
                waitForEnter(scan);
                break;
            case "NF":
                System.out.println("Ny medlem - Förening. Ange organisationsnummer och Namn på föreningen separerat med mellanslag.");
                String socMemberId = scan.next();
                String socMemberName = scan.nextLine();
                memberService.newMember(socMemberId, socMemberName, "Förening");
                System.out.println("Medlem skapad.");
                waitForEnter(scan);
                break;
            case "S":
                System.out.println("Sökning i medlemslistan.");
                scan.nextLine(); //städare
                memberService.searchInfo();
                String userSearch = scan.nextLine();
                memberService.checkListPrintMembersFound(userSearch);
                waitForEnter(scan);
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
                    memberService.findAndUpdateMember(userUpdate,scan);
                    }
                waitForEnter(scan);
                break;
            case "H": System.out.println("Medlemshistorik");
               scan.nextLine(); //städare
                        memberService.searchInfo();
                String userHistory = scan.nextLine();
                 memberService.getMemberHistory(memberService.searchMemberByNameOrIdReturnMember(userHistory));
                waitForEnter(scan);
                        break;
            case "B":
                System.out.println("Backar");break;
            case "A":
               memberService.printMemberReg();
                waitForEnter(scan);
                 break;
            default:
                System.out.println("Något blev fel. N = Ny medlem. S = Söka medlem. U = Uppdatera medlem. H = Historik. B =  Bakåt till huvudmeny.");
                waitForEnter(scan);
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
                Member choosenRentMember =  memberService.searchMemberByNameOrIdReturnMember(userMemberInput);
                rentalService.searchProd();
                String userProdRental = scan.nextLine();
                Item choosenRentItem= rentalService.searchItemByNameReturnItem(userProdRental); // hur ska man rädda upp om det blir fel här?
                int indexOfProd = rentalService.searchItemGetListIndex(userProdRental);
                int rentDayInput = rental.rentDaysChoice(scan);
                System.out.println("Granska bokning: "+ choosenRentItem.getName() + " uthyres till "+ choosenRentMember.getName() +" i "+ rentDayInput + " dagar.");
                System.out.println("Bekräfta med J för att boka. Annars X.");
                String validateChoice = scan.next();
                if(validateChoice.equalsIgnoreCase("J")) {
                Rental newRentalItem = rental.newRental(rentalService.getItemsList().get(indexOfProd),rentDayInput);
                rental.rentalsToList(newRentalItem, choosenRentMember);
                System.out.println("Bokat!");
                }else{System.out.println("Ångrat dig? Inget är bokat. Påbörja din bokning igen.");}
            waitForEnter(scan);
            break;
            case "A" : System.out.println("Avsluta uthyrning"); waitForEnter(scan);break;
            case "H" : System.out.println("Generell uthyrningshistorik");
            rental.printRentalsList();
            waitForEnter(scan);
            break;
            case "B" : System.out.println("Backar");break;
            default:
                System.out.println("Något blev fel. N = Ny utyrning. A = Avsluta uthyrning. H = Historik. B = Bakåt till huvudmeny.");
                scan.nextLine();
                break;
        }
    }

    public void economyMenu(Scanner scan) {
        //Summera intäkter
        System.out.println("Ekonomi");
        waitForEnter(scan);
    }

public void waitForEnter(Scanner scan){ System.out.println(); scan.nextLine(); }
}


