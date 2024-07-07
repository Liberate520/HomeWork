package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Human implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(int id, String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        
        // int id = -1;
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }
    public Gender getGender() { return gender; }
    public Human getFather() { return father; }
    public Human getMother() { return mother; }
    public List<Human> getChildren() { return children; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setDeathDate(LocalDate deathDate) { this.deathDate = deathDate; }
    public void setGender(Gender gender) { this.gender = gender; }
    public void setFather(Human father) { this.father = father; }
    public void setMother(Human mother) { this.mother = mother; }

    public void addChild(Human child) { 
        this.children.add(child); 
    }

    // Метод для расчета возраста
    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }

    @Override
    public String toString() {
        String childrenNames = children.isEmpty() ? "нет" : children.stream() 
                .map(Human::getName)
                .collect(Collectors.joining(", "));

        return "Human{" +
                "id: " + id +
                ", Имя: '" + name + '\'' +
                ", Возраст : " + getAge() +
                ", Пол: " + gender +
                ", Отец: " + (father != null ? father.getName() : "неизвестен") +
                ", Мать: " + (mother != null ? mother.getName() : "неизвестена") +
                ", Дети: " + childrenNames +
                '}';
    }

}
