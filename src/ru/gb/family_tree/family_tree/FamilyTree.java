package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.comparators.HumanComparatorByAge;
import ru.gb.family_tree.comparators.HumanComparatorByName;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanBuilder;
import ru.gb.family_tree.human.HumanIterator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int humansId;
    private HumanBuilder humanBuilder;
    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
        humanBuilder = new HumanBuilder();
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

//    public void addHuman(Human human){
//        humanList.add(human);
//    }

    public Human addHuman(String name, Gender gender, LocalDate birthDate){
        Human human = humanBuilder.build(name, gender, birthDate);
        humanList.add(human);

        return human;
    }
    public Human addHuman(String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        Human human = humanBuilder.build(name, gender, birthDate, null,father,mother);
        humanList.add(human);
        return human;
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }
    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
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

        for (Human human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }

}
