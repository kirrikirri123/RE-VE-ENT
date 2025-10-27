package REVENT.database;

import REVENT.enity.Member;

import java.util.HashSet;

public class MemberRegistry {
protected HashSet<Member> memberRegistryList = new HashSet<>();

public MemberRegistry(){}

    public HashSet<Member> getMemberRegistryList() {
        return memberRegistryList;
    }
        public void setMemberRegistry(HashSet<Member> memberRegistryList){
        this.memberRegistryList = memberRegistryList; // går denna ens att använda??
    }
}



