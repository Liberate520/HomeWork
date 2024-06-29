package family_tree.human;

import java.time.LocalDate;

public class HumanBuilder {
    private int genId=1;

    public HumanBuilder() {
    }

    public Human build(String name, LocalDate birghDate, LocalDate deathDate, Gender gender){
        return new Human(name,birghDate,deathDate,gender,genId++);
    }
    public Human build(String name, LocalDate birghDate, Gender gender) {  //перегрузка конструктора
        return new Human(name, birghDate, gender, genId++);
    }
}
