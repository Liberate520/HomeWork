import java.util.ArrayList;
import java.util.List;

/**
 * Класс для представления человека в генеалогическом древе.
 * Содержит информацию о человеке, его родителях и детях.
 */
public class Human {
    private String fullName; // Полное имя человека
    private Gender gender; // Пол человека
    private String birthDate; // Дата рождения человека
    private String deathDate; // Дата смерти человека
    private Human mother; // Мать человека
    private Human father; // Отец человека
    private List<Human> children; // Дети человека
    private Human spouse; // Супруг(а) человека

    public Human(String fullName, Gender gender, String birthDate, String deathDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
    }

    // Метод для установки матери человека
    public void setMother(Human mother) {
        this.mother = mother;
    }

    // Метод для установки отца человека
    public void setFather(Human father) {
        this.father = father;
    }

    // Метод для добавления ребенка человеку
    public void addChild(Human child) {
        children.add(child);
    }

    // Метод для установки супруга(и) человека
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: ").append(fullName).append("\n");
        stringBuilder.append("Пол: ").append(gender).append("\n");
        stringBuilder.append("Дата рождения: ").append(birthDate).append("\n");
        stringBuilder.append("Дата смерти: ").append(deathDate).append("\n");

        if (mother != null) {
            stringBuilder.append("Мать: ").append(mother.fullName).append("\n");
        }

        if (father != null) {
            stringBuilder.append("Отец: ").append(father.fullName).append("\n");
        }

        if (!children.isEmpty()) {
            stringBuilder.append("Дети:\n");
            for (Human child : children) {
                stringBuilder.append("- ").append(child.fullName).append("\n");
            }
        }

        if (spouse != null) {
            stringBuilder.append("Супруг(а): ").append(spouse.fullName).append("\n");
        }

        return stringBuilder.toString();
    }

    public boolean hasChild(String personName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasChild'");
    }

    public Human getSpouse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpouse'");
    }

    public char[] getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }
}