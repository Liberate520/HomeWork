package builder;

import java.time.LocalDate;

import human.Gender;
import human.Human;

public class HumanBuilder {
    private int genId;

    public Human build(String name, Gender gender, LocalDate dateOfBirth){
        return new Human(genId++, name, gender, dateOfBirth);
    }

}
