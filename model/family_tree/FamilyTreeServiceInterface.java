package model.family_tree;

import java.time.LocalDate;
import java.util.List;

import model.human.Gender;
import model.human.Human;
import model.places.Place;

public interface FamilyTreeServiceInterface {
    void addHuman(String firstName, String lastName, String patronymic, LocalDate birthDate, LocalDate deathDate,
            Gender gender, String nationality, Human father, Human mother, Human spouse, List<Human> children,
            Place birthPlace);

    void addPlace(int homeNumber, String street, String region, String country, int postalCode, String locality);

    void addBirthPlace(long humanID, long placeID);

    void sortByLastName();

    void sortByBirthDate();

    String getFamilyTreeInfo();

    void saveTree();

    void loadTree();
}