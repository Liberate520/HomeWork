package Model.Organisms.Mammals.Persons;


import Model.Organisms.Mammals.Mammals;
import Model.Organisms.Mammals.Persons.Enums.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Класс человека
 */
public class Person extends Mammals<Person> implements Serializable, Iterator<String>{
    // для итератора
    int index;

    //конструкторы
    public Person(String name, Gender gender, String birthDate, String deathDate)  {
        this.name = name;
        this.gender = gender;
        this.birthday = LocalDate.parse(birthDate);
        this.deathDate = LocalDate.parse(deathDate);
        this.children = new ArrayList<Person>();
    }
    public Person(String name, Gender gender, String birthDate)  {
        this(name, gender, birthDate, "9999-01-01");
    }
    public Person(String name, Gender gender) {
        this(name, gender,"9999-01-01","9999-01-01");
    }


    //методы
    @Override
    public String toString() {
        String out = "\n\nname: " + name +
                "\ngender: " + gender;
        if (this.birthday.getYear() != 9999)
            out += "\ndate of birth: " + birthday;
        if (this.deathDate.getYear() != 9999)
            out += "\ndate of death: " + deathDate;
        out += getCloseRelations();
        return out;
    }

    /**
     * @return Взозвращает отформатированую строку с перечислением: Отца, Матери и детей с датами.
     */
    private String getCloseRelations() {
        String out = "";
        if(this.father != null) {
            out = "\nFather: \nname: " + father.getName() +
                    "\ngender: " + father.getGender() +
                    "\ndate of birthday: " + father.getBirthday();
            if (father.getDeathDate().getYear() != 9999)
                out += "\ndate of death: " + father.getDeathDate();
        }
        if (mother != null) {
            out += "\nMother: \nname: " + mother.getName() +
                    "\ngender: " + mother.getGender() +
                    "\nbirthday: " + mother.getBirthday();
            if (mother.getDeathDate().getYear() != 9999)
                out += "\ndate of date of death: " + mother.getDeathDate();
        }
        for (Person child : children) {
            out += "\nChild: \nname: " + child.name +
                "\ngender: " + child.gender +
                "\nbirthday: " + child.birthday;
            if (child.deathDate.getYear() != 9999)
                out += "\ndate of death: " + child.deathDate;
        }
        return out;
    }

    @Override
    public boolean hasNext() {
        return index++ < 7;
    }
    @Override
    public String next() {
        switch (index) {
            case 0:
                return getName();
            case 1:
                if(getBirthday().getYear() != 9999)
                    return getBirthday().toString();
                return "";
            case 2:
                if(getBirthday().getYear() != 9999)
                    return getDeathDate().toString();
                return "";
            case 3:
                return getChildren();
            case 4:
                return getFather();
            case 5:
                return getMother();
            default:
                return String.valueOf(gender);
        }
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
