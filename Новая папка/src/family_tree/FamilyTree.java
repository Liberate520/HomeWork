package family_tree;

import human.Human;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends ItemFamilyTree> implements Serializable, Iterable<T> {
    private long humansId;
    private List<T> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public boolean add(T human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    public void addToParents(T human) {
        for (T parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public void addToChildren(T human) {
        for (T children : human.getChildren()) {
            children.addParent(human);
        }
    }

    public List<T> getSibling(int id) {
        T human = getById(id);
        if (human == null) {
            return null;
        }
        List<T> res = new ArrayList<>();
        for (T parent : human.getParents()) {
            for (T child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(T human1, T human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else
            return false;
    }

    public boolean setDivorce(T human1, T human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else
            return false;
    }


private boolean checkId(long id){
    return id < humansId && id >= 0;}


     public T getById(long id){
        for (T human: humanList){
            if( human.getId()==id){
                return human;
            }
        }
        return null;
     }

     @Override
     public String toString() {
         StringBuilder sb = new StringBuilder();
         sb.append("В древе ");
         sb.append(humanList.size());
         sb.append(" объектов: \n");
         for (T human : humanList) {
             sb.append(human);
             sb.append("\n");
         }
         return sb.toString();
     }

    @Override
    public Iterator <T> iterator() {
        return humanList.iterator();
    }

    public void sortByName (){
        Collections.sort(humanList);
    }
    public void sortByAge(){
        Collections.sort(humanList, new HumanComparatorByAge<>());
    }
}
