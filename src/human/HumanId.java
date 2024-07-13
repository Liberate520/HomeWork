package human;

import family_tree.Item;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanId implements  Serializable{
    private int genId=1;
    public Human build(String name,Gender sex, LocalDate brthDate) {
        Human human = new Human (name,sex,brthDate,null,null,null);
        human.setId(genId++);
        return human;
    }
}
