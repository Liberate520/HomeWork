package family_tree;

import man.Gender;
import man.Man;
import man.comparator.ItemComparatorByAge;
import man.comparator.ItemComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree <E extends FamilyTreeItem> implements Serializable, Iterable<E>{
    private long id;
    private ArrayList <E> group;
    public FamilyTree(ArrayList <E> items){
        this.group = items;
    }

    public FamilyTree(){
        group = new ArrayList<>();
    }

    public boolean addToFamilyTree(E groupItem) {
        if (groupItem == null){
            System.out.println("Пусто...");
            return false;
        }
        if (!group.contains(groupItem)) {
            group.add(groupItem);
            groupItem.setId(id++);
            System.out.println(groupItem.getName() + " добавлен");
            addToParents(groupItem);
            addToChildren(groupItem);
            return true;
        } else {
            System.out.println(groupItem.getName() + " Ошибка! Уже был добавлен");
            return false;
        }
    }
    private void addToParents(E groupItem){
        if (groupItem.getParents()!= null) {
            for (Object parent : groupItem.getParents()) {
                ((E)parent).addChild(groupItem);
            }
        }
    }

    private void addToChildren(E groupItem) {
        if (groupItem.getChildrens()!= null) {
            for (Object child : groupItem.getChildrens()) {
                if (groupItem.getGender().equals(Gender.Female)) {
                    ((E)child).addMother(groupItem);
                } else {
                    ((E)child).addFather(groupItem);
                }
            }
        }
    }
    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E man : group) {
            if (man.getName().equals(name)) {
                res.add(man);
            }
        }
        return res;
    }

    public boolean setWedding(Man man, Man man2){
        if (man.getSpouse() == null && man2.getSpouse() == null){
            man.getMerried(man);
            man2.getMerried(man2);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean setDivorce(Man man, Man man2){
        if (man.getSpouse().equals(man2)){
            man.getMerried(null);
            man2.getMerried(null);
            return true;
        }
        else {
            System.out.println(man + "не состоит в браке с " + man2);
            return false;
        }
    }
    public boolean remove(long currentId){
        if(currentId<id && id>=0){
            E currentMan = getById(currentId);
            return group.remove(currentMan);
        }
        return false;
    }

    public E getById(long id){
        for (E groupItem : group) {
            if (groupItem.getId() == id){
                return groupItem;
            }
        }
        return null;
    }

    public void sortByName(){
        group.sort(new ItemComparatorByName());
    }

    public void sortByAge(){
        group.sort(new ItemComparatorByAge());
    }

    @Override
    public Iterator<E> iterator()
    {
        return new GroupIterator(group);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Дерево состоит из ");
        sb.append(group.size());
        sb.append(" объектов\n");
        for (E groupItem : group) {
            sb.append(groupItem);
            sb.append("\n");
        }
        return sb.toString();

        }
    }
