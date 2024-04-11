package family_tree.person;

import java.time.LocalDate;

public class Human extends BasicUnit {

    public Human(String name, LocalDate dob, Gender gender) {
        super(name, dob, null, gender, null, null);
    }

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender) {
        super(name, dob, dod, gender, null, null);
    }

    public Human(String name, LocalDate dob, Gender gender, Human father, Human mother) {
        super(name, dob, null, gender, father, mother);
    }

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender,
                 Human father, Human mother) {
        super(name, dob, dod, gender, father, mother);
    }
}