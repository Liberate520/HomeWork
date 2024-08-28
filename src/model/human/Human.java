package model.human;

import model.family_tree.FamilyTreeItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Human implements FamilyTreeItem {
    private int id;
    private final String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Sex sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Sex sex, Human father, Human mother) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.sex = sex;
        children = new ArrayList<>();
        setFamilyTies(father, mother);
    }

    public Human(String name, LocalDate birthDate, Sex sex, Human father, Human mother) {
        this(name, birthDate, null, sex, father, mother);
    }

    public Human(String name, LocalDate birthDate, Sex sex) {
        this(name, birthDate, sex, null, null);
    }

    public Human(String name, Sex sex) {
        this(name, null, sex);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setFamilyTies(Human father, Human mother) {
        if (father != null) {
            if (father.sex != Sex.MALE)
                throw new IllegalArgumentException("Отец должен быть мужчиной.");
            // Если родители были прописаны ранее, т.е. изменяем данные,
            // то этого человека надо удалить из списка детей прежних родителей.
            if (this.father != null)
                this.father.children.remove(this);
            this.father = father;
            father.children.add(this);
        }
        if (mother != null) {
            if (mother.sex != Sex.FEMALE)
                throw new IllegalArgumentException("Мать должна быть женщиной");
            // Если родители были прописаны ранее, т.е. изменяем данные,
            // то этого человека надо удалить из списка детей прежних родителей.
            if (this.mother != null)
                this.mother.children.remove(this);
            this.mother = mother;
            mother.children.add(this);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Sex getSex() {
        return sex;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    /**
     * Проверяет, является ли человек сиблингом данного человека.
     *
     * @param human проверяемый человек
     * @return true - является, false - нет
     */
    public boolean isSibling(Human human) {
        return this.father == human.father || this.mother == human.mother;
    }

    public Set<Human> findSiblings() {
        Set<Human> result = new HashSet<>();
        result.addAll(father.getChildren());
        result.addAll(mother.getChildren());
        result.removeIf(h -> h.equals(this));
        return result;
    }

    @Override
    public int getAge() {
        if (birthDate == null)
            return Integer.MAX_VALUE;   // С неизвестным днем рождения - в конец списка.
        return (deathDate == null) ?
                Period.between(birthDate, LocalDate.now()).getYears() :
                Period.between(birthDate, deathDate).getYears();
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        int age = getAge();
        String fatherName = (father != null) ? father.name : "Неизвестен";
        String motherName = (mother != null) ? mother.name : "Неизвестна";
        String childrenNames = !children.isEmpty() ?
                children.stream().map(c -> c.name).collect(Collectors.joining(", ")) :
                "нет";

        return "Человек{" +
                "ID: " + id +
                ", имя: " + name +
                ", возраст: " + age +
                ", пол: " + (sex == Sex.MALE ? "м." : "ж.") +
                ", отец: " + fatherName +
                ", мать: " + motherName +
                ", дети: " + childrenNames +
                '}';
    }

    @Override
    public int compareTo(FamilyTreeItem o) {
        return name.compareTo(o.getName());
    }
}
