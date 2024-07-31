package Seminars.Seminars_1.HomeWork.homeWork;

import java.util.ArrayList;
import java.util.List;

public class Family_tree {
    private List<Human> people;

    public Family_tree() {people = new ArrayList<>();}
    public void addHuman(Human human) {people.add(human);}

    public Human getByName(String name) {
        for (Human human : people) {
            if (human.getHuman().equals(name))
                return human;
        }return null;}

    public List<Human> getPeople() {return people;}

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nСписок всех членов семьи:\n\n");
        for (Human human : people){
            stringBuilder.append(human);
            stringBuilder.append("\n\n");
        }return stringBuilder.toString();}
}

