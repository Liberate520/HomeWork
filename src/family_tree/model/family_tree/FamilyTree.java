package family_tree.model.family_tree;


import family_tree.model.family_tree.comparators.ComparatorByBirthDate;
import family_tree.model.family_tree.comparators.ComparatorByFirstName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends ItemFamilyTree<T>> implements Serializable, Iterable<T> {
    private List<T> list;

    public FamilyTree(List<T> people){
        this.list = people;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void add(T human){
        list.add(human);
    }

    private void addToParents(T human) {
        for (T parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(T human) {
        for (T child: human.getChildren()){
            child.addChild(human);
        }
    }

    public List<T> getSiblings(int id){
        T human = getById(id);
        if (human == null){
            return null;
        }
        List<T> res = new ArrayList<>();
        for (T parent: human.getParents()){
            for (T child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }


    public List<T> getByName(String name){
        List<T> res = new ArrayList<>();
        for (T human: list){
            if (human.getFirstName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }


    public T getById(long id){
        for (T human: list){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(list.size());
        sb.append(" объектов; \n");
        for (T human: list){
            sb.append(human);
            sb.append("\n");
        }
        return  sb.toString();
    }


    public void comparatorByBirthDate(){
        list.sort(new ComparatorByBirthDate<>());
    }

    public void comparatorByName(){
        list.sort(new ComparatorByFirstName<>());
    }


    @Override
    public Iterator<T> iterator() {
        return new familyTreeIterator<>(list);
    }
}
