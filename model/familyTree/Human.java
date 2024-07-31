package model.familyTree;

// import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;

public class Human implements Comparable <Human>, FamilyTreeMember <Human> {
// public class Human implements Serializable {
//     private static final long serialVersionUID = 1L;
    
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    public List<Human> parents = new ArrayList<>();
    private List<Human> children = new ArrayList<>();

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
        parent.children.add(this);
    }

    public void addParent(Human parent1, Human parent2) {
        this.addParent(parent1);
        this.addParent(parent2);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getAncestors(Human person, int generations) {
        List<Human> ancestors = new ArrayList<>();
        getAncestorsRecursive(person, generations, ancestors);
        return ancestors;
    }

    private void getAncestorsRecursive(Human person, int generations, List<Human> ancestors) {
        if (generations == 0 || person == null) return;
        if (!person.parents.isEmpty()) {
            ancestors.addAll(person.parents);
            for (Human parent : person.parents) {
                getAncestorsRecursive(parent, generations - 1, ancestors);
            }
        }
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Пол: " + gender + ", Родился: " + birthDate + 
               ", Дата смерти: " + (deathDate == null ? "Жив" : deathDate);
    }

    @Override
    public LocalDate getDeathDate() {
        throw new UnsupportedOperationException("Поломано");
    }

    @Override
    public int compareTo(Human o) {
        throw new UnsupportedOperationException("Неверно");
    }
}