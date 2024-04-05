package FamilyTree.HomeWork.src;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private List<Human> familytree;
    private long humansId;


    public Family(List<Human> familytree) {
        this.familytree = familytree;
    }


    public Family() {
        this(new ArrayList<>());
    }

    public boolean addRalative(Human human){
        if (!familytree.contains(human)){
            familytree.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChildren(human);
        }
    }
    public void addToChildren(Human human) {
        for (Human children: human.getChildren()) {
            children.addParents(human);
        }
    }

    public List<Human> getByName(String name) {
        List <Human> rez = new ArrayList<>();
        for(Human human : familytree) {
            if(human.getName().equals(name)) {
                rez.add(human);
            }
        }
        return rez;
    }

    public Human getById(long id) {
        for(Human human : familytree) {
            if(human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Люди в дереве: \n");
        for(Human human: familytree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}