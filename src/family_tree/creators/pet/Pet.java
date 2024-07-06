package family_tree.creators.pet;

import family_tree.creators.Creators;
import family_tree.creators.Gender;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Pet extends Creators implements Serializable {
    private String breed;
    private Creators owner;

    public Pet(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, String breed, Creators owner) {
        super(name, gender, birthDate, deathDate);
        this.breed = breed;
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Creators getOwner() {
        return owner;
    }

    public void setOwner(Creators owner) {
        this.owner = owner;
    }
}

//TODO создать клас human builder и айди,
// исправить дублированный вывод хуманов в хуманмап, после их добавления в дерево, пример ниже закомментил,
// добавить обобщение в файлхэндлер, класс сервис, преобразовать фэмили три в фэмили мэп