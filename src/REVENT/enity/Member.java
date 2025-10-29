package REVENT.enity;

import REVENT.service.Rental;

import java.util.LinkedList;
import java.util.List;

public class Member {
    private String id;
    private String name;
    private String memberStatus; //private eller society
    private List<Rental> historyMember = new LinkedList<>();

    public Member (){}
    public Member (String id, String name, String memberStatus) {
        this.id = id;
        this.name = name;
        this.memberStatus = memberStatus;
    // vad händer med listan??
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMemberStatus() {
        return memberStatus;
    }
    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }
    public List<Rental> getHistoryMember() {
        return historyMember;
    }
    public void setHistoryMember(List<Rental> historyMember) {
        this.historyMember = historyMember; // Denna går väll inte använda??
        }
@Override
    public String toString() {
       return "Id-nummer:"+ this.id + "\n Namn:"+ this.name +".";
}
}
