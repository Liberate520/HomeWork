package tree;

import human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private int humansId;
    private List<Human> humanList;

    public FamilyTree(){this(new ArrayList<>());}
    public FamilyTree(List<Human> humanList){this.humanList = humanList;}

    public boolean add(Human human){
        if(human == null){ return false; }
        if(!humanList.contains(human)){

        humanList.add(human);
        human.setId(humansId++);
        //addToParents(human);
        //addToChildren(human);

        return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChildren(human);
        }
    }
    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    private boolean checkId(int id){
        return id <humansId && id >=0;
    }

    public Human getById(int id){
        if(checkId(id)) {
            for (Human human : humanList) {
                if (human.getId() == id) {
                    return human;
                }
            }
        } return null;
    }

    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if(human == null){ return null; }
        List<Human> result = new ArrayList<>();
        for (Human parent : human.getParents()){
            for (Human child : human.getChildren()){
                if(!child.equals(human)){ result.add(human);}
            }
        }
        return result;
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
    public boolean setWedding(int humansId1, int humansId2){
        if(checkId(humansId1)&&checkId(humansId2)){
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            return setWedding(human1, human2);
        }else {return false;}
    }
    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse()== null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }else { return false;}
    }

    public boolean setDivorce(int humansId1, int humansId2){
        if(checkId(humansId1)&&checkId(humansId2)) {
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            return setDivorce(human1, human2);
        }else { return false;}
    }
    public boolean setDivorce(Human human1, Human human2){
        if(human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }else { return false;}
    }



    public boolean remove(int humansId){
        if(checkId(humansId)){
            Human human = getById(humansId);
            return humanList.remove(human);
        } else { return false;}
    }

    @Override
    public String toString() {return getInfo();}

    public String getInfo(){
        StringBuilder infoTree = new StringBuilder();
        infoTree.append("Всего в дереве ");
        infoTree.append(humanList.size());
        infoTree.append(" человек. \n");
        for (Human human : humanList){
            infoTree.append(human);
            infoTree.append("\n");
        }
        return infoTree.toString();
    }



}
