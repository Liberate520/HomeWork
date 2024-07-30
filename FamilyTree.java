package family_tree.family_tree;

import family_tree.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree E <extends TreeNode<E>> implements Serializable, Iterable<E> {
      public FamilyTree(){this (new ArrayList<>());
    }
    public FamilyTree(List<E> humanList){
        this.humanList=humanList;
    }
    public boolean add (E human){
        if (human==null){
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
    private void addToParents(E human){
        for (E parent : human.getParents()){
            parent.addChild(human);
        }

    }
    private void addToChildren(E human){
        for (E child: human.getChildren() ){
            child.addParent(human);
        }
    }
    public List<E> getSubLings(int id){
       E human = getById(id);
        if (human==null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()){
            for (E child : human.getChildren()){
               if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }
    public List<E> getByName(String name){
        List<E>res = new ArrayList<>();
        for (E human : humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }
    public boolean setWedding( long humansId1, long humansId2){
        if (checkId(humansId1)&& checkId(humansId2)){
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            return setWedding(human1,human2);

        }
        return false;
    }
    public boolean setWedding( Human human1 , Human human2){
        if (human1.getSpouse()==null&& human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }else {
            return false;
        }
    }
    public boolean setDivorce( E human1 , E human2){
        if (human1.getSpouse()!=null&& human2.getSpouse()!=null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }else {
            return false;
        }
    }
    public boolean remove(long humansId){
        if (checkId(humansId)){
            E human=getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }
    private boolean checkId(long id){ return id < humansId && id>=0;}

    public E getById(long id){
        for (E human : humanList){
            if (human.getId()==id){
                return human;
            }
        }
        return null;
    }


    @Override
    public Iterator<E> iterator()  {
        return new FamilyTreeIterator<>(humanList);
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate<>());
    }
    public void  sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

}

@Override
public String toString() {return getInfo();
}
public String getInfo(){
    StringBuilder sb = new StringBuilder();
    sb.append("В дереве ");
    sb.append(humanList.size());
    sb.append(" объектов: \n");
    for (E human: humanList){
        sb.append(human);
        sb.append(" \n");
    }
    return sb.toString();


}
