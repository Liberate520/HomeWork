
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Human {
    int id;
    String name;
    Gender gender;
    int age;
    Human spouse;
    Human mother;
    Human father;
    List<Human> children;

    public Human(int id, String name, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("id: %d, имя: %s, пол: %s, возраст: %d, ", id, name, gender, age));
        sb.append(String.format("супруг(а): %s, ", spouse != null ? spouse.name : "нет"));
        sb.append(String.format("мать: %s, ", mother != null ? mother.name : "неизвестна"));
        sb.append(String.format("отец: %s, ", father != null ? father.name : "неизвестен"));
        sb.append("дети: ");
        if (children.isEmpty()) {
            sb.append("отсутствуют");
        } else {
            sb.append(String.join(", ", children.stream().map(c -> c.name).toArray(String[]::new)));
        }
        return sb.toString();
    }
}