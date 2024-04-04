package family_tree.family_tree;
import family_tree.hunan.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long igForGen;
    private final List<Human> humanList;

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(igForGen++);
            addToParents(human);
            addToChhildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild((human));
        }
    }

    private void addToChhildren (Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child:parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName (String name){
        List<Human> res = new ArrayList<>();
        for(Human human: humanList)
            if (human.getName(name).equals(name)) res.add(human);
            return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if(checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding (human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2){
        if (human1.getSpouse() == null && human2.getSpouse()== null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean remove(long humansId){
        if (checkId(humansId)){
            Human human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId (long id){
        return id < igForGen && id >= 0;
    }

    public Human getById(long id){
        if (checkId(id)){
            for (Human human: humanList) {
                if (human.getId() == id){
                    return human;
                }
            }
        }
        return null;
    }

      public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объуктов: \n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}

