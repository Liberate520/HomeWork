package family_tree.human.builder;

import family_tree.human.Human;
import family_tree.human.enum_for_human.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    private long genId;

    public Human build(String firstName, String patronymic, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        return new Human(genId++, firstName, patronymic, lastName, gender, birthDate, deathDate, father, mother);
    }

    public Human build(String firstName, String patronymic, String lastName,
                       Gender gender, LocalDate birthDate) {
        return new Human(genId++, firstName, patronymic, lastName, gender, birthDate);
    }
}


