package model.FamilyTree;

import model.Human.Human;
import model.Human.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E>{
    private int countPeople;
    private final List<E> humanList;
    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }


    public void add(E human){
//        if(human == null){
//            return false;
//        }
//        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(countPeople++);
//
//            addToParents(human);
//            addToChildren(human);
//
//            return true;
//        }
//        return false;
    }

    private void addToParents(E human){
        for(E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for(E children: human.getChildren()){
            children.addParent(human);
        }
    }

    public List<E> searchByName(String name){
        List<E> res = new ArrayList<>();
        for(E human: humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public E getParentsByName(String name){
        for(E human: humanList) {
            if (human.getName().equals(name)) {
                return human;
            } else {
                Human newHuman = new Human(name);
                add((E) newHuman);
                return (E) newHuman;
            }
        }
        return null;
    }

    private boolean checkId(int id){
        return id < countPeople && id >= 0;
    }

    public E getById(int id){
        if(checkId(id)){
            for (E human: humanList){
                if(human.getId() == id){
                    return human;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(humanList.size());
        stringBuilder.append(" объектов: \n");
        for(E human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        humanList.sort(new FamilyTreeComparatorByName<E>());
    }

    public void sortByBirthDate(){
        humanList.sort(new FamilyTreeComparatorByBirthDate<E>());
    }
    @Override
    public Iterator<E> iterator(){
        return new FamilyTreeIterator(humanList);
    }
}
