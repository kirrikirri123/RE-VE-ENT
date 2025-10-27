package REVENT;

import REVENT.enity.Member;
import REVENT.service.MemberService;
import REVENT.service.RentalService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MemberService memberService = new MemberService(); //Det enda objektet vi vill ha av denna klass.
        RentalService rentalService = new RentalService(); // Det enda objektet vi vill ha av denna klass.
        boolean isRunning = true;
        memberService.defaultList();// default medlemmar för att det ska finnas nånting att testa med.
        rentalService.defaultList();//default produkter för att det ska finnas nånting att testa med.
        while (isRunning) {
            System.out.println("RevENTs uthyrning");
            System.out.println("[1] Medlemmar: Skapa ny medlem, gör förändringar i medlemslista." +
                    "\n[2] Produkter: Lägg till eller ta bort produkter. " +
                    "\n[3] Uthyrning : Ny uthyrning." +
                    "\n[4] Ekomoni : Intäkter." +
                    "\n[5] Avsluta");
            System.out.println("Skriv siffra sedan enter.");
            int userChoice = scan.nextInt(); // felhantering
            switch (userChoice) {
                case 1: isRunning= false; break;
                case 2: System.out.println("Produkter");
                rentalService.printItemList();
                     break;
                case 3: System.out.println("Uthyrning"); break;
                case 4: System.out.println("Ekonomi"); break;
                case 5:System.out.println("Avsluta programmet"); isRunning = false; break;
                default: System.out.println("Något blev fel. Försök igen. Välj mellan [1] till [5]");
            }            }
            boolean memberLoop = true;
            while(memberLoop) {
             System.out.println("Medlemslista\n Välj åtgärd: [N] Ny medlem, [S] Sök medlem, [U] Uppdatera / ta bort befintlig medlem.[H] Huvudmeny");
                            String memberActionChoice = scan.next();
            switch (memberActionChoice){
                case "n":
                case "N" : System.out.println("Ny Medlem. Ange personnummer och för och efternamn separerat med mellanslag.");
                String memberId = scan.next();String memberFname = scan.next()+" ";String memberLname = scan.next();
                memberService.newMemberIndividual(memberId,memberFname+memberLname,"Privat");
                                       scan.nextLine();break;
                case "s":
                case "S" : System.out.println("Sökning i Medlemslistan.");
                    String userSearch = memberService.searchInfo("Vilken medlem letar du efter? Ange Namn eller Personnummer på personen.",scan);
                    memberService.searchMemberReg(userSearch);
                    scan.nextLine(); break;
                case "u":
                case "U" : System.out.println("Uppdateringar. Vill du ta bort en medlem ur listan helt? Ange X, enter." +
                        "\n Önskar du uppdatera befintlig medlemsinfo? Ange U, sedan enter.");
                        String userChange = scan.nextLine();
                        if(userChange.equalsIgnoreCase("X")){
                        String userRemove = memberService.searchInfo("Vilken medlem letar du efter? Ange Namn eller Personnummer på personen.", scan); memberService.removeMember(userRemove,scan);
                        } else if (userChange.equalsIgnoreCase("U")) {System.out.println("Under uppbyggnad.");}
                    scan.nextLine(); break;
                case "h":
                case "H" : System.out.println("Avslutar"); memberLoop = false; break;
                case "A" : memberService.printMemberReg();break;
                default: System.out.println("Något blev fel. N = Ny medlem, S = Söka medlem, U = Uppdatera medlem, H = Huvudmeny.");  scan.nextLine();break;}}

          // utanför programmet..
           }

    }



