package model.family.human;

import java.time.LocalDate;

public class HumanBuilder {
    private int id;
    public HumanBuilder(){;
        id = 0;
    }

    public Human create(String name, LocalDate birthDate, Gender gender){
        return new Human(id++, name, birthDate, gender);
    }

    public  Human create(String name, LocalDate birthDate, Gender gender, Human mother, Human father){
        return new Human(id++, name, birthDate, gender, mother, father);
    }
}