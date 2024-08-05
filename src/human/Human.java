package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Human implements Serializable, Comparable<Human> {
    private final String name;
    private LocalDate birthdate;
    private LocalDate deathDate;
    private Sex sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate birthdate, LocalDate deathDate, Sex sex, Human father, Human mother) {
        this.name = name;
        this.birthdate = birthdate;
        this.deathDate = deathDate;
        this.sex = sex;
        children = new ArrayList<>();
        setFamilyTies(father, mother);
    }

    public Human(String name, LocalDate birthdate, Sex sex, Human father, Human mother) {
        this(name, birthdate, null, sex, father, mother);
    }

    public Human(String name, LocalDate birthdate, Sex sex) {
        this(name, birthdate, sex, null, null);
    }

    public Human(String name, Sex sex) {
        this(name, null, sex);
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
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

    public String getName() {
        return name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
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

    public int getAge() {
        return (deathDate == null) ?
                Period.between(birthdate, LocalDate.now()).getYears() :
                Period.between(birthdate, deathDate).getYears();
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
                "имя: " + name +
                ", возраст: " + age +
                ", пол: " + (sex == Sex.MALE ? "м." : "ж.") +
                ", отец: " + fatherName +
                ", мать: " + motherName +
                ", дети: " + childrenNames +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
