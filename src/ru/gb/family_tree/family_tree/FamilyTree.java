package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private  long humansId;
    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public boolean addHuman(Human human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for(Human human: humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    private boolean checkId(long id) {
        return id < humansId && id >= 0;
    }

    public  Human getById(long id){
        for(Human human: humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public boolean setWedding (long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)) {
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            return  setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding (Human human1, Human human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return  true;
        }
        return false;
    }

    public boolean setDivorce (long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)) {
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            return  setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce (Human human1, Human human2){
        if (human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return  true;
        }
        return false;
    }

    public boolean remove(long humansId){
        if(checkId(humansId)){
            Human human = getById(humansId);
            return  humanList.remove(human);
        }
        return false;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("In tree ");
        sb.append(humanList.size());
        sb.append(" objects: \n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
                    }
        return sb.toString();
    }
}
