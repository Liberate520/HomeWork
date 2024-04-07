package src.human;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, Serializable {
    //  Поля:
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    //  Constructor:
    public Human(int id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.id = id;
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

    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        this(id, name, gender, birthDate, null, null, null);
    }

    //  Method:
    //  Setters:
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            child.addParent(this);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            parent.addChild(this);
            return true;
        }
        return false;
    }

    //  Getters:
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
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

    public List<Human> getParents() {
        return parents;
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }

    //  Overrides:
    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        int len = 8;
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        for (int i = sb.length(); i < len; i++) sb.append(" ");
        sb.append("| имя: ");
        sb.append(name);
        len += 15;
        for (int i = sb.length(); i < len; i++) sb.append(" ");
        sb.append("| пол: ");
        sb.append(getGender());
        len += 15;
        for (int i = sb.length(); i < len; i++) sb.append(" ");
        sb.append("| возраст: ");
        sb.append(getAge());
        len += 15;
        for (int i = sb.length(); i < len; i++) sb.append(" ");
        sb.append(getSpouseInfo());
        len += 21;
        for (int i = sb.length(); i < len; i++) sb.append(" ");
        sb.append(getMotherInfo());
        len += 20;
        for (int i = sb.length(); i < len; i++) sb.append(" ");
        sb.append(getFatherInfo());
        len += 20;
        for (int i = sb.length(); i < len; i++) sb.append(" ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getSpouseInfo() {
        String res = "| супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    private String getMotherInfo() {
        String res = "| мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    private String getFatherInfo() {
        String res = "| отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("| дети: ");
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
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {
        return this.getName().compareTo(o.getName());
    }


}