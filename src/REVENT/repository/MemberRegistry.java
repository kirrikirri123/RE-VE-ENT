package REVENT.repository;

import java.util.HashMap;

public class MemberRegistry {
private HashMap<String,String> MemberRegistry = new HashMap<>();

public MemberRegistry(){}

    public HashMap<String, String> getMemberRegistry() {
        return MemberRegistry;
    }
        public void setMemberRegistry(HashMap<String,String> memberRegistry){
    this.MemberRegistry = memberRegistry;
    }
}



