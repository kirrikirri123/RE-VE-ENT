package REVENT.service;

import REVENT.enity.Member;
import REVENT.repository.MemberRegistry;

public class MemberService {
    //hanterar member
    MemberRegistry memberRegistry = new MemberRegistry();

    public Member newMemberIndividual(String id, String name, String memberStatus){
        Member objName = new Member(id,name,memberStatus);
    return objName;}

    public void searchMember(){
        System.out.println(memberRegistry.getMemberRegistry());
    }

    public void removeMember(){
        //remove member from list
    }

}
