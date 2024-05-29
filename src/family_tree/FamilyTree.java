package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familytree;
    private long humansId;


    public FamilyTree(List<Human> familytree) {
        this.familytree = familytree;
    }


    public FamilyTree() {
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
    private boolean checkId(long id){
        return id < humansId && id >= 0;

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

    public void setWedding(Human human1, Human human2) {
        if  (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }


}