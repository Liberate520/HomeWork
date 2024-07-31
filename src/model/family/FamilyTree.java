package model.family;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends GroupItem<T>> implements Serializable, Iterable<T> {
    private long humansId;
    private List<T> people;

    public FamilyTree() {
//        this(new ArrayList<>());
        people = new ArrayList<>();
    }

    public List<T> getPeople() {
        return people;
    }

    public void setFamilyTree(List<T> people){
        this.people = people;
    }


    public int size(){
        return people.size();
    }

    public void addHuman(T human){
        if (human == null) {
            return;
        }
        if (!people.contains(human)) {
            people.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);
        }
    }
    
    private void addToParents(T human){
        for (T parent : human.getParents()) {
            parent.setChildren(human);
        }
    }

    private void addToChildren(T human){
        for (T child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public Set<T> getSiblings(long id){
        T human = getById(id);
        if (human == null){
            return null;
        }
        Set<T> res = new HashSet<>();
        for (T parent : human.getParents()) {
            for (T child : parent.getChildren()) {
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public T getById(long id){
        for (T person : people) {
            if (person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public T getByName(String name){
        for (T person : people) {
            if (person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public boolean setWedding(long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)){
            T human1 = getById(humansId1);
            T human2 = getById(humansId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(T human1, T human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }


    public boolean setDivorce(int humansId1, int humansId2){
        if (checkId(humansId1) && checkId(humansId2)){
            T human1 = getById(humansId1);
            T human2 = getById(humansId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(T human1, T human2){
        if (human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int humansId){
        if (checkId(humansId)){
            T human = getById(humansId);
            return people.remove(human);
        }
        return false;
    }
    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public void sortByName(){
        people.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        people.sort(new HumanComparatorByAge<>());
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(people.size());
        stringBuilder.append(" объектов: \n");
        stringBuilder.append("Список людей: \n");
        for (T person : people) {
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return  stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyTree that = (FamilyTree) o;
        return Objects.equals(people, that.people);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(people);
    }


    @Override
    public Iterator<T> iterator() {
        return people.iterator();
    }
}