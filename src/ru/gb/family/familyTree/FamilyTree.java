package ru.gb.family.familyTree;


import ru.gb.family.humans.Human;
import ru.gb.family.humans.comparators.HumanComparatorByAge;
import ru.gb.family.humans.comparators.HumanComparatorByBirthday;
import ru.gb.family.humans.comparators.HumanComparatorByChildren;
import ru.gb.family.humans.comparators.HumanComparatorByName;
import ru.gb.family.humans.enums.DegreeOfKinship;
import ru.gb.family.humans.enums.Gender;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humansId;
    private List<Human> familyTree;


    public FamilyTree() {
        familyTree = new ArrayList<>();

        }
    public boolean addHumanInTree(Human newHuman) {
        if (newHuman == null) {
            return false;
        }
        if (!(familyTree.contains(newHuman))) {
            this.familyTree.add(newHuman);
            newHuman.setId((int) humansId++);
        }
        return true;
    }
    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge());
    }
    public void sortByBirthday(){
        familyTree.sort(new HumanComparatorByBirthday());
    }
    public void sortByChildren(){
        familyTree.sort(new HumanComparatorByChildren());
    }
    public void sortByName(){
        this.familyTree.sort(new HumanComparatorByName());
    }

    public List<Human> searchByHuman (Human searchHuman){
        List<Human> result = new ArrayList<>();
        for (Human fd : familyTree ) {
            if (fd.equals(searchHuman)) {
                result.add(fd);
            }
        }
        return result;
    }
    public List<Human> searchByName (String name){
        List<Human> result = new ArrayList<>();
        for (Human fd : familyTree ){
            if (fd.getName().contains(name)){
                result.add(fd);
            }
        }
        return result;
    }
    public List<Human> searchByGender (Gender gender){
        List<Human> result = new ArrayList<>();
        for (Human fd : familyTree ){
            if (fd.getGender().equals(gender)){
                result.add(fd);
            }
        }
        return result;
    }
    public List<Human> searchByDegreeOfKinship (DegreeOfKinship degreeOfKinship){
        List<Human> result = new ArrayList<>();
        for (Human fd : familyTree ){
            switch (degreeOfKinship) {
                case Mother:
                    if (fd.getMother() != null){
                        result.add(fd);
                    }
                    break;
                case Father:
                    if (fd.getFather() != null){
                        result.add(fd);
                    }
                    break;
                case Children:
                    if (!(fd.getChildren().isEmpty())){
                        result.add(fd);
                    }
                    break;
            }
        }
        return result;
    }

    public StringBuilder findChildrenHuman (Human searchHuman){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----У человека ["+searchHuman.getName()+"]  из семейного дерева-------------");
        stringBuilder.append("\n");
        for (Human fd : this.familyTree ){
           if (fd.equals(searchHuman)){
               if (fd.getChildren() != null){
                   stringBuilder.append("Есть дети:\n");

                   // список детей
                   for (Human human : fd.getChildren()){
                       stringBuilder.append(human.getName()+"("+human.getAge()+" лет.))");
                       stringBuilder.append("\t\n");

                   }

               }
               else{
                   stringBuilder.append("\nНет детей! ");
               }
               stringBuilder.append("----------------------------------------------");

            }
        }
        return stringBuilder;
    }



    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator();
    }
    public StringBuilder printResult(List<Human> result){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        stringBuilder.append("Результаты поиска:");
        for (Human human : result){
            stringBuilder.append("\n id=" + human.getId() + '\t' +
                    "name=" +human.getName() +" ("+human.getAge()+" лет.))"+
                    "\t birthday(" + human.getBirthday() +
                    ")\t dateOfDeath(" + human.getDateOfDeath() +
                    ")\t gender=" + human.getGender());

            stringBuilder.append("\t");
        }
    return stringBuilder;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список семейного Дерева:\n");
        for (Human human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
