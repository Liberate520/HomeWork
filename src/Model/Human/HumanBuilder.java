package src.Model.Human;


import java.time.LocalDate;

public class HumanBuilder {
    private long ID;

    public Human build(String name,LocalDate dateofbirth,LocalDate dateofdeath,Gender gender,Human mother,Human father){
        return new Human (ID++, name,  dateofbirth, dateofdeath, gender, mother, father);
    }

    public Human build(String name,LocalDate dateofbirth,Gender gender){
        return new Human (ID++, name, dateofbirth, gender);
    }
}
