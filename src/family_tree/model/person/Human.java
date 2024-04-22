package family_tree.model.person;

import java.time.LocalDate;

public class Human extends BasicUnit{

    public Human(String name, LocalDate dateOfBirth, Gender gender) {
        super(name, dateOfBirth, null, gender, null, null);
    }

    public Human(String name, LocalDate dateOfBirth, LocalDate dateOfDead, Gender gender) {
        super(name, dateOfBirth, dateOfDead, gender, null, null);
    }

    public Human(String name, LocalDate dateOfBirth, Gender gender, Human father, Human mother) {
        super(name, dateOfBirth, null, gender, father, mother);
    }

    public Human(String name, LocalDate dateOfBirth, LocalDate dateOfDead, Gender gender,
                 Human father, Human mother) {
        super(name, dateOfBirth, dateOfDead, gender, father, mother);
    }

}
