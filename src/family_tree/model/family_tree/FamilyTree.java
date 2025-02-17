package family_tree.model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(ArrayList<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);
            return true;
        }
        return false;
    }

    public void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    public void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<E> searchByFullName(String surname, String name, String middleName){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getSurname().equals(surname) && human.getName().equals(name) && human.getMiddleName().equals(middleName)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean setRelationship(long childId, long parentId) {
        if (checkId(childId) && checkId(parentId)) {
            E child = getById(childId);
            E parent = getById(parentId);
            if (child.getParents().size() < 2) {
                child.addParent(parent);
                parent.addChild(child);
                return true;
            }
        }
        return false;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(E human1, E human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    public boolean setDivorce(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(E human1, E human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;
    }

    public boolean remove(long humansId){
        if (checkId(humansId)){
            E human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public E getById(long id){
        for (E human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном древе " + humanList.size() + " объектов:\n");
        for (E human : humanList) {
            sb.append("---------------------------------------------\n");
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }

    public void sortByName() {
        humanList.sort(new ComparatorByName<>());
    }

    public void sortByAge() {
        humanList.sort(new ComporatorByAge<>());
    }
}
