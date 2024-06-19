package Family_tree.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Family_tree <E extends TreeTop<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanList;


    public Family_tree() {
        this(new ArrayList<>());
    }

    public Family_tree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human) {
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

    private void addToParents(E human) {
        for (E parent: human.getParents()) {
            parent.addChild(human);
        }
    }


    private void addToChildren(E human) {
        for (E child: human.getChildren()) {
            child.addChild(human);
        }
    }

    public List<E> getSibLings(int id) {
        E human = getById(id);
        if (human == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null){
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean setWedding (E human1, E human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorse(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 = getById(humanId1);
            E human2 = getById(humanId2);
            return setDivorse(human1, human2);
        }
        return false;
    }

    private boolean setDivorse(E human1, E human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;

        }
    }

    private boolean checkId(long id) {
        if (id >= humansId || id < 0) {
            return false;
        }
        for (E human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public E getById(long id) {
        for (E human : humanList) {
            if (human.getId() == id) {
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
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append("объектов: \n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortName(){
        humanList.sort(new FamilyTreeComporatorByBirthdate<>());
    }

    public void sortBirthDate(){
        humanList.sort(new FamilyTreeComporatorByName<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }
}




