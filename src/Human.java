import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Human {
    private final String name;
    private LocalDate birthdate;
    private Sex sex;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
        children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthdate, Sex sex) {
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthdate, Sex sex, Human father, Human mother) {
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        children = new ArrayList<>();
        setFamilyTies(father, mother);
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setFamilyTies(Human father, Human mother) {
        if (father.sex != Sex.MALE)
            throw new IllegalArgumentException("Отец должен быть мужчиной.");
        if (mother.sex != Sex.FEMALE)
            throw new IllegalArgumentException("Мать должна быть женщиной");
        // Если родители были прописаны ранее, т.е. изменяем данные,
        // то данного человека надо удалить из списка детей прежних родителей.
        if (this.father != null)
            this.father.children.remove(this);
        if (this.mother != null)
            this.mother.children.remove(this);
        this.father = father;
        this.mother = mother;
        father.children.add(this);
        mother.children.add(this);
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

    @Override
    public String toString() {
        int age = Period.between(birthdate, LocalDate.now()).getYears();
        String fatherName = father != null ? father.name : "Неизвестен";
        String motherName = mother != null ? mother.name : "Неизвестна";
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
}
