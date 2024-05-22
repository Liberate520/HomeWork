package ru.gb.family_tree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> parents;
    private List<Human> children;
    private Human marriedPartner;

    public Human(String name, String lastName, Gender gender, LocalDate dateOfBirth,
                 LocalDate dateOfDeath, Human father, Human mather) {
        id = -1;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mather != null) {
            parents.add(mather);
        }
        children = new ArrayList<>();

    }

    public Human(String name, String lastName, Gender gender, LocalDate dateOfBirth) {
        this(name, lastName, gender, dateOfBirth, null, null, null);
    }

    public Human(String name, String lastName, Gender gender, LocalDate dateOfBirth,
                 Human father, Human mather) {
        this(name, lastName, gender, dateOfBirth, null, father, mather);
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public void addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.мужской) {
                return parent;
            }
        }
        return null;
    }

    public Human getMather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.женский) {
                return parent;
            }
        }
        return null;
    }

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());
        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    public String getMarriedPartnerInfo() {
        String res = "супруг(а): ";
        if (marriedPartner == null) {
            res += "нет";
        } else {
            res += marriedPartner.getName();
        }
        return res;
    }

    public String getMatherInfo() {
        String res = "мама: ";
        Human mather = getMather();
        if (mather != null) {
            res += mather.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "папа: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестно";
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

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period diff = Period.between(dateOfBirth, dateOfDeath);
        return diff.getYears();
    }

    public void setMarriedPartner(Human marriedPartner) {
        this.marriedPartner = marriedPartner;
    }

    public Human getMarriedPartner() {
        return marriedPartner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    //    public Human(String иван, String гагарин) {
//    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", фамилия: ");
        sb.append(lastName);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMarriedPartnerInfo());
        sb.append(", ");
        sb.append(getMatherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
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

}


