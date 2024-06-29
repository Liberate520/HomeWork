package ru.gb.family_tree.model.builder;

import java.time.LocalDate;

import ru.gb.family_tree.model.item.Gender;
import ru.gb.family_tree.model.item.Human;

public class HumanBuilder {
    private long maxId;

    public Human build( String name,
                                    Gender gender,
                                    LocalDate birthDate,
                                    LocalDate deathDate,
                                    Human father,
                                    Human mother) {

        return new Human(maxId++, name, gender, birthDate, deathDate, father, mother);
    }

    public Human build( String name,
                                    Gender gender,
                                    LocalDate birthDate,
                                    Human father,
                                    Human mother) {
 
        return new Human(maxId++, name, gender, birthDate, null, father, mother);
    }
    
    public Human build( String name,
                                    Gender gender,
                                    LocalDate birthDate) {

        return new Human(maxId++, name, gender, birthDate, null, null, null);
    }    

}