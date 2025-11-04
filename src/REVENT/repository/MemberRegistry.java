package REVENT.repository;

import REVENT.enity.Member;

import java.util.HashSet;
import java.util.Set;

public class MemberRegistry {
private Set<Member> memberRegistryList = new HashSet<>();

public MemberRegistry(){}

    public Set<Member> getMemberRegistryList() {
        return memberRegistryList;
    }

}



