package family_tree.family_tree;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.human.HumanComparatorByBirthDate;
import family_tree.human.HumanComparatorByFirstName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansId;
    private List<Human> humanList;



    public FamilyTree(List<Human> humanList){
        this.humanList =humanList;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(Human human){
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
    private void addToParents(Human human) {
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human) {
        for (Human child: human.getChildren()){
            child.addChild(human);
        }
    }

    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }


    public List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getFirstName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    private boolean checkId (long id){
        return id < humansId && id >= 0;
    }

    public boolean remove(long humansId){
        if (checkId(humansId)){
            Human human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    public Human getById(long id){
        for (Human human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов; \n");
        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return  sb.toString();
    }


    public Iterator<Human> Iterator() {
        return new FamilyTreeIterator(humanList);
    }

    public void HumanComparatorByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate());
    }

    public void HumanComparatorByName(){
        humanList.sort(new HumanComparatorByFirstName());
    }



}
