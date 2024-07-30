package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.human.comparators.HumanComparatorByFirstName;
import ru.gb.family_tree.human.comparators.HumanComparatorByLastName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
   // private int idHuman;
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }



    public boolean addHuman(Human human) {
        if (human==null){
            return false;
        }
        if (!humans.contains(human)){
            humans.add(human);
          //  human.setId(idHuman++);

            addToParens(human);
            addToChildren(human);

            return true;
        }
        return false;
    }


    public void addToParens(Human human) {
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    public void addToChildren(Human human) {
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public int getSize() {
       return humans.size();
    }

    public List<Human> findByName(String name) {
        List<Human> result = new ArrayList<>();

        for (Human human: humans){
           if (human.getFirstName().equals(name)){
               result.add(human);
           }
        }

        return result;
    }

   public Human getById(int id){
       for (Human human: humans){
         if (human.getId()==id){
             return human;
           }
       }
       return null;
   }
   //список братьев и сестер
    public List<Human> geSistAndBr(int id){
        Human human = getById(id);
        if (human==null){
            return null;
        }

        List<Human> result = new ArrayList<>();
        for (Human parent: human.getParents()){

            for (Human child: parent.getChildren()) {
                if (!child.equals(human)){
                    result.add(child);
                }

            }
        }

        return result;

    }

    public boolean setWedding(int idHuman1, int idHuman2){

            Human hum1=getById(idHuman1);
            Human hum2=getById(idHuman2);
            setWedding(hum1, hum2);
            return true;



    }

//    private boolean checkId(int id){
//        return id < idHuman && id>=0;
//
//    }
    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse()==null && human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else{
            return false;
        }

    }

    @Override
    public String toString() {
        StringBuilder sorse = new StringBuilder();
        sorse.append("В семейном древе ");
        sorse.append(humans.size());
        sorse.append(" объекта.");
        sorse.append("\n");
        for (Human hum: humans) {
            sorse.append(hum);
            sorse.append("\n");
        }
        return sorse.toString();
    }


    public void sortByAge() {
        Collections.sort(humans, new HumanComparatorByAge());
    }

    public void sortByFirstName() {
        Collections.sort(humans, new HumanComparatorByFirstName());
    }

    public void sortByLastName() {
        Collections.sort(humans, new HumanComparatorByLastName());
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }





}
