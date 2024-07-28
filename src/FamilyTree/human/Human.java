package FamilyTree.human;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private String occupation;
    private String nationality;
    private String placeOfBirth;

    private Human father;
    private Human mother;
    private transient List<Human> children;
    private Human spouse;

    public Human(String name,
                 LocalDate birthDate,
                 LocalDate deathDate,
                 Gender gender,
                 String occupation,
                 String nationality,
                 String placeOfBirth,
                 Human father,
                 Human mother) {

        id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.occupation = occupation;
        this.nationality = nationality;
        this.placeOfBirth = placeOfBirth;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender, null, null, null, null, null);
    }

    public Human(String name, LocalDate birthDate, Gender gender, Human father, Human mother) {
        this(name, birthDate, null, gender, null, null, null, father, mother);
    }

    private static final long serialVersionUID = 1L;

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(children);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        children = (List<Human>) ois.readObject();
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
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

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
        if (father != null && !father.getChildren().contains(child)) {
            father.addChild(child);
        }
        if (mother != null && !mother.getChildren().contains(child)) {
            mother.addChild(child);
        }
    }

    public void setParent(Human parent) {
        if (parent.gender.equals(Gender.Female)) {
            setMother(parent);
        } else if (parent.gender.equals(Gender.Male)) {
            setFather(parent);
        }
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(id);
        info.append(" имя: ");
        info.append(getName());
        info.append(", пол: ");
        info.append(gender == Gender.Male ? "Мужчина" : "Женщина");
        info.append(", возраст: ");
        info.append(getYearsString(getAge()));
        info.append(", ");
        info.append(getSpouseInfo());
        info.append(", ");
        info.append(getFatherInfo());
        info.append(", ");
        info.append(getMotherInfo());
        info.append(", ");
        info.append(getChildrenInfo());
//        info.append(", профессия: ");
//        info.append(occupation != null ? occupation : "Не указана");
//        info.append(", национальность: ");
//        info.append(nationality != null ? nationality : "Не указана");
//        info.append(", место рождения: ");
//        info.append(placeOfBirth != null ? placeOfBirth : "Не указано");
        return info.toString();
    }

    public String getYearsString(int years) {
        if (years == 0) {
            LocalDate birthDate = getBirthDate();
            LocalDate now = LocalDate.now();
            Period period = Period.between(birthDate, now);
            if (period.getMonths() == 0) {
                return "Младенец, " + period.getDays() + " дней";
            } else {
                int months = period.getMonths();
                int lastDigit = months % 10;
                int lastTwoDigits = months % 100;

                if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
                    return months + " месяцев";
                }

                switch (lastDigit) {
                    case 1:
                        return months + " месяц";
                    case 2:
                    case 3:
                    case 4:
                        return months + " месяца";
                    default:
                        return months + " месяцев";
                }
            }
        } else {
            int lastDigit = years % 10;
            int lastTwoDigits = years % 100;

            if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
                return years + " лет";
            }

            switch (lastDigit) {
                case 1:
                    return years + " год";
                case 2:
                case 3:
                case 4:
                    return years + " года";
                default:
                    return years + " лет";
            }
        }
    }
    public String getSpouseInfo() {
        String res = "";
        if (spouse != null) {
            res = spouse.getGender() == Gender.Male ? "супруг: " : "супруга: ";
            res += spouse.getName();
        } else {
            res = "супруг/супруга: отсутствует";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getChildrenInfo() {
        String res = "";
        if (children.isEmpty()) {
            res = "Дети " + getName() + ": отсутствуют";
        } else {
            res = "Дети " + getName() + ": ";
            for (Human child : children) {
                res += child.getName();
                if (!child.getChildren().isEmpty()) {
                    res += " (дети: ";
                    for (Human grandchild : child.getChildren()) {
                        res += grandchild.getName() + ", ";
                    }
                    res = res.substring(0, res.length() - 2) + ")"; // удалить запятую в конце и пробел
                }
                res += ", ";
            }
            res = res.substring(0, res.length() - 2); // удалить запятую в конце и пробел
        }
        return res;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Human)) {
//            return false;
//        }
//        Human human = (Human) obj;
//        return human.getId() == getId();
//    }
}