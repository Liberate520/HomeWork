package family_tree.human;

import family_tree.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human> {
    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;

    public Human(String firstName, String lastName, Gender gender, LocalDate dateOfBirth,
            LocalDate dateOfDeath, Human father, Human mother) {
        id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate dateOfBirth) {
        this(firstName, lastName, gender, dateOfBirth, null, null, null);
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, Human father, Human mother) {
        this(firstName, lastName, gender, dateOfBirth, null, father, mother);
    }

    // добавление ребенка
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;

    }

    // добавление родителей
    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
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

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());
        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period diff = Period.between(dateOfBirth, dateOfDeath);
        return diff.getYears();
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        String name = firstName + " " + lastName;
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return dateOfBirth;
    }

    public LocalDate getDeathDate() {
        return dateOfDeath;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", date of birth: ");
        sb.append(getBirthDate());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo() {
        String res = "spouse: ";
        if (spouse == null) {
            res += "no";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "father: ";
        Human father = getFather();
        if (father == null) {
            res += "no";
        } else {
            res += father.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "mother: ";
        Human mother = getMother();
        if (mother == null) {
            res += "no";
        } else {
            res += mother.getName();
        }
        return res;
    }

    //
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("no");
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

    // вывод родителей ребенка
    public void printParents() {
        System.out.println("Father: " + father.getFirstName() + " " + father.getLastName());
        System.out.println("Mother: " + mother.getFirstName() + " " + mother.getLastName());
    }

    // вывод детей у родителя
    public void printChildren() {
        for (Human child : children) {
            System.out.println("Child: " + child.getFirstName() + " " + child.getLastName());
        }
    }
}
