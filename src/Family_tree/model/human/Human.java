package Family_tree.model.human;

import ru.gb.Family_tree.model.family_tree.TreeTop;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Human implements Serializable, Iterable<Human>, TreeTop {

    @Override
    public Iterator<Human> iterator() {

        return null;
    }

    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human( String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
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

    public Human(String name, String gender, String birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.parents = null;

    }

   public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
       this.name = name;
       this.gender = gender;
       this.birthDate = birthDate;;
       parents = new ArrayList<>();
       if (father != null) {
           parents.add(father);
       }
       if (mother != null) {
           parents.add(mother);
       }
       children = new ArrayList<>();
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

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public int getId() {
        return (int) id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Human getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(Object human) {
        this.spouse = spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public String getName() {
        return name;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
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

    @Override
    public void addChild(Object child) {
        if (!children.contains(child)) {
            children.add((Human) child);
        }
    }

    @Override
    public void addParent(Object parent) {
        if (!parents.contains(parent)) {
            parents.add((Human) parent);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public Gender getGender() {
        return gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public LocalDate getDeathDate() {
        return null;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        String sb = "id: " +
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
                getFatherInfo() +
                ", " +
                getMotherInfo() +
                ", " +
                getChildrenInfo() +
                ", ";
        return sb;
    }

    public String getSpouseInfo() {
        String res;
        res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = getFather();
        if (mother != null) {
            res += mother.getName();
        }
        return res;
    }

    public StringBuilder getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствует");
        }
        return new StringBuilder(res.toString());
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

    public void Human(String name, String gender, String birthDate, String father, String mother, String children) {
    }
}