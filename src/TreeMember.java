

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class TreeMember implements Serializable {

    private final String name;
    private final Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private TreeMember mother;
    private TreeMember father;
    private List<TreeMember> children;
    private List<TreeMember> parents;

    public TreeMember(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public TreeMember(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public TreeMember(String name, LocalDate birthDate, Gender gender, TreeMember mother, TreeMember father) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        parents = new ArrayList<>();
        if (mother != null) {
            parents.add(mother);
        }
        if (father!= null) {
            parents.add(father);
        }
        this.children = new ArrayList<>();
    }

    public boolean addChild(TreeMember child) {
        if (child != null && !children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(TreeMember parent) {
        if (parents != null && !parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public List<TreeMember> getParents() {
        List<TreeMember> parents = new ArrayList<>();
        if (mother != null) {
            parents.add(mother);
        }
        if (father != null) {
            parents.add(father);
        }
        return parents;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public TreeMember getMother() {
        for (TreeMember parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public TreeMember getFather() {
        for (TreeMember parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public List<TreeMember> getChildren() {
        return children;
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


    @Override
    public String toString() {
        return name + " (" + birthDate + " - " + (deathDate != null ? deathDate : "настоящее время") + ", " + gender + ")";
    }
}