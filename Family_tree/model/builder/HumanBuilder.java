package Family_tree.model.builder;

import java.time.LocalDate;

import Family_tree.model.human.Gender;
import Family_tree.model.human.Human;

public class HumanBuilder {
    private int maxId;
    
    public Human build(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human spouse, Human father, Human mother){
        Human human = new Human(maxId++, name, gender, dateOfBirth, dateOfDeath, spouse, father, mother);
        return human;
    }

    public Human build(String name, Gender gender, LocalDate dateOfBirth){
        Human human = new Human(maxId++,name,gender,dateOfBirth);
        return human;
    }

}

