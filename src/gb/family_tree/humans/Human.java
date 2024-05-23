package gb.family_tree.humans;

import java.time.LocalDate;
import java.time.Period;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate date_of_birth;
    private LocalDate date_of_death;


    public Human(String name, Gender gender, LocalDate date_of_birth,
                 LocalDate date_of_death) {
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.date_of_death = date_of_death;
    }

    public Human(String name, Gender gender, LocalDate date_of_birth) {
        this(name, gender, date_of_birth, null);
    }

    public int getAge() {
        if (date_of_death == null) {
            return getPeriod(date_of_birth, LocalDate.now());
        }
        else {
            return getPeriod(date_of_birth, date_of_death);
        }
    }

    private int getPeriod(LocalDate date_of_birth, LocalDate date_of_death) {
        Period diff = Period.between(date_of_birth, date_of_death);
        return diff.getYears();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public LocalDate getDate_of_death() {
        return date_of_death;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setDate_of_death(LocalDate date_of_death) {
        this.date_of_death = date_of_death;
    }

    public Gender getGender() {
        return gender;
    }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", Пол: ");
        sb.append(gender);
        sb.append(", Возраст: ");
        sb.append(getAge());
        return sb.toString();
    }

}
