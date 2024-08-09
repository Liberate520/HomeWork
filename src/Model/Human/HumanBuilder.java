package src.Model.Human;


import java.time.LocalDate;
import java.util.List;

public class HumanBuilder {
    private long ID;

    public Human build(String name,LocalDate dateofbirth,LocalDate dateofdeath,Gender gender,Human mother,Human father, List<Human> children){
        return new Human (ID++, name,  dateofbirth, dateofdeath, gender, mother, father, children);
    }

    public Human build(String name,LocalDate dateofbirth,Gender gender){
        return new Human (ID++, name, dateofbirth, gender);
    }
}
