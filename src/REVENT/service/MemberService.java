package REVENT.service;

import REVENT.enity.Member;
import REVENT.repository.MemberRegistry;

public class MemberService extends MemberRegistry {
    //hanterar member

    public void newMemberIndividual(String id, String name, String memberStatus){
        Member member = new Member(id,name,memberStatus);
        addMemberList(member); }

    public void addMemberList(Member member) {
        getMemberRegistryList().add(member);
    }
    public void searchMemberReg(){
        //search
    }
    public void removeMember(){
        //remove member from list
    }
    public void printMemberReg() {
        for (Member m: getMemberRegistryList()){
            System.out.println(m);
        }
    }

}
