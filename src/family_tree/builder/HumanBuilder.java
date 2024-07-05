package family_tree.builder;

import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int genID;

    public HumanBuilder() {
        this.genID = 1;  // Инициализация генератора идентификаторов для запуска с 1
    }

    public Human build (String name, LocalDate dob, Gender gender) {
        return new Human(genID++, name, dob, gender);
    }
}
