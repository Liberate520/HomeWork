package family_tree.human;

import java.util.List;

import family_tree.familyTree.TreeItem;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Human implements Serializable, TreeItem<Human> {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private String name;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender, null, null);
    }

    // public Human(String[] args, FamilyTree familyTree) {
    //     this.name = args[0];
    //     if (args[1].equals("Male")) {
    //         this.gender = Gender.Male;
    //     } else {
    //         this.gender = Gender.Female;
    //     }
    //     this.birthDate = LocalDate.parse(args[2], FORMATTER);
    //     if (args[3].equals("null")) {
    //         this.deathDate = null;
    //     } else {
    //         this.deathDate = LocalDate.parse(args[3], FORMATTER);
    //     }
    //     if (args[4].equals("null")) {
    //         this.mother = null;
    //     } else {
    //         this.mother = familyTree.getByName(args[4]);
    //     }
    //     if (args[5].equals("null")) {
    //         this.father = null;
    //     } else {
    //         this.father = familyTree.getByName(args[5]);
    //     }
    //     this.children = new ArrayList<>();
    // }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public void addChildren(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public Human getMother() {
        return mother;
    }

    @Override
    public Human getFather() {
        return father;
    }

    @Override
    public void addParents(Human parent1, Human parent2) {
        if (parent1.gender == Gender.Male) {
            father = parent1;
        } else {
            mother = parent1;
        }
        if (parent2.gender == Gender.Male) {
            father = parent2;
        } else {
            mother = parent2;
        }
    }

    @Override
    public void createRelatings(Human parent1, Human parent2, Human child) {
        child.addParents(parent1, parent2);
        parent1.addChildren(child);
        parent2.addChildren(child);
    }

    @Override
    public String getAllChildrens() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human child : children) {
            stringBuilder.append(child.name);
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    @Override
    public int getAge() {
        int age = 0;
        if (deathDate != null) {
            age = Period.between(birthDate, deathDate).getYears();
        } else {
            age = Period.between(birthDate, LocalDate.now()).getYears();
        }
        return age;
    }

    // private String writeChildrensToTxt() {
    //     StringBuilder stringBuilder = new StringBuilder();
    //     for (Human child : children) {
    //         stringBuilder.append(" " + child.name);
    //     }
    //     return stringBuilder.toString();
    // }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: " + name + 
                            ", Пол: " + gender + 
                            ", Возраст: " + getAge() +
                            ", Дата рождения: " + birthDate.format(FORMATTER));
        if (mother != null) {
            stringBuilder.append(", Мать: " + mother.name);
        } else {
            stringBuilder.append(", Мать: отсутсвует");
        }
        if (father != null) {
            stringBuilder.append(", Отец: " + father.name);
        } else {
            stringBuilder.append(", Отец: отсутствует");
        }
        if (!children.isEmpty()) {
            stringBuilder.append(", Дети: ");
            stringBuilder.append(getAllChildrens());
        } else {
            stringBuilder.append(", Дети: отсутствуют");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    // public String toTxt() {
    //     StringBuilder stringBuilder = new StringBuilder();
    //     stringBuilder.append(name + " " + gender + " " + birthDate.format(FORMATTER));
    //     if (deathDate != null) {
    //         stringBuilder.append(" " + deathDate.format(FORMATTER));
    //     } else {
    //         stringBuilder.append(" null");
    //     }
    //     if (mother != null) {
    //         stringBuilder.append(" " + mother.name);
    //     } else {
    //         stringBuilder.append(" null");
    //     }
    //     if (father != null) {
    //         stringBuilder.append(" " + father.name);
    //     } else {
    //         stringBuilder.append(" null");
    //     }
    //     if (!children.isEmpty()) {
    //         stringBuilder.append(writeChildrensToTxt());
    //     } else {
    //         stringBuilder.append(" null");
    //     }
    //     stringBuilder.append(";");
    //     return stringBuilder.toString();
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }
}
