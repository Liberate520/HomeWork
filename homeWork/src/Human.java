import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private String name;
    private String familyName;
    private Gender gender;
    private LocalDate birthData;
    private LocalDate deathData;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    public Human(String name, String familyName, Gender gender, LocalDate birthData) {
        this.name = name;
        this.familyName = familyName;
        this.gender = gender;
        this.birthData = birthData;
        this.childrens = new ArrayList<>();
    }

    public Human(String name, String familyName, Gender gender, LocalDate birthData, Human mother, Human father) {
        this(name, familyName, gender, birthData);
        if (isGenderCorrect(mother, Gender.female)) {
            this.mother = mother;
            addChildren(mother);
        }
        if (isGenderCorrect(father, Gender.male)) {
            this.father = father;
            addChildren(father);
        }

    }
    private void addChildren(Human human) {
        if (!human.childrens.contains(this)) {
            human.childrens.add(this);
        }
    }
    private boolean isGenderCorrect(Human human, Gender gender) {
        if (human.getGender().equals(gender)) return true;
        return false;
    }

    public String fullInfo() {
        return name  + familyName +
                ", Дата рождения: " + birthData +
                ", Дата смерти: " + deathData +
                ", Возраст: " + getAge() +
                ", Мать " + mother +
                ", Отец " + father +
                ", Дети " + childrens;
    }

    public int getAge() {
        return getPeriod(birthData, Objects.requireNonNullElseGet(deathData, LocalDate::now));
    }

    private int getPeriod (LocalDate birthData, LocalDate data) {
        return Period.between(birthData, data).getYears();
    }

        @Override
    public String toString() {
        return name + " " + familyName + " ";
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public void setDeathData(LocalDate deathData) {
        this.deathData = deathData;
    }
}

