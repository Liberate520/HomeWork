package src.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import src.Human.Human;
import src.Human.HumanComparatorByAge;
import src.Human.HumanComparatorByChildrenAmount;
import src.Human.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable <Human> {
    private List <Human> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    //  add member to family tree
    public void addMember(Human member) {
        members.add(member);
    }

    // find member by name
    public Human getMember (String name) {
        for (Human member: members) {
            if(member.getName().equals(name)){
                return member;
            }
        }
        return null;
    }
    
    // print entire family tree
    // public void printTree() {
    //     for (Human member : members) {
    //         System.out.println(member.toString());
    //     }
    // }

    public void SortByName() {
        Collections.sort(members, new HumanComparatorByName());
    }

    public void SortByBirthday(){
        Collections.sort(members, new HumanComparatorByAge());
    }

    public void SortByChildren(){
        Collections.sort(members, new HumanComparatorByChildrenAmount());
    }

    public String GetFamilyInfo(){
        StringBuilder sb = new StringBuilder();
        for (Human member: members){
            sb.append(member);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(members);        
    }    
}
