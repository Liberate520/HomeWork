package familyTree.model.human;

import familyTree.model.familyTree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Human implements Serializable, FamilyTreeItem<Human> {


    private long id;
    private String lastName;
    private String firstname;
    private String patronymic;
    private Gender gender;
    private LocalDate dayBirth;
    private LocalDate dayDeath;
    private Human father;
    private Human mother;
    private List<Human> children;
    private String placeBorn;

    {
        lastName = null;
        firstname = null;
        patronymic = null;
        gender = null;
        dayBirth = null;
        dayDeath = null;
        placeBorn = null;
        children = null;

    }

    public void setID(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDayBirth(LocalDate dayBirth) {
        this.dayBirth = dayBirth;
    }

    public void setDayDeath(LocalDate dayDeath) {
        this.dayDeath = dayDeath;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setPlaceBorn(String placeBorn) {
        this.placeBorn = placeBorn;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDayBirth() {
        return dayBirth;
    }

    public LocalDate getDayDeath() {
        return dayDeath;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getPlaceBorn() {
        return placeBorn;
    }

    public long getID() {
        return id;
    }


    public Human() {

    }

    public Human(String lastName, String firstname, String patronymic,
                 Gender gender, LocalDate dayBirth, LocalDate dayDeath,
                 Human father, Human mother, List<Human> children, String placeBorn) {

        this.lastName = lastName;
        this.firstname = firstname;
        this.patronymic = patronymic;
        this.gender = gender;

        try {
            this.dayBirth = dayBirth;
        } catch (Exception ex) {
            this.dayBirth = null;
        }

        try {
            this.dayDeath = dayDeath;
        } catch (Exception ex) {
            this.dayDeath = null;
        }

        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        this.placeBorn = placeBorn;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getID() + ". ");
        if (lastName != null && lastName !="") {
            stringBuilder.append("Фамилия: " + lastName + "; ");
        } else {
            stringBuilder.append("Фамилия: неизвестна; ");
        }
        if (firstname != null) {
            stringBuilder.append("Имя: " + firstname + "; ");
        } else {
            stringBuilder.append("Имя: неизвестно; ");
        }
        if (patronymic != null && patronymic !="") {
            stringBuilder.append("Отчество: " + patronymic + "; ");
        } else {
            stringBuilder.append("Отчество: неизвестно; ");
        }
        if (gender != null) {
            stringBuilder.append("Пол: " + gender + "; ");
        } else {
            stringBuilder.append("Пол: не указан; ");
        }
        if (dayBirth != null) {
            stringBuilder.append("Возраст(лет):" + getAge() + "; ");
        } else {
            stringBuilder.append("Возраст: не известен;");
        }
        if (father != null) {
            stringBuilder.append("Отец: " + getFIO(father) + "; ");
        } else {
            stringBuilder.append("Отец: не указан; ");
        }
        if (mother != null) {
            stringBuilder.append("Мать: " + getFIO(mother) + "; ");
        } else {
            stringBuilder.append("Мать: не указана; ");
        }
        if (getChildren() != null && children.size() != 0) {
            stringBuilder.append("Дети: " + getChildren(children) + "; ");
        } else {
            stringBuilder.append("Дети: не указаны; ");
        }
        if (placeBorn != null && placeBorn !="") {
            stringBuilder.append("Место рождения: " + placeBorn + "; ");
        } else {
            stringBuilder.append("Место рождения: не указано;");
        }

        return stringBuilder.toString();
    }

    public int getAge() {
        if (dayBirth == null) {
            return 0;
        }
        else if (dayDeath != null) {
            return (int) dayBirth.until(dayDeath, ChronoUnit.YEARS);
        } else {
            return (int) dayBirth.until(LocalDate.now(), ChronoUnit.YEARS);
        }

    }

    public void addChild(Human child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public void addParent(Human human) {
        if (human.getGender().equals(Gender.Male)) {
            setFather(human);
        }
        if (human.getGender().equals(Gender.Female)) {
            setMother(human);
        }
    }

    public String getFIO(Human human) {
        String fio = "";
        if (human.getLastName() != null) {
            fio += human.getLastName();
        }
        if (!fio.equals("") && human.getFirstname() != null && human.getPatronymic() != null) {
            fio += " " + human.getFirstname().charAt(0) + "." + human.getPatronymic().charAt(0) + ".";
        } else if (human.getFirstname() != null && human.getPatronymic() != null) {
            fio += human.getFirstname() + " " + human.getPatronymic();
        } else if (human.getPatronymic() != null) {
            fio += human.getPatronymic();
        }
        return fio;
    }

    public String getChildren(List<Human> children) {
        String res = "";
        for (Human child : children) {
            res += getFIO(child) + ",";
        }
        return res.substring(0, res.length() - 1);
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        return parents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(lastName, human.lastName) && Objects.equals(firstname, human.firstname) && Objects.equals(patronymic, human.patronymic) && gender == human.gender && Objects.equals(dayBirth, human.dayBirth) && Objects.equals(dayDeath, human.dayDeath) && Objects.equals(placeBorn, human.placeBorn);
    }

    public int compareTo(Human o) {
        return firstname.compareTo(o.firstname);
    }

}





