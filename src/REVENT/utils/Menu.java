package REVENT.utils;

import REVENT.pricepolicy.PrivateIndividual;
import REVENT.pricepolicy.Society;
import REVENT.service.Rental;
import REVENT.enity.Item;
import REVENT.enity.Member;
import REVENT.service.MemberService;
import REVENT.service.RentalService;


import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    // Lägg in objekt av Listorna här så objekt nedan kan ta in dem och användas den vägen! - Mer rätt!
    // Inventory inventory = new Inventory();
    // MemberRegestry memberRegestry = new memberRegestry();
    //RentalRegestry rentalRegestry = new rentalRegestry();

    MemberService memberService = new MemberService(); //Skicka in memberRegestry
    RentalService rentalService = new RentalService(); //Skicka in inventory
    Rental rental = new Rental(); //Skicka in rentalRegestry
    PrivateIndividual privateIndividual = new PrivateIndividual();
    Society society = new Society();


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
        System.out.println(" Gör ett val: \n[V] Visa alla produkter. [D] Dräkter. [H] Hoppborgar. [N] Ny produkt. [X] Ta bort produkt. [B] Backa till Huvudmeny");
        String itemSort = scan.nextLine();
          switch (itemSort.toUpperCase()) {
            case "V" : rentalService.printItemList();
                 break;
            case "D" : System.out.println("Dräkter");
                rentalService.printItemGroup("dräkt");
                break;
            case "H" : System.out.println("Hoppborgar");
                rentalService.printItemGroup("hopp");
                 break;
            case "N" : System.out.println("Ny produkt\n Under uppbyggnad");

            break;
            case "S" : System.out.println("Sök produkt");
                rentalService.searchProd();
                String userSearchProd = scan.nextLine();
            rentalService.checkListPrintItemsFound(userSearchProd);
            break;
            case "X" : System.out.println("Borttagning av produkt");
            rentalService.searchProd();
            String userRemove = scan.nextLine();
            rentalService.removeItemFromList(userRemove,scan);
            break;
            case "B" : System.out.println("Backar");break;
            default:
                System.out.println("Något blev fel. V = Alla produkter, D = Dräkter, H= Hoppborgar, S = Sök/ ta bort produkt, B = Bakåt till Huvudmeny.");
                break;
        }
    }

    public void memberMenu(Scanner scan) {

        System.out.println("Medlemmar\n Välj åtgärd: [NP] Ny medlem - Privatperson, [NF] Ny medlem - Förening, [S] Sök medlem, [U] Uppdatera / ta bort befintlig medlem. [H] Historik - medlemsspecifik. [B] Backa till Huvudmeny");
        String memberActionChoice = scan.nextLine();
         switch (memberActionChoice.toUpperCase()) {
            case "NP":
                System.out.println("Ny medlem. Ange personnummer och för och efternamn separerat med mellanslag.");
                String memberId = scan.next();
                String memberFname = scan.next() + " ";
                String memberLname = scan.next();
                clearingScan(scan);
                memberService.newMember(memberId, memberFname + memberLname, "Privat");
                System.out.println("Medlem skapad.");
                break;
            case "NF":
                System.out.println("Ny medlem - Förening. Ange först organisationsnummer och sedan namn på föreningen. Separerat med enter-slag.");
                String socMemberId = scan.nextLine();
                String socMemberName = scan.nextLine();
                memberService.newMember(socMemberId, socMemberName, "Förening");
                System.out.println("Medlem skapad.");
                break;
            case "S":
                System.out.println("Sökning i medlemslistan.");
                memberService.searchInfo();
                String userSearch = scan.nextLine();
                memberService.checkListPrintMembersFound(userSearch);
                break;
            case "U":
                System.out.println("Uppdateringar. Vill du ta bort en medlem ur listan helt? Ange X, enter." +
                        "\n Önskar du uppdatera befintlig medlemsinfo? Ange U, sedan enter.");
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
                break;
            case "H": System.out.println("Medlemshistorik");
                memberService.searchInfo();
                String userHistory = scan.nextLine();
                 memberService.getMemberHistory(memberService.searchMemberByNameOrIdReturnMember(userHistory));
                break;
            case "E": //Test Case          break;
            case "B":
                System.out.println("Backar");break;
            case "A":
               memberService.printMemberReg();
               break;
            default:
                System.out.println("Något blev fel. N = Ny medlem. S = Söka medlem. U = Uppdatera medlem. H = Historik. B =  Bakåt till huvudmeny.");
                break;
        }
    }

    public void rentalMenu(Scanner scan) {
        System.out.println("Uthyrning");
        System.out.println("[N] Ny uthyrning.[A] Avsluta uthyrning. [H] Historik - uthyrningar . [B] Backa till huvudmeny");
        String userRentalChoice = scan.nextLine();
        switch (userRentalChoice.toUpperCase()){

            case "N" : System.out.println("Ny uthyrning.");
            System.out.println("Vilken kund?\n Om det är en helt ny kund,gå åter till Huvudmenyn och välj Medlemmar på nr.1");
            String userMemberInput = scan.nextLine();
                Member choosenRentMember =  memberService.searchMemberByNameOrIdReturnMember(userMemberInput);
                rentalService.searchProd();
                String userProdRental = scan.nextLine();
                Item choosenRentItem= rentalService.searchItemByNameReturnItem(userProdRental); // Stora möjligheter till Exeptions.
                int indexOfProd = rentalService.searchItemGetListIndex(userProdRental);
                int rentDayInput = rental.rentDaysChoice(scan);
                clearingScan(scan);
                rental.chooseDateInfo("Starta");
                String userChooseDateOfStart = scan.nextLine();
                String dateStartRent=rental.userChooseDate(userChooseDateOfStart);
                System.out.println("Granska bokning: "+ choosenRentItem.getName() + " uthyres till "+ choosenRentMember.getName() +" i "+ rentDayInput + " dagar, från och med "+ dateStartRent);
                System.out.println("Bekräfta med J för att boka. Annars X.");
                String validateChoice = scan.nextLine();
                if(validateChoice.startsWith("J")) {
                Rental newRentalItem = rental.newRental(rentalService.getItemsList().get(indexOfProd),rentDayInput,dateStartRent);
                rental.rentalsToList(choosenRentMember,newRentalItem);
                LocalDate estimatedReturnDate = rental.createDateOfRent(dateStartRent).plusDays(rentDayInput);
                System.out.println("Bokat! "+ "Planerat återlämningsdatum: "+ estimatedReturnDate);
                }else{System.out.println("Ångrat dig? Inget är bokat. Påbörja din bokning igen.");}
                break;
            case "A" : System.out.println("Avsluta uthyrning");
            System.out.println("Återlämning av produkt ");
            memberService.searchInfo();
            String rentalitemReturn = scan.nextLine();
            Member returningMember =memberService.searchMemberByNameOrIdReturnMember(rentalitemReturn);
            String rentalitemName = rental.returnRentalItemName(returningMember);
            rental.chooseDateInfo("Åter");
            String userReturnRentalItem = scan.nextLine();
            String dateStopRent =rental.userChooseDate(userReturnRentalItem);
            System.out.println("Granska återlämning: " + dateStopRent + " återlämnade " + returningMember.getName() + " produkten " + rentalitemName + " ?  JA /NEJ " );
            String userValidationReturn = scan.nextLine();
            if (userValidationReturn.equalsIgnoreCase("JA")){System.out.println("Återlämnad!");
            rental.getRentalList().get(returningMember).setReturned(true); } // uppdaterar alla listor.
            // Räkna ut och meddela kostnaden.
            double rentalItemDayprice = rental.returnRentalDayPrice(returningMember);
            int rentalItemDaysRented = rental.rentalCountDays(returningMember);
            double totalBasePrice = rental.calculateDay(rentalItemDayprice, rentalItemDaysRented);
           double totalPrice = 0; // Nånting i uträkningen blir fel.
            if(returningMember.getMemberStatus().equalsIgnoreCase("privat")){
                 totalPrice = privateIndividual.discount(totalBasePrice);
            }else{ totalPrice = society.discount(totalBasePrice); }
            System.out.println("Du hyrde i "+ rentalItemDaysRented + " dagar. Totalkostnaden: "+ totalPrice + "kr.");

             break;
            case "H" : System.out.println("Generell uthyrningshistorik");
            rental.printRentalsList();
                   break;
            case "B" : System.out.println("Backar");break;
            default:
                System.out.println("Något blev fel. N = Ny utyrning. A = Avsluta uthyrning. H = Historik. B = Bakåt till huvudmeny.");
                 break;
        }
    }

 public void economyMenu() {
        System.out.println("Ekonomi");
     rental.sumRentalsList();
    }

public void clearingScan(Scanner scan){ scan.nextLine();}
}
