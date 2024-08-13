import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    //Конструктор
    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Human getFather() { return father; }

    public Human getMother() { return mother; }

    public List<Human> getChildren() { return children; }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.father = mother;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }


    // Ещё методы
    @Override
    public String toString(){
        return  "Имя: " + name + '\n' +
                "Пол: " + gender + '\n' +
                "Дата рождения: " + birthDate + '\n';

    }
}