package ru.gb.family_tree.model.tree;

import ru.gb.family_tree.model.tree.comparators.HumanComparatorByAge;
import ru.gb.family_tree.model.tree.comparators.HumanComparatorByFirstName;
import ru.gb.family_tree.model.tree.comparators.HumanComparatorByLastName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends ItemFamilyTree<T>> implements Serializable, Iterable<T> {
   // private int idHuman;
    private List<T> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }



    public boolean addHuman(T human) {
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


    public void addToParens(T human) {
        for (T parent: human.getParents()){
            parent.addChild(human);
        }
    }

    public void addToChildren(T human) {
        for (T child: human.getChildren()){
            child.addParent(human);
        }
    }

    public int getSize() {
       return humans.size();
    }

    public List<T> findByName(String name) {
        List<T> result = new ArrayList<>();

        for (T human: humans){
           if (human.getFirstName().equals(name)){
               result.add(human);
           }
        }

        return result;
    }

   public T getById(int id){
       for (T human: humans){
         if (human.getId()==id){
             return human;
           }
       }
       return null;
   }
   //список братьев и сестер
    public List<T> geSistAndBr(int id){
        T human = getById(id);
        if (human==null){
            return null;
        }

        List<T> result = new ArrayList<>();
        for (T parent: human.getParents()){

            for (T child: parent.getChildren()) {
                if (!child.equals(human)){
                    result.add(child);
                }

            }
        }

        return result;

    }



    public boolean setWedding(int idHuman1, int idHuman2){

            T hum1=getById(idHuman1);
            T hum2=getById(idHuman2);
            setWedding(hum1, hum2);
            return true;



    }

//    private boolean checkId(int id){
//        return id < idHuman && id>=0;
//
//    }
    public boolean setWedding(T human1, T human2){
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
        for (T hum: humans) {
            sorse.append(hum);
            sorse.append("\n");
        }
        return sorse.toString();
    }


    public void sortByAge() {
        Collections.sort(humans, new HumanComparatorByAge<>());
    }

    public void sortByFirstName() {
        Collections.sort(humans, new HumanComparatorByFirstName<>());
    }

    public void sortByLastName() {
        Collections.sort(humans, new HumanComparatorByLastName<>());
    }


    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(humans);
    }


}
