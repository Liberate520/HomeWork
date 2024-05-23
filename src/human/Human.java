package human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father,
            List<Human> spouse, List<Human> children) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    public Human(String name, Gender gender) {
        this(name, gender, null, null, null, null, null, null);
    }

    public int getAge() {
        if (dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());
        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period period = Period.between(dateOfBirth, dateOfDeath);
        return period.getYears();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setParent(Human parent) {
        if (parent.gender == Gender.Female) {
            this.mother = parent;
        } else {
            this.father = parent;
        }
        parent.setChildren(this);
    }

    public void setParents(Human parent1, Human parent2) {
        if (parent1.gender == Gender.Female) {
            this.mother = parent1;
            this.father = parent2;
        } else {
            this.father = parent1;
            this.mother = parent2;
        }
        parent1.setChildren(this);
        parent2.setChildren(this);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human human) {
        if (children == null) {
            children = new ArrayList<Human>();
            this.children.add(human);
        } else {
            if (children.contains(human)) {
                return;
            } else {
                this.children.add(human);
            }
        }
        human.setParent(this);
    }

    public String getChildenNames() {
        if (children == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        for (Human human : children) {
            builder.append(human.getName());
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Person: [");
        builder.append("name: ");
        builder.append(name);
        builder.append(", gender: ");
        builder.append(gender);
        if (dateOfBirth != null && dateOfDeath != null) {
            builder.append(", years of life: ");
            builder.append(dateOfBirth);
            builder.append(" - ");
            builder.append(dateOfDeath);
            builder.append(", lived ");
            builder.append(getAge());
            builder.append(" years");
        } else if (dateOfBirth != null && dateOfDeath == null) {
            builder.append(", born: ");
            builder.append(dateOfBirth);
            builder.append(", current age: ");
            builder.append(getAge());
        } else if (dateOfBirth == null && dateOfDeath != null) {
            builder.append(", died: ");
            builder.append(dateOfDeath);
        } else {
            builder.append(", no info about age");
        }
        builder.append(", mother: ");
        if (mother == null) {
            builder.append("No info");
        } else {
            builder.append(getMother().getName());
        }
        builder.append(", father: ");
        if (father == null) {
            builder.append("No info");
        } else {
            builder.append(getFather().getName());
        }
        builder.append(", ");
        builder.append("children: ");
        builder.append(getChildenNames());
        builder.append("]");
        return builder.toString();
    }
}