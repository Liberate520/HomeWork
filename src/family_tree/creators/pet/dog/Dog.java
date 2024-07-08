package family_tree.creators.pet.dog;

import family_tree.creators.Creators;
import family_tree.creators.Gender;
import family_tree.creators.pet.Pet;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, String breed, Creators owner) {
        super(name, gender, birthDate, deathDate, breed, owner);
    }
}
