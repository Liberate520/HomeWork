package family_tree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansId;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    public void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(Human human) {
        for (Human children : human.getChildren()) {
            children.addParent(human);
        }
    }

    public List<Human> getSibling(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else
            return false;
    }

    public boolean setDivorce(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else
            return false;
    }


private boolean checkId(long id){
    return id < humansId && id >= 0;}


     public Human getById(long id){
        for (Human human: humanList){
            if( human.getId()==id){
                return human;
            }
        }
        return null;
     }

     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("В древе ");
         sb.append(humanList.size());
         sb.append(" объектов: \n");
         for (Human human : humanList) {
             sb.append(human);
             sb.append("\n");
         }
         return sb.toString();
     }
}
