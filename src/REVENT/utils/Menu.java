package REVENT.utils;

import REVENT.pricepolicy.PrivateIndividual;
import REVENT.pricepolicy.Society;
import REVENT.repository.MemberRegistry;
import REVENT.service.Rental;
import REVENT.enity.Item;
import REVENT.enity.Member;
import REVENT.service.MembershipService;
import REVENT.service.RentalService;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    // Lägg in objekt av Listorna här så objekt nedan kan ta in dem och användas den vägen! - Mer rätt!
    // Inventory inventory = new Inventory();
    MemberRegistry memberRegistry = new MemberRegistry();
    //RentalRegistry rentalRegistry = new RentalRegistry();

    MembershipService memberService = new MembershipService(memberRegistry); //Även PI och S objektet?
    RentalService rentalService = new RentalService(); //Skicka in inventory och rentalRegestry
    Rental rental = new Rental();
    PrivateIndividual privateIndividual = new PrivateIndividual();
    Society society = new Society();

    public void startMenuChoice() {
        System.out.println(
        """
         - RevENT UTHYRNING -
        [1] Medlemmar : Skapa ny medlem, gör förändringar i medlemslista.
        [2] Produkter : Se produkter, gör förändringar i produktlista.
        [3] Uthyrning : Skapa och avsluta uthyrning.
        [4] Ekomoni : Intäkter.
        [5] Avsluta.
        Skriv siffra sedan enter.""");
    }
    public void defaultListForTest() {
        memberService.defaultList();// default medlemmar för att det ska finnas nånting att testa med.
        rentalService.defaultList();//default produkter för att det ska finnas nånting att testa med.
    }

    public void productMenu(Scanner scan) {
        boolean subMeny = true;
        while(subMeny){
        System.out.println(" - PRODUKTER -");
        System.out.println(" Gör ett val: \n[V] Visa alla produkter. [D] Dräkter. [H] Hoppborgar. [N] Ny produkt. [X] Ta bort produkt. [B] Backa till Huvudmeny");
        String itemSort = scan.nextLine();
          switch (itemSort.toUpperCase()) {
            case "V" : rentalService.printItemList();
            System.out.println();
                 break;
            case "D" : System.out.println("Dräkter");
                rentalService.printItemGroup("dräkt");
                System.out.println();
                break;
            case "H" : System.out.println("Hoppborgar");
                rentalService.printItemGroup("hopp");
                System.out.println();
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
            case "B" : System.out.println("Backar"); subMeny = false; break;
            default:
                System.out.println("Något blev fel. V = Alla produkter, D = Dräkter, H= Hoppborgar, S = Sök/ ta bort produkt, B = Bakåt till Huvudmeny.");
                break;
        }
    }}

    public void memberMenu(Scanner scan) {
        boolean subMeny = true;
        while(subMeny){
        System.out.println(" - MEDLEMMAR - \n Gör ett val : [NP] Ny medlem - Privatperson, [NF] Ny medlem - Förening, [S] Sök medlem, [U] Uppdatera / ta bort befintlig medlem. [H] Historik - medlemsspecifik. [B] Backa till Huvudmeny");
        String memberActionChoice = scan.nextLine();
         switch (memberActionChoice.toUpperCase()) {
            case "NP":
                System.out.println("NY MEDLEM - privatperson.\n Ange först personnummer och för och efternamn separerat med mellanslag.");
                String memberId = scan.next();
                String memberFname = scan.next() + " ";
                String memberLname = scan.next();
                clearingScan(scan);
                memberService.newMember(memberId, memberFname + memberLname, "Privat");
                System.out.println("Medlem skapad.");
                break;
            case "NF":
                System.out.println("NY MEDLEM - Förening.\n Ange först organisationsnummer och sedan namn på föreningen. Separerat med enter-slag.");
                String socMemberId = scan.nextLine();
                String socMemberName = scan.nextLine();
                memberService.newMember(socMemberId, socMemberName, "Förening");
                System.out.println("Medlem skapad.");
                break;
            case "S":
                System.out.println("-SÖKNING I MEDLEMSLISTA-");
                memberService.searchInfo();
                String userSearch = scan.nextLine();
                memberService.checkListPrintMembersFound(userSearch);
                break;
            case "U":
                System.out.println("- UPPDATERINGAR AV MEDLEM -\n Vill du ta bort en medlem ur listan helt? Ange X, enter." +
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
            case "H": System.out.println("- MEDLEMSHISTORIK -"); // dold i menyval av säkerhetskäl. Bara superadmins vet.
                memberService.searchInfo();
                String userHistory = scan.nextLine();
                 memberService.getMemberHistory(memberService.searchMemberByNameOrIdReturnMember(userHistory));
                break;
            case "E":
                //Test Case
                 break;
            case "B":
                System.out.println("Backar"); subMeny =false; break;
            case "A": System.out.println("- MEDLEMSLISTA -");
               memberService.printMemberReg();
               break;
            default:
                System.out.println("Något blev fel. N = Ny medlem. S = Söka medlem. U = Uppdatera medlem. H = Historik. B =  Bakåt till huvudmeny.");
                break;
        }
    }}

    public void rentalMenu(Scanner scan) {
        boolean subMeny = true;
        while(subMeny){
        System.out.println("- UTHYRNING -");
        System.out.println("[N] Ny uthyrning.[A] Avsluta uthyrning. [H] Historik - uthyrningar . [B] Backa till huvudmeny");
        String userRentalChoice = scan.nextLine();
        switch (userRentalChoice.toUpperCase()){

            case "N" : System.out.println("NY UTHYRNING.");
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
            case "A" : System.out.println(" - AVSLUTA UTHYRNING -");
                System.out.println("Återlämning av uthyrd produkt ");
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
                rental.getRentalList().get(returningMember).setReturned(true);
                rental.countActualDays(dateStopRent,returningMember);} else {System.out.println("Avbryter återlämning.");return;}
                //Prisuträkning
                double rentalItemDayprice = rental.returnRentalDayPrice(returningMember);
                int rentalItemDaysRented = rental.rentalCountDays(returningMember);
                double totalBasePrice = rental.calculateDay(rentalItemDayprice, rentalItemDaysRented);
                if(returningMember.getMemberStatus().equalsIgnoreCase("privat")){
                 String totalPrice = privateIndividual.priceVAT(privateIndividual.discount(totalBasePrice));
                System.out.println("Utyrningen varade i "+ rentalItemDaysRented + " dagar.\n"+ totalPrice);
                }else{ String totalPrice = society.priceVAT(society.discount(totalBasePrice));
                System.out.println("Uthyrningen varade i "+ rentalItemDaysRented + " dagar.\n"+ totalPrice);}
                break;
            case "H" : System.out.println(" - AKTUELL UTHYRNINGSHISTORIK - ");
            rental.printRentalsList();
                 break;
            case "B" : System.out.println("Backar"); subMeny= false; break;
            default:
                System.out.println("Något blev fel. N = Ny utyrning. A = Avsluta uthyrning. H = Historik. B = Bakåt till huvudmeny.");
                 break;
        }
    }}

 public void economyMenu() {
        System.out.println(" - EKONOMI - ");
     rental.sumRentalsList();
    }

public void clearingScan(Scanner scan){ scan.nextLine();}
}
