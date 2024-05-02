package model.human;

import model.family_tree.FamilyItem;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyItem<Human> {

    private int id;
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private Human mother;
    private Human father;
    List<Human> children;

    public Human(int id, String name, LocalDate dob, LocalDate dod, Gender gender, Human mother, Human father) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.dod = dod;
        this.children = new ArrayList<>();
    }

    public Human(int id, String name, Gender gender, LocalDate dob) {
        this(id, name, dob, null, gender, null, null);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public LocalDate getDod() {
        return dod;
    }

    private void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public void addParent(Human parent) {

        if (parent.gender.equals(Gender.Male)) {
            setFather(parent);
        }
        else if (parent.gender.equals(Gender.Female)) {
            setMother(parent);
        }

    }

    private void setMother(Human mother) {
            if (this.mother == null) {
                this.mother = mother;
                this.mother.addChild(this);
            }
    }

    private void setFather(Human father) {
        if (this.father == null) {
            this.father = father;
            this.father.addChild(this);
        }
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public boolean isAlive() {
        return this.dod == null;
    }

    public int getAge() {
        if (dod != null) {
            return getPeriod(dob, dod);
        }
        else {
            return getPeriod(dob, LocalDate.now());
        }
    }

    private int getPeriod(LocalDate dob, LocalDate dod) {
        Period diff = Period.between(dob, dod);
        return diff.getYears();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ");
        sb.append(getId());
        sb.append(", Имя: ");
        sb.append(getName());
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());

        return sb.toString();
    }

    private String getMotherInfo() {
        String res = "Мать: ";
        Human mother = getMother();
        if (mother == null) {
            res += "неизвестна";
        }
        else {
            res += mother.getName();
        }
        return res;
    }

    private String getFatherInfo() {
        String res = "Отец: ";
        Human father = getFather();
        if (father == null) {
            res += "неизвестен";
        }
        else {
            res += father.getName();
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (!children.isEmpty()) {
            res.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }
        else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
