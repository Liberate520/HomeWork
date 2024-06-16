package FamTree.model.ft;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends LifeFormGroup<T>> implements Serializable, Iterable<T> {
    private long humansId;
    private List<T> humanList;

    public FamilyTree() { this(new ArrayList<>()); }
    public FamilyTree(List<T> humanList) { this.humanList = humanList; }

    public boolean add(T human) {
        if ( human == null ) return false;
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId ++);

            addToParents((T) human);
            addToChildren((T) human);

            return true;
        }
        return false;
    }

    private void addToParents(T human) {
        for (T parentL : human.getParents()) {
            parentL.addChild(human);
        }
    }

    private void addToChildren(T human) {
        for (T childL : human.getChildren()) {
            childL.addParent(human);
        }
    }

    public List<T> getSiblings(long id) {
        T human = (T) getById(id);
        if (human == null) return null;
        List<T> siblings = new ArrayList<>();
        for (T parentL : human.getParents()) {
            for (T child : parentL.getChildren()) {
                if (!child.equals(human)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public List<T> getByName(String name) {
        List<T> result = new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setDivorce(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            T human1 = getById(humanId1);
            T human2 = getById(humanId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null){
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long humanId){
        if (checkId(humanId)){
            T human = getById(humanId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId  &&  id >= 0;
    }

    public T getById(long id) {
        for (T human : humanList) {
            if (human.getId() == id) return human;
        }
        return null;
    }

    @Override
    public String toString() { return getInfo(); }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В Дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (T human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }

    public void sortByName(){
        humanList.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByBirthDate(){
        humanList.sort(new FamilyTreeComparatorByBirthDate<>());
    }


}
