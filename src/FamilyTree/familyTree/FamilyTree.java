package FamilyTree.familyTree;

import FamilyTree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{
    private long humansId = 1;

    public List<Human> getHumanList() {
        return humanList;
    }

    private final List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if(human == null){
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addParents(human);
            addChild(human);

            return true;
        }
        return false;
    }

    private void addParents(Human human){
        if(human.getParents() != null) {
            for (Human parent : human.getParents()) {
                parent.addChild(human);
            }
        }
    }


    private void addChild(Human human){
        if(human.getChildren() != null) {
            for (Human child : human.getChildren()) {
                child.addParents(human);
            }
        }
    }

    public List<Human> searchByName(String name){
        List<Human> answer = new ArrayList<>();
        for (Human human : humanList){
            if(human.getName().equals(name)){
                answer.add(human);
            }
        }
        return answer;
    }

    public boolean setWadding(long humansId1, long humansId2){
        if(checkId(humansId1) && checkId(humansId2)){
            Human human1 = searchById(humansId1);
            Human human2 = searchById(humansId2);
            if(human1.getSpouse() == null && human2.getSpouse() == null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId && id > 0;
    }

    public Human searchById(long id){
        for (Human human : humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public void sortByName(){
        Collections.sort(humanList);
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В древе ").append(getHumanList().size()).append(" объектов.");
        for (Human human : humanList){
            sb.append("\n" + "[id ").append(human.getId()).append(", имя: ").append(human.getName()).append(", пол: ").append(human.getGender()).append(", возраст: ").append(human.getAge()).append(", супруг(а): ").append(human.getSpouseInfo()).append(", мать: ").append(human.getMotherInfo()).append(", отец: ").append(human.getFatherInfo()).append(", дети: ").append(human.getChildrenInfo()).append("]");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}