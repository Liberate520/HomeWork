package family_tree;

import java.time.LocalDate;
import java.util.List;

import human.Gender;
import human.Human;
import human.HumanBuilder;
import places.Place;
import places.PlaceBuilder;

public class FamilyTreeService {
    private FamilyTree<Human, Place> familyTree;
    private HumanBuilder humanBuilder;
    private PlaceBuilder placeBuilder;

    public FamilyTreeService() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
        placeBuilder = new PlaceBuilder();
    }

    public void addHuman(String firstName, String lastName, String patronymic,
            LocalDate birthDate, LocalDate deathDate, Gender gender,
            String nationality, Human father, Human mother, Human spouse,
            List<Human> children, Place place) {
        Human human = humanBuilder.setFirstName(firstName)
                .setLastName(lastName)
                .setPatronymic(patronymic)
                .setBirthDate(birthDate)
                .setDeathDate(deathDate)
                .setGender(gender)
                .setNationality(nationality)
                .setFather(father)
                .setMother(mother)
                .setSpouse(spouse)
                .setChildren(children)
                .setPlace(place)
                .build();
        familyTree.addHuman(human);
    }

    public void addPlace(int homeNumber, String street, String region,
            String country, int postalCode, String locality) {
        Place place = placeBuilder.setHomeNumber(homeNumber)
                .setStreet(street)
                .setRegion(region)
                .setCountry(country)
                .setPostalCode(postalCode)
                .setLocality(locality)
                .build();
        familyTree.addPlace(place);
    }

    public void sortByLastName() {
        familyTree.sortByLastName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public String getFamilyTreeInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное древо:\n");
        for (Human human : familyTree) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

}
