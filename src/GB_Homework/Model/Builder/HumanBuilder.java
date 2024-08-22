package GB_Homework.Model.Builder;

import GB_Homework.Model.Human.Gender;
import GB_Homework.Model.Human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    private long getId;

    public Human build (String name, Gender gender, LocalDate birthDate) {
        return new Human(getId++, name, gender, birthDate);
    }
}
