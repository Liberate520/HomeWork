package Model.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanId implements Serializable {
    private int genId = 1;
    private String name;
    private Gender sex;
    private LocalDate brthDate;

    public Human build() {
        Human human = new Human(name, sex, brthDate, null, null, null);
        human.setId(genId++);
        return human;
    }


    public HumanId() {
        this.genId = genId;

    }
}
