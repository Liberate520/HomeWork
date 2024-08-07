package Family_Tree;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Animal {
    protected String name;
    protected LocalDate birthDate;
    protected LocalDate deathDate;

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        if (deathDate != null) {
            return birthDate.until(deathDate).getYears();
        } else {
            return birthDate.until(LocalDate.now()).getYears();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(name).append(", ");
        sb.append("Дата рождения: ").append(birthDate).append(", ");
        sb.append("Возраст: ").append(getAge());
        if (deathDate != null) {
            sb.append(", Дата смерти: ").append(deathDate);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) && Objects.equals(birthDate, animal.birthDate) && Objects.equals(deathDate, animal.deathDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, deathDate);
    }
}