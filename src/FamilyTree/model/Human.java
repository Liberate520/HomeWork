package FamilyTree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements ItemFamilyTree<Human>, Serializable {
    private long humanId;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private String occupation;
    private String nationality;
    private String placeOfBirth;

    private Human father;
    private Human mother;
    private List<Human> children;

    private List<Human> grandchildren = new ArrayList<>();
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

        humanId = -1;
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

//    private static final long serialVersionUID = 1L;

//    private void writeObject(ObjectOutputStream oos) throws IOException {
//        oos.defaultWriteObject();
//        oos.writeObject(children);
//    }
//
//    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
//        ois.defaultReadObject();
//        children = (List<Human>) ois.readObject();
//    }

    // Getters

    public long getId() {
        return humanId;
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
        return this.gender;
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

    public Human getSpouse() {
        return spouse;
    }

    public List<Human> getGrandchildren() {
        List<Human> grandchildren = new ArrayList<>();
        for (Human child : children) {
            grandchildren.addAll(child.getChildren());
        }
        return grandchildren;
    }

    @Override
    public void addChild(Human child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public void addGrandchild(Human grandchild) {
        if (grandchildren == null) {
            grandchildren = new ArrayList<>();
        }
        grandchildren.add(grandchild);
    }

    @Override
    public int getAge() {
        if (deathDate == null) {
            return calculateAge(birthDate, LocalDate.now());
        } else {
            return calculateAge(birthDate, deathDate);
        }
    }

    private int calculateAge(LocalDate birthDate, LocalDate endDate) {
        return Period.between(birthDate, endDate).getYears();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("id: ").append(humanId)
                .append(", имя: ").append(name)
                .append(", пол: ").append(gender == Gender.Male ? "Мужчина" : "Женщина")
                .append(", возраст: ").append(getAge()).append(" лет");
        if (spouse != null) {
            info.append(spouse.getGender() == Gender.Male ? ", супруг: " : ", супруга: ").append(spouse.getName());
        } else {
            info.append(", супруг(а): отсутствует");
        }

        info.append(", отец: ").append(father != null ? father.getName() : "неизвестен")
                .append(", мать: ").append(mother != null ? mother.getName() : "неизвестна");

        if (children != null && !children.isEmpty()) {
            info.append(", дети: ");
            for (Human child : children) {
                info.append(child.getName()).append(" ");
            }
        } else {
            info.append(", дети: отсутствуют");
        }

        return info.toString();
    }


//    public String getInfo() {
//        StringBuilder info = new StringBuilder();
//        info.append("id: ");
//        info.append(humanId);
//        info.append(" имя: ");
//        info.append(getName());
//        info.append(", пол: ");
//        info.append(gender == Gender.Male ? "Мужчина" : "Женщина");
//        info.append(", возраст: ");
//        info.append(getYearsString(getAge()));
//        info.append(", ");
//        info.append(getSpouseInfo());
//        info.append(", ");
//        info.append(getFatherInfo());
//        info.append(", ");
//        info.append(getMotherInfo());
//
//        info.append(", ");
//        info.append(getChildrenInfo());
//
////        info.append(", профессия: ");
////        info.append(occupation != null ? occupation : "Не указана");
////        info.append(", национальность: ");
////        info.append(nationality != null ? nationality : "Не указана");
////        info.append(", место рождения: ");
////        info.append(placeOfBirth != null ? placeOfBirth : "Не указано");
//        return info.toString();
//    }

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
        StringBuilder res = new StringBuilder();
        if (children.isEmpty()) {
            res = new StringBuilder("Дети " + getName() + ": отсутствуют");
        } else {
            res = new StringBuilder("Дети " + getName() + ": ");
            for (Human child : children) {
                res.append(child.getName());
                if (!child.getChildren().isEmpty()) {
                    res.append(" (дети: ");
                    for (Human grandchild : ((Human) child).getChildren()) {
                        res.append(grandchild.getName()).append(", ");
                    }
                    res = new StringBuilder(res.substring(0, res.length() - 2) + ")"); // удалить запятую в конце и пробел
                }
                res.append(", ");
            }
            res = new StringBuilder(res.substring(0, res.length() - 2)); // удалить запятую в конце и пробел
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human other = (Human) obj;
        return this.humanId == other.humanId;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(humanId);
    }

    // Setters

    public void setId(long Id) {
        this.humanId = Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

}