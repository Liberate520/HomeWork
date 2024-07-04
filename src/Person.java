import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

// Класс Person представляет человека
class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private LocalDate birthDate;
    private String gender;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, LocalDate birthDate, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // Получение имени человека
    public String getName() {
        return name;
    }

    // Получение даты рождения человека
    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Получение пола человека
    public String getGender() {
        return gender;
    }

    // Получение возраста человека, вычисленного на основе текущей даты
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Получение списка родителей
    public List<Person> getParents() {
        return parents;
    }

    // Получение списка детей
    public List<Person> getChildren() {
        return children;
    }

    // Добавление родителя
    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    // Добавление ребенка
    public void addChild(Person child) {
        this.children.add(child);
        child.addParent(this);
    }

    @Override
    public String toString() {
        return "Имя='" + name + '\'' + ", Возраст=" + getAge() + ", Пол='" + gender + '\'';
    }
}
