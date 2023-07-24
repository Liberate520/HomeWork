package family_tree.model.human;

import family_tree.model.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeItem<Human> {
    private String name;
    private Sex sex;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, Sex sex, LocalDate birthDate, LocalDate deathDate, List<Human> parents) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = parents;
        children = new ArrayList<>();
    }

    public Human(String name, Sex sex, LocalDate birthDate) {
        this(name, sex, birthDate, null, new ArrayList<>());
    }

    public Human(String name, Sex sex, LocalDate birthDate, List<Human> parents) {
        this(name, sex, birthDate, null, parents);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void addParent(Human parent) {
        parents.add(parent);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(name);
        sb.append(", Sex: ");
        sb.append(sex);
        sb.append(", Birth Date: ");
        sb.append(birthDate);
        if (deathDate != null) {
            sb.append(", Death Date: ");
            sb.append(deathDate);
        }
        sb.append(", Parents: ");
        sb.append(getParentsInfo());
        sb.append(", Children: ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getParentsInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parents: ");
        if (parents != null && !parents.isEmpty()) {
            sb.append(parents.get(0).getName());
            for (int i = 1; i < parents.size(); i++) {
                sb.append(", ").append(parents.get(i).getName());
            }
        } else {
            sb.append("Unknown");
        }
        return sb.toString();
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Children: ");
        if (children != null && !children.isEmpty()) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ").append(children.get(i).getName());
            }
        } else {
            sb.append("None");
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
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
}
