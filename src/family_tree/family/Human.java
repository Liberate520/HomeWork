package family_tree.family;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Human implements Serializable {
    private String first_name;
    private String last_name;
    private String patronymic;
    private LocalDate birthday, dayofdeath;
    private Human father, mother;
    private ArrayList<Human> children;
    private Gender gender;

    public Human(String first_name, String last_name, String patronymic, LocalDate birthday, Human father, Human mother, Gender gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<Human>();
        this.gender = gender;
    }

    public Human(String first_name, String last_name, String patronymic, LocalDate dayofdeath, LocalDate birthday, Human father, Human mother, ArrayList<Human> children, Gender gender) {
        this(first_name, last_name, patronymic, birthday, father, mother, gender);
        this.dayofdeath = dayofdeath;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDayofdeath() {
        return dayofdeath;
    }

    public void setDayofdeath(LocalDate dayofdeath) {
        this.dayofdeath = dayofdeath;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Human{");
        sb.append("first_name='").append(first_name).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", patronymic='").append(patronymic).append('\'');
        sb.append(", birthday=").append(birthday);
        if (dayofdeath != null) {
            sb.append(", dayofdeath=").append(dayofdeath);
        }
        if (father != null) {
            sb.append(", father=").append(father.getFirst_name()).append(' ').append(father.getLast_name());
        }
        if (mother != null) {
            sb.append(", mother=").append(mother.getFirst_name()).append(' ').append(mother.getLast_name());
        }
        sb.append(", children=[");
        for (Human child : children) {
            sb.append(child.getFirst_name()).append(' ').append(child.getLast_name()).append(", ");
        }
        if (!children.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove the trailing comma and space
        }
        sb.append("]");
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, patronymic, birthday, dayofdeath, father, mother, children, gender);
    }

    public String getFullName() {
        return String.format("%s %s %s", first_name, patronymic, last_name);
    }
}
