
package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private long id;
    private final String name;
    private final Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private final List<Human> parents;
    private final List<Human> children;
    private Human spouse;


    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public void addParents(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public Human getFather() {
        for (Human parent : parents) {
            {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        return getPeriod(birthDate, Objects.requireNonNullElseGet(deathDate, LocalDate::now));
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

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        return "id: " +
                id +
                ", имя: " +
                name +
                ", пол: " +
                getGender() +
                ", возраст: " +
                getAge() +
                ", " +
                getSpouseInfo() +
                ", " +
                getMotherInfo() +
                ", " +
                getFatherInfo() +
                ", " +
                getChildrenInfo();
    }

    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
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

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human human)) {
            return false;
        }
        return human.getId() == getId();
    }

}
