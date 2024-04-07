package FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birtDay;
    private LocalDate mortDay;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human husband;
    private int inn;

    private Human(String firstName, String lastName, Gender gender, LocalDate birtDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birtDay = birtDay;
        this.children = new ArrayList<>();
    }

    public static Human create(String firstName, String lastName, Gender gender, LocalDate birtDay) {
        if (!birtDay.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("некорректная дата рождения");
        }
        return new Human(firstName, lastName, gender, birtDay);
    }

    /**
     * установить родителя. Родителя можно установить только 1 раз. переназначить нельзя.
     *
     * @param parent - родитель
     * @return - успешность операции
     */
    public boolean setParent(Human parent) {
        if (parent.gender.equals(Gender.MAN) && this.father == null) {
            this.father = parent;
            return true;
        }
        if (parent.gender.equals(Gender.WOMAN) && this.mother == null) {
            this.mother = parent;
            return true;
        }
        return false;
    }

    public void setHusband(Human human) {
        this.husband = human;
    }

    /**
     * добавление ребенка. если ребенок добавлен и у ребенка не установлен родитель - он прописывается у ребенка
     *
     * @param child
     */
    public void addChildren(Human child) {
        if (!children.contains(child)) {
            if ((this.gender == Gender.MAN && (child.father == this || child.father == null)) ||
                    (this.gender == Gender.WOMAN && (child.mother == this || child.mother == null))) {
                child.setParent(this);
                children.add(child);
            }
        }
    }

    /**
     * устанавливает дату смерти. установить можно только 1 раз
     *
     * @param mort - дата смерти
     * @return успешность операции.
     */
    public boolean setMortDay(LocalDate mort) {
        if (this.mortDay != null) {
            return false;
        }
        if (mort.isBefore(birtDay)) {
            return false;
        }
        this.mortDay = mort;
        return true;
    }

    public void setInn(int inn) {
        if (this.inn == 0) {
            this.inn = inn;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName) &&
                gender == human.gender &&
                Objects.equals(birtDay, human.birtDay) &&
                Objects.equals(mortDay, human.mortDay) &&
                Objects.equals(mother, human.mother) &&
                Objects.equals(father, human.father) &&
                Objects.equals(children, human.children) &&
                Objects.equals(husband, human.husband);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, birtDay, mortDay, mother, father, children, husband);
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String mort = "";
        if (mortDay != null) {
            mort = mortDay.format(dtf);
        }
        return String.format("inn %d: %s %s (%s - %s), %s",
                inn, firstName, lastName, birtDay.format(dtf), mort, gender.description);
    }

    //region Getter

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirtDay() {
        return birtDay;
    }

    public LocalDate getMortDay() {
        return mortDay;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getHusband() {
        return husband;
    }

    public int getInn() {
        return inn;
    }
    //endregion

}