package model.family_tree;

import java.time.LocalDate;
import java.util.List;

import model.human.FamilyRelations;
import model.human.Gender;
import model.human.Human;
import model.human.HumanBuilder;
import model.places.Place;
import model.places.PlaceBuilder;
import model.writers.ObjectReader;
import model.writers.ObjectWriter;

// Применяем DIP: Класс FamilyTreeService реализует интерфейс.
public class FamilyTreeService implements FamilyTreeServiceInterface {
    private FamilyTree<Human, Place> familyTree;
    private FamilyTreeSorter<Human> sorter;
    private ObjectWriter writer;
    private ObjectReader reader;

    public FamilyTreeService(ObjectWriter writer, ObjectReader reader) {
        familyTree = new FamilyTree<>();
        sorter = new FamilyTreeSorter<>();
        this.writer = writer;
        this.reader = reader;
    }

    @Override
    public void addHuman(String firstName, String lastName, String patronymic, LocalDate birthDate, LocalDate deathDate,
            Gender gender, String nationality, Human father, Human mother, Human spouse,
            List<Human> children, Place birthPlace) {
        Human human = new HumanBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPatronymic(patronymic)
                .setBirthDate(birthDate)
                .setDeathDate(deathDate)
                .setGender(gender)
                .setNationality(nationality)
                .build();

        FamilyRelations<Human> relations = new FamilyRelations<>();
        relations.setFather(father);
        relations.setMother(mother);
        relations.setSpouse(spouse);
        if (children != null) {
            for (Human child : children) {
                relations.addChild(child);
            }
        }
        human.setFather(relations.getFather());
        human.setMother(relations.getMother());
        human.setSpouse(relations.getSpouse());
        human.setChildren(relations.getChildren());
        human.setBirthPlace(birthPlace);
        familyTree.addHuman(human);
    }

    public void addPlace(int homeNumber, String street, String region, String country, int postalCode,
            String locality) {
        Place place = new PlaceBuilder()
                .setHomeNumber(homeNumber)
                .setStreet(street)
                .setRegion(region)
                .setCountry(country)
                .setPostalCode(postalCode)
                .setLocality(locality)
                .build();
        familyTree.addPlace(place);
    }

    public void addBirthPlace(long humanID, long placeID) {
        boolean success = familyTree.addBirthPlace(humanID, placeID);
        if (!success) {
            System.out.println("Человек или место не найдены.");
        }
    }

    @Override
    public void sortByLastName() {
        sorter.sort(familyTree.getHumanList(), new HumanComparatorByLastName<>());
    }

    @Override
    public void sortByBirthDate() {
        sorter.sort(familyTree.getHumanList(), new HumanComparatorByBirthDate<>());
    }

    @Override
    public String getFamilyTreeInfo() {
        return familyTree.toString();
    }

    public void saveTree() {
        writer.write(familyTree);
    }

    public void loadTree() {
        FamilyTree<Human, Place> loadedTree = (FamilyTree<Human, Place>) reader.read();
        if (loadedTree != null) {
            familyTree = loadedTree;
        } else {
            System.out.println("Ошибка загрузки дерева.");
        }
    }
}