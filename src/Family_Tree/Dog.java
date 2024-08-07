package Family_Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Dog extends Animal implements Serializable {
    private String breed;

    public Dog(String name, String breed, LocalDate birthDate) {
        super(name, birthDate);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", Порода: ").append(breed);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), breed);
    }
}
