package family_tree.creators.pet.cat;

import family_tree.creators.Creators;
import family_tree.creators.Gender;
import family_tree.creators.pet.Pet;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, String breed, Creators owner) {
        super(name, gender, birthDate, deathDate, breed, owner);
    }
}
