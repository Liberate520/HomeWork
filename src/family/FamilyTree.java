package family;

import human.Human;
import human.HumanComparatorByAge;
import human.HumanComparatorByName;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humansId;
    private List<Human> people;

    public FamilyTree() {
//        this(new ArrayList<>());
        people = new ArrayList<>();
    }

    public List<Human> getPeople() {
        return people;
    }

    public void setFamilyTree(List<Human> people){
        this.people = people;
    }


    public int size(){
        return people.size();
    }

    public void addHuman(Human human){
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
    
    private void addToParents(Human human){
        for (Human parent : human.getParents()) {
            parent.setChildren(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public Set<Human> getSiblings(long id){
        Human human = getById(id);
        if (human == null){
            return null;
        }
        Set<Human> res = new HashSet<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public Human getById(long id){
        for (Human person : people) {
            if (person.getId() == id){
                return person;
            }
        }
        return null;
    }

    public Human getByName(String name){
        for (Human person : people) {
            if (person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }

    public boolean setWedding(long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)){
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2){
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
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2){
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
            Human human = getById(humansId);
            return people.remove(human);
        }
        return false;
    }
    private boolean checkId(long id){
        return id < humansId && id >= 0;
    }

    public void sortByName(){
        people.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        people.sort(new HumanComparatorByAge());
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(people.size());
        stringBuilder.append(" объектов: \n");
        stringBuilder.append("Список людей: \n");
        for (Human person : people) {
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
    public Iterator<Human> iterator() {
        return people.iterator();
    }
}