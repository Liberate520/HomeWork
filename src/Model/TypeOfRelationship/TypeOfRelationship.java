package Model.TypeOfRelationship;
import Model.Рerson.Рerson;

import java.io.Serializable;
import java.util.*;

public class TypeOfRelationship<E extends Рerson> implements Serializable, Iterable<E> {
    private List<E> family;
    public TypeOfRelationship(ArrayList<E> family) {
        this.family = family;
    }
    public TypeOfRelationship() {
        this(new ArrayList<>());
    }
    public List<E> getРersonList() {
        return family;
    }
    public void addРerson(E person){
        if(!family.contains(person)){
            family.add(person);
        }
        if (person.getFather() != null){
            person.getFather().addChild(person);
        }
        if (person.getMother() != null){
            person.getMother().addChild(person);
        }
    }
    public void removeРerson(E person) {
        if (person.getMother() != null){
            person.getMother().getChildren().remove(person);
        }
        if (person.getFather() != null) {
            person.getFather().getChildren().remove(person);
        }
        family.remove(person);
    }
    public E getByName(String firstName, String lastName){
        for (E person: family) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)){
                return person;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (E person: family){
            sb.append(person.toString()).append("\n");
        }
        return "В родословной: " + family.size() + " человека: " + "\n" + sb.toString();
    }
    @Override
    public Iterator<E> iterator() {
        return new РersonIterator<>(family);
    }

    public void sortByName(){
        family.sort(new ComparatorByName());
    }

    public void sortByBirthday(){
        family.sort(new ComparatorByBirthday());
    }
}