package FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Humans.Human;

public class FamilyTree implements Serializable {
    // private int humID;
    private List<Human> humans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humans){
        this.humans = humans;
    }

    // public boolean add(Human human){
    //     if (human == null) {
    //         return false;
    //     }
    //     if (!humans.contains(human)) {
    //         humans.add(human);
    //         human.setID(humID++);
            
    //         addToParents(human);
    //         addToChildren(human);
    //         addToGrandParents(human);
    //         addToGrandChildren(human);

    //         return true;
    //     }
    //     return false;        
    // }

    // private void addToParents(Human human){
    //     for (Human parent : human.getParents()) {
    //         parent.addChild(human);
    //     }
    // }

    // private void addToGrandParents(Human human){
    //     for (Human grandparent : human.getGrandParents()) {
    //         grandparent.addChild(human);
    //     }
    // }

    // private void addToChildren(Human human){
    //     for (Human child : human.getChildren()) {
    //         child.addParent(human);
    //     }
    // }

    // private void addToGrandChildren(Human human){
    //     for (Human grandchild : human.getGrandchildren()) {
    //         grandchild.addGrandParent(human);
    //     }
    // }

    public Human getByName(String humanName){
        for (Human human : humans) {
            if (human.getName().equals(humanName)) {
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Количество людей в дереве: ");
        sb.append(humans.size());
        sb.append("\n");
        for (Human human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    
}
