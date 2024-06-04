package FamTree;

import com.sun.source.tree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansId;
    private List<Human> humanList;

    public FamilyTree() { this(new ArrayList<>()); }
    public FamilyTree(List<Human> humanList) { this.humanList = humanList; }

    public boolean add(Human human) {
        if ( human == null ) return false;
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId ++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parentL : human.getParents()) {
            parentL.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human childL : human.getChildren()) {
            childL.addParent(human);
        }
    }

    public List<Human> getSiblings(long id) {
        Human human = getById(id);
        if (human == null) return null;
        List<Human> siblings = new ArrayList<>();
        for (Human parentL : human.getParents()) {
            for (Human child : parentL.getChildren()) {
                if (!child.equals(human)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public List<Human> getByName(String name) {
        List<Human> result = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }


    public boolean setDivorce(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null){
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long humanId){
        if (checkId(humanId)){
            Human human = getById(humanId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId  &&  id >= 0;
    }

    public Human getById(long id) {
        for (Human human : humanList) {
            if (human.getId() == id) return human;
        }
        return null;
    }

    @Override
    public String toString() { return getInfo(); }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В Дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
