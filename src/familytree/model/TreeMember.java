package familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public abstract class TreeMember implements Serializable {
    protected String name;
    protected LocalDate birthDate;
    protected Gender gender;

    public TreeMember(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public abstract List<? extends TreeMember> getChildren();
    public abstract void addChild(TreeMember child);
}