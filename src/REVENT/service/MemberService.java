package REVENT.service;

import REVENT.enity.Member;
import REVENT.repository.MemberRegistry;

import java.util.Scanner;

public class MemberService extends MemberRegistry {
    //hanterar member

    public void newMemberIndividual(String id, String name, String memberStatus){
        Member member = new Member(id,name,memberStatus);
        addMemberList(member); }

    public void addMemberList(Member member) {
        getMemberRegistryList().add(member);
    }

    public void searchMemberReg(String nameOrId){
        for(Member m : getMemberRegistryList()){
            if(m.getName().equals(nameOrId)|| m.getId().equals(nameOrId)){
                System.out.println("Hittade "+m.getName()+" med ID: "+ m.getId());}
        }
    }
     public String searchInfo(String string,Scanner scan){
        System.out.println(string);
        return scan.nextLine();
    }

    public String whichMember(Scanner scan){
     return scan.nextLine(); // fungerar ej
    }

    public void removeMember(String nameOrId, Scanner scan){
        for(Member m : getMemberRegistryList()){
            if(m.getName().equals(nameOrId)|| m.getId().equals(nameOrId)){
            System.out.println("Hittade "+m.getName()+" med ID: "+ m.getId()+ "Ska den medlemmen tas bort från listan? JA / NEJ");
            String removeUser = scan.nextLine();
            if(removeUser.equalsIgnoreCase("ja")){ memberRegistryList.remove(m);System.out.println("Medlem borttagen.");}
            else {System.out.println("Söker vidare vidare.");}
        }}}

    public void printMemberReg() {
        for (Member m: getMemberRegistryList()){
            System.out.println(m);
        }
    }
    public void updateMember(){
        // förändra vad? Uppdatera namn eller id.
    }

    public void defaultList() { // För testning.
        newMemberIndividual("920618", "Kickan Karlsson","Privat");
        newMemberIndividual("690524","Bengan Bertholdsson","Privat");
        newMemberIndividual("123456", "Ersboda Pingisföreningsklubb","Förening");
    }

}
