package src.Model.Human;

import java.time.LocalDate;
import java.util.List;

public interface EntityBulder {

    public Human build(String name, LocalDate dateofbirth, LocalDate dateofdeath, Gender gender, Human mother,
            Human father, List<Human> children);

    public Human build(String name, LocalDate dateofbirth, Gender gender);
}
