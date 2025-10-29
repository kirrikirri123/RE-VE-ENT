package REVENT.service;

import REVENT.enity.Member;
import REVENT.repository.MemberRegistry;

import java.util.*;

public class MemberService extends MemberRegistry {
// Hanterar memberfunktioner.

    public void newMember(String id, String name, String memberStatus){
        Member member = new Member(id,name,memberStatus);
        addMemberList(member); }

    public void addMemberList(Member member) {
        getMemberRegistryList().add(member);
    }
    public void searchInfo(){
        System.out.println("Vilken medlem? Ange namn eller personnummer/organistationsnummer.");
    }
    public List<Member> searchMemberByNameIdReturnList(String nameOrId){ // söker lägger in i templista och returnerar lista
        List<Member> foundM= new ArrayList<>();
                for(Member m : memberRegistryList){
            if(m.getName().contains(nameOrId)|| m.getId().equals(nameOrId)){
                foundM.add(m);}}return foundM;}

     public Member searchMemberByNameOrIdReturnMember(String nameOrId) {
        Member foundMember = null;
        for (Member m : memberRegistryList) {
            if (m.getName().equalsIgnoreCase(nameOrId) || m.getId().equals(nameOrId)) {
                foundMember = m;
            }
        }
        return foundMember;
    }
        public void checkListPrintMembersFound(String nameOrId){
          List<Member> foundMatches = searchMemberByNameIdReturnList(nameOrId);
            if(foundMatches.size()>= 2) {
                System.out.println("Hittade flera matchningar: ");
                for (int i = 1; i < foundMatches.size(); i++) {
                    System.out.println("Nr. " + i + foundMatches.get(i).getName() + foundMatches.get(i).getMemberStatus());}
                // skriv er ut index i templistan så vi kan hitta det igen sen vid val??
            }else if(foundMatches.isEmpty()){System.out.println("Hittade ingen matchning.");}
             else { for(Member member : foundMatches){
               System.out.println("Hittade "+member.getName()+" med ID: "+ member.getId());}
            }}

    public void removeMember(String nameOrId, Scanner scan){
        List<Member> foundMatches = searchMemberByNameIdReturnList(nameOrId);
        if(foundMatches.isEmpty()){System.out.println("Hittade ingen matchning."); return;}
        for(Member m : foundMatches)
        {System.out.println("Hittade "+m.getName()+" med ID: "+ m.getId()+ ". Ska "+ m.getName()+" tas bort från listan? JA / NEJ");
            String removeUser = scan.nextLine();
            if(removeUser.equalsIgnoreCase("ja")){
           memberRegistryList.removeAll(foundMatches);
                    System.out.println("Medlem borttagen.");
    }}}

    public void getMemberHistory(Member member){
        if(member.getHistoryMember().isEmpty()){System.out.println("Finns ingen historik på vald medlem.");}
        else { for (Rental r : member.getHistoryMember() ){
       System.out.println(r); }
        }}

    public void printMemberReg() {
        if (memberRegistryList.isEmpty()){System.out.println("Listan är tom.");}
        for (Member m: memberRegistryList){
            System.out.println(m);
        }
    }
    public void findAndUpdateMember(String nameOrId, Scanner scan){
        checkListPrintMembersFound(nameOrId); // Blir fel om  man inte hittar nån matchning. Då rullar uskriften vidare.
        System.out.print("Ska profilen uppdateras?\n Om felaktigt ange X!");
        System.out.println("Vad vill du uppdatera? \n Ange : [N] Namn [M] Medlemsstatus");
        String userChoiceChange = scan.next();
        if(userChoiceChange.equalsIgnoreCase("N")) {
            System.out.println("Skriv in den nya namnet:");
            String memberFname = scan.next() + " ";
            String memberLname = scan.next(); // Lägg in metod som hanterar förändringen !
        }else if (userChoiceChange.equalsIgnoreCase("M")){
            System.out.println( "Om privatperson ange P. Om förening ange F.");
            String memberStatus = scan.next();// Lägg in metod som hanterar förändringen !
        }else {System.out.println("Backar till huvudmeny");}
            }

    public void defaultList() { // För testning.
        newMember("920618", "Kickan Karlsson","Privat");
        newMember("690524","Bengan Bertholdsson","Privat");
        newMember("123456", "Ersboda Pingisföreningsklubb","Förening");
    }

}
