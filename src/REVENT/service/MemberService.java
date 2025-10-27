package REVENT.service;

import REVENT.enity.Member;
import REVENT.database.MemberRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService extends MemberRegistry {

    public void newMemberIndividual(String id, String name, String memberStatus){
        Member member = new Member(id,name,memberStatus);
        addMemberList(member); }

    public void addMemberList(Member member) {
        getMemberRegistryList().add(member);
    }
    public void searchInfo(){
        System.out.println("Vilken medlem letar du efter? Ange Namn eller Personnummer på personen.");
    }
    public void searchMemberReg(String nameOrId){
        List<Member> foundM= new ArrayList<>();
        for(Member m : getMemberRegistryList()){
            if(m.getName().equals(nameOrId)|| m.getId().equals(nameOrId)){
               foundM.add(m);}}
            if(foundM.isEmpty()){System.out.println("Hittade tyvärr ingen match.");}
            else { for(Member member : foundM){
                System.out.println("Hittade "+member.getName()+" med ID: "+ member.getId());}}
    }
    public void removeMember(String nameOrId, Scanner scan){
        List<Member> removeM = new ArrayList<>();
        for(Member m : getMemberRegistryList()){
            if(m.getName().equals(nameOrId)|| m.getId().equals(nameOrId)){
            System.out.println("Hittade "+m.getName()+" med ID: "+ m.getId()+ ". Ska den medlemmen tas bort från listan? JA / NEJ");
            String removeUser = scan.nextLine();
            if(removeUser.equalsIgnoreCase("ja")){ removeM.add(m);} }}
        if (removeM.isEmpty()){return;}
        memberRegistryList.removeAll(removeM);
                    System.out.println("Medlem borttagen.");
    }

    public void printMemberReg() {
        if (getMemberRegistryList().isEmpty()){System.out.println("Listan är tom.");}
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
