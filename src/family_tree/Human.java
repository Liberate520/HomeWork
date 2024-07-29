package family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Класс, описывающий человека в генеалогическом дереве
public class Human implements Serializable {
    private static final long serialVersionUID = 1L; // Для обеспечения совместимости версий

    private String name; // Имя человека
    private LocalDate birthDate; // Дата рождения
    private LocalDate deathDate; // Дата смерти
    private String gender; // Пол человека
    private List<Human> children; // Список детей этого человека
    private List<Human> parents; // Список родителей этого человека
    private Human spouse; // Супруг/супруга

    // Конструктор класса Human
    public Human(String name, String birthDate, String gender) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.spouse = null;
    }

    // Метод для получения имени
    public String getName() {
        return name;
    }

    // Метод для получения даты рождения
    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Метод для получения даты смерти
    public LocalDate getDeathDate() {
        return deathDate;
    }

    // Метод для установки даты смерти
    public void setDeathDate(String deathDate) {
        this.deathDate = LocalDate.parse(deathDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    // Метод для получения пола
    public String getGender() {
        return gender;
    }

    // Метод для получения списка детей
    public List<Human> getChildren() {
        return children;
    }

    // Метод для добавления ребенка к этому человеку
    public void addChild(Human child) {
        this.children.add(child);
    }

    // Метод для получения списка родителей
    public List<Human> getParents() {
        return parents;
    }

    // Метод для добавления родителя к этому человеку
    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    // Метод для установки супруга/супруги
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    // Метод для получения супруга/супруги
    public Human getSpouse() {
        return spouse;
    }

    // Метод для расчета возраста
    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }

    // Метод для представления информации о человеке в виде строки
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(name)
                .append(", Пол: ").append(gender)
                .append(", Дата рождения: ").append(birthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        if (deathDate != null) {
            sb.append(", Дата смерти: ").append(deathDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        sb.append(", Возраст: ").append(getAge());

        // Отображение детей
        if (!children.isEmpty()) {
            sb.append(", Дети: [");
            for (Human child : children) {
                sb.append(child.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2); // Удаление последней запятой и пробела
            sb.append("]");
        } else {
            sb.append(", Дети: отсутствуют");
        }

        // Отображение родителей
        if (!parents.isEmpty()) {
            sb.append(", Родители: [");
            for (Human parent : parents) {
                sb.append(parent.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2); // Удаление последней запятой и пробела
            sb.append("]");
        } else {
            sb.append(", Родители: отсутствуют");
        }

        // Отображение супруга/супруги
        if (spouse != null) {
            sb.append(", Супруг(а): ").append(spouse.getName());
        } else {
            sb.append(", Супруг(а): отсутствует");
        }

        return sb.toString();
    }
}





