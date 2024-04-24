package model.human;

import model.family_tree.TreeNode;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human> {

    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    //  Constructor:
//    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother, Human spouse) {
//        id = -1;
//        this.name = name;
//        this.gender = gender;
//        this.birthDate = birthDate;
//        this.deathDate = deathDate;
//        parents = new ArrayList<>();
//        if (father != null) {
//            parents.add(father);
//        }
//        if (mother != null) {
//            parents.add(mother);
//        }
//        this.spouse = spouse;
//        children = new ArrayList<>();
//    }
//
//    public Human(String name, Gender gender, LocalDate birthDate) {
//        this(name, gender, birthDate, null, null, null, null);
//    }

    //  Method:
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

    public int getPeriod(LocalDate date1, LocalDate date2) {
        Period diff = Period.between(date1, date2);
        return diff.getYears();
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
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

    public List<Human> getParents() {
        return parents;
    }

    public Human getSpouse() {
        return spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    //  Setters:
    public void setId(int id) {
        this.id = id;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    public void initParents() {
        this.parents = new ArrayList<>();
    }

    public void initChildren() {
        this.children = new ArrayList<>();
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            child.addParent(this);
        }
    }

    public void addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            parent.addChild(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human human)) {
            return false;
        }
        return human.getId() == getId();
    }

    //  Overrides toString:
    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        int len = 17;
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append("\u001B[36m").append(id).append("\u001B[0m");
        sb.append(" ".repeat(Math.max(0, len - sb.length())));
        sb.append("| имя: ");
        sb.append("\u001B[36m").append(name).append("\u001B[0m");
        len += 25;
        sb.append(" ".repeat(Math.max(0, len - sb.length())));
        sb.append("| пол: ");
        sb.append("\u001B[36m").append(getGender()).append("\u001B[0m");
        len += 25;
        sb.append(" ".repeat(Math.max(0, len - sb.length())));
        sb.append("| возраст: ");
        sb.append("\u001B[36m").append(getAge()).append("\u001B[0m");
        len += 25;
        sb.append(" ".repeat(Math.max(0, len - sb.length())));
        sb.append(getSpouseInfo());
        len += 31;
        sb.append(" ".repeat(Math.max(0, len - sb.length())));
        sb.append(getMotherInfo());
        len += 30;
        sb.append(" ".repeat(Math.max(0, len - sb.length())));
        sb.append(getFatherInfo());
        len += 30;
        sb.append(" ".repeat(Math.max(0, len - sb.length())));
        sb.append(getChildrenInfo());
        len += 31;
        sb.append(" ".repeat(Math.max(0, len - sb.length())));
        sb.append("| умер: ");
        sb.append("\u001B[36m").append(getDeathDate()).append("\u001B[0m");
        return sb.toString();
    }

    private String getSpouseInfo() {
        StringBuilder res = new StringBuilder();
        res.append("| супруг(а): " + "\u001B[36m");
        if (spouse == null) {
            res.append("нет" + "\u001B[0m");
        } else {
            res.append(spouse.getName()).append("\u001B[0m");
        }
        return res.toString();
    }

    private String getMotherInfo() {
        String res = "| мать: " + "\u001B[36m";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
            res += "\u001B[0m";
        } else {
            res += "неизвестна" + "\u001B[0m";
        }
        return res;
    }

    private String getFatherInfo() {
        String res = "| отец: " + "\u001B[36m";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
            res += "\u001B[0m";
        } else {
            res += "неизвестен" + "\u001B[0m";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("| дети: " + "\u001B[36m");
        if (!children.isEmpty()) {
            res.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        res.append("\u001B[0m");
        return res.toString();
    }
}