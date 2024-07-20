package family;

import human.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FamilyTree {
    List<Human> people;

    public FamilyTree() {
        people = new ArrayList<>();
    }

    public int size(){
        return people.size();
    }

    public void addHuman(Human human){
        people.add(human);
    }

    public Human getByName(String name){
        for (Human person : people) {
            if (person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
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
}