package model.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeConn<E>> implements Serializable, Iterable<E> {
    //private String nameTree;
    private int humansId;
    private List<E> humanList;

    public FamilyTree(){this(new ArrayList<>());}
    public FamilyTree(List<E> humanList){this.humanList = humanList;}

   // public void setName(String name){
   //     nameTree = name;
   // }

    public boolean add(E human){
        if(human == null){ return false; }
        if(!humanList.contains(human)){

        humanList.add(human);
        human.setId(humansId++);
        yes();
        return true;
        }
        no();
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChildren(human);
        }
    }
    public void addToParents(int id){
        E human = getById(id);
        addToParents(human);
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }
    public void addToChildren(int id){
        E human = getById(id);
        addToChildren(human);
    }

    private boolean checkId(int id){
        return id <humansId && id >=0;
    }

    public E getById(int id){
        if(checkId(id)) {
            for (E human : humanList) {
                if (human.getId() == id) {
                    return human;
                }
            }
        } return null;
    }

    public List<E> getSiblings(int id){
        E human = getById(id);
        if(human == null){ return null; }
        List<E> result = new ArrayList<>();
        for (E parent : human.getParents()){
            for (E child : human.getChildren()){
                if(!child.equals(human)){ result.add(human);}
            }
        }
        return result;
    }
    public List<E> getByName(String name) {
        List<E> result = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }
    public boolean setWedding(int humansId1, int humansId2){
        if(checkId(humansId1)&&checkId(humansId2)){
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            return setWedding(human1, human2);
        }else {return false;}
    }
    public boolean setWedding(E human1, E human2){
        if(human1.getSpouse()== null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            System.out.println("");
            return true;
        }else { return false;}
    }

    public boolean setDivorce(int humansId1, int humansId2){
        if(checkId(humansId1)&&checkId(humansId2)) {
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            return setDivorce(human1, human2);
        }else { return false;}
    }
    public boolean setDivorce(E human1, E human2){
        if(human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            yes();
            return true;
        }else {
            no();
            return false;
        }
    }

    public boolean remove(int humansId){
        if(checkId(humansId)){
            E human = getById(humansId);
            yes();
            return humanList.remove(human);
        } else {
            no();
            return false;
        }
    }
    public void yes(){
        System.out.println("Успешно!");
    }
    public void no(){
        System.out.println("Не выполнено!");
    }

    @Override
    public String toString() {return getInfo();}

    public String getInfo(){
        StringBuilder infoTree = new StringBuilder();
        infoTree.append("Всего в дереве ");
        infoTree.append(humanList.size());
        infoTree.append(" человек. \n");
        for (E human : humanList){
            infoTree.append(human);
            infoTree.append("\n");
        }
        return infoTree.toString();
    }

    @Override
    public Iterator<E> iterator(){
        return new FamilyTreeIterator<>(humanList);
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }
    public void sortByBirsday(){
        humanList.sort(new HumanComparatorByBirthday<>());
    }
    public void sortById(){
        humanList.sort(new HumanComparatorById<>());
    }



}
