package REVENT.service;

import REVENT.enity.Member;
import REVENT.database.MemberRegistry;

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
    public List<Member> searchMemberByNameId(String nameOrId){ // söker lägger in i templista och returnerar lista
        List<Member> foundM= new ArrayList<>();
                for(Member m : memberRegistryList){
            if(m.getName().equalsIgnoreCase(nameOrId)|| m.getId().equals(nameOrId)){
                foundM.add(m);}}return foundM;
    }
        public void printSearchMemberReg(String nameOrId){
          List<Member> foundMatches = searchMemberByNameId(nameOrId);
         if(foundMatches.isEmpty()){System.out.println("Hittade ingen match. Prova igen.");}
       for(Member member :foundMatches){
                System.out.println("Hittade "+member.getName()+" med ID: "+ member.getId());}
            }

    public void removeMember(String nameOrId, Scanner scan){
        List<Member> foundMatches = searchMemberByNameId(nameOrId);
        if(foundMatches.isEmpty()){System.out.println("Hittade ingen matchning."); return;}
        for(Member m : foundMatches)
        {System.out.println("Hittade "+m.getName()+" med ID: "+ m.getId()+ ". Ska "+ m.getName()+" tas bort från listan? JA / NEJ");
            String removeUser = scan.nextLine();
            if(removeUser.equalsIgnoreCase("ja")){
           memberRegistryList.removeAll(foundMatches);
                    System.out.println("Medlem borttagen.");
    }}}

    public void getMemberHistory(Member member){
       System.out.println(member.getHistoryMember()); // måste man göra en loop?
    }

    public void printMemberReg() {
        if (memberRegistryList.isEmpty()){System.out.println("Listan är tom.");}
        for (Member m: memberRegistryList){
            System.out.println(m);
        }
    }
    public void updateMember(String nameOrId, Scanner scan){
        List<Member> foundMatches =searchMemberByNameId(nameOrId);
        if(foundMatches.isEmpty()){System.out.println("Hittade ingen matchning."); return;}
        for(Member m : foundMatches)
        {System.out.println("Hittade "+m.getName()+" med ID: "+ m.getId()+ ". Ska "+ m.getName()+ "s profil uppdateras?\n Om felaktigt ange X!");}
        System.out.println("Vad vill du uppdatera? \n[N] Namn. [M] Medlemsstatus");
        String userChoiceChange = scan.next();
        if(userChoiceChange.equalsIgnoreCase("N")) {
            System.out.println("Skriv in den nya namnet:");
            String memberFname = scan.next() + " ";
            String memberLname = scan.next(); // Lägg in metod som hanterar förändringen !
        }else if (userChoiceChange.equalsIgnoreCase("M")){ // Lägg in metod som hanterar förändringen !
            System.out.println( "Om privatperson ange P. Om förening ange F.");
            String memberStatus = scan.next();
        }else {System.out.println("Backar till huvudmeny");}

    }


    public void defaultList() { // För testning.
        newMember("920618", "Kickan Karlsson","Privat");
        newMember("690524","Bengan Bertholdsson","Privat");
        newMember("123456", "Ersboda Pingisföreningsklubb","Förening");
    }

}
