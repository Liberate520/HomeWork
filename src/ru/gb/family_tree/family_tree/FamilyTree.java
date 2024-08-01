package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.human.comparators.HumanComparatorByName;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanBuilder;
import ru.gb.family_tree.human.HumanIterator;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeInterface> implements Serializable, Iterable<T> {
    private int humansId;
    private HumanBuilder humanBuilder;
    private List<T> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
        humanBuilder = new HumanBuilder();
    }

    public FamilyTree(List<T> humanList){
        this.humanList = humanList;
    }

//    public void addHuman(Human human){
//        humanList.add(human);
//    }

    public T add(String name, Gender gender, LocalDate birthDate){
        T human = (T) humanBuilder.build(name, gender, birthDate);
        humanList.add(human);

        return human;
    }
    public T add(String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        T human = (T) humanBuilder.build(name, gender, birthDate, null,father,mother);
        humanList.add(human);
        return human;
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName<>());
    }
    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge<>());
    }

//    private void addToParents(T human){
//        for(T patent: human.getParents()){
//            patent.addParent(human);
//        }
//    }
//
//    private void addToChildren(T human){
//        for (T child: human.getChildren()){
//            child.addParent(human);
//        }
//    }

    public List<T> getByName(String name){
        List<T> res = new ArrayList<>();
        for(T human: humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    private boolean checkId(long id) {
        return id < humansId && id >= 0;
    }

    public  T getById(long id){
        for(T human: humanList){
            if(human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public boolean setWedding (long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)) {
            T human1 = getById(humansId1);
            T human2 = getById(humansId2);
            return  setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding (T human1, T human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return  true;
        }
        return false;
    }

    public boolean setDivorce (long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)) {
            T human1 = getById(humansId1);
            T human2 = getById(humansId2);
            return  setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce (T human1, T human2){
        if (human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return  true;
        }
        return false;
    }

    public boolean remove(long humansId){
        if(checkId(humansId)){
            T human = getById(humansId);
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

        for (T human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humanList);
    }

}
