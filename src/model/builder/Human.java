package model.builder;

import model.family_tree.TreeNode;
import model.service.ServiceFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human>, Serializable {
    private static final long serialVersionUID = 1L;
    private static long idCounter = 1;
    private long id;
    private String name;
    private Gender gender;
    private final LocalDate birthDate;
    private final LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;
    private final ServiceFormat serviceFormat;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.id = generateId();
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
        serviceFormat = new ServiceFormat();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name, gender, birthDate, deathDate, null, null);
    }

    private static synchronized long generateId() {
        return idCounter++;
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public void addParent(Human parent) {
        if (parent.getGender().equals(Gender.MALE)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.FEMALE)) {
            setMother(parent);
        }
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(Human parent) {
        if (parent.gender.equals(Gender.FEMALE)) {
            setMother(parent);
        } else if (parent.gender.equals(Gender.MALE)) {
            setFather(parent);
        }
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public LocalDate getBirthDate() {
        return birthDate;
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

    public boolean isChildOf(Human person) {
        return !getParents().contains(person);
    }

    public boolean isParentOf(Human person) {
        return !getChildren().contains(person);
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        return Period.between(birthDate, deathDate).getYears();
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

    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public void setId(long id) { this.id = id; }

    public long getId() {
        return id;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(", имя: ").append(name);
        if(getDeathDate() != null){
            sb.append(", ");
            sb.append(serviceFormat.getDatePointFormat(getBirthDate()));
            sb.append("-");
            sb.append(serviceFormat.getDatePointFormat(getDeathDate()));
            sb.append(" (");
            sb.append(getAge()).append(" ");
            sb.append(serviceFormat.getYearDeclension(getAge()));
            sb.append(")");
        } else {
            sb.append(", возраст: ").append(getAge()).append(" ");
            sb.append(serviceFormat.getYearDeclension(getAge()));
        }
        sb.append(", пол: ").append(getGender());
        sb.append(", ").append(getSpouseInfo());
        sb.append(", ").append(getMotherInfo());
        sb.append(", ").append(getFatherInfo());
        sb.append(", ").append(getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo() {
        return spouse == null ? "супруг(а): нет" : "супруг(а): " + spouse.getName();
    }

    public String getMotherInfo() {
        return mother == null ? "Мать: неизвестна" : "Мать: " + mother.getName();
    }

    public String getFatherInfo() {
        return father == null ? "Отец: неизвестен" : "Отец: " + father.getName();
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ").append(children.get(i).getName());
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
}
