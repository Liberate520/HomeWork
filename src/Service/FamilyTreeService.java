package Service;

import Model.FamilyTree;
import Model.Person;
import Util.DataHandler;

import java.time.LocalDate;

public class FamilyTreeService {
    private final FamilyTree<Person> familyTree;
    private final DataHandler<FamilyTree<Person>> dataHandler;

    // Конструктор теперь принимает интерфейс, а не конкретную реализацию
    public FamilyTreeService(FamilyTree<Person> familyTree, DataHandler<FamilyTree<Person>> dataHandler) {
        this.familyTree = familyTree;
        this.dataHandler = dataHandler;
    }

    public void addPerson(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate, Person.Gender gender) {
        Person person = new Person(firstName, lastName, birthDate, deathDate, gender);
        familyTree.addPerson(person);
    }

// Логика работы с датами и гендером перемещена в View

    public Person findByNameOrId(String searchInput) {
        if (searchInput.matches("\\d+")) {
            int searchId = Integer.parseInt(searchInput);
            return findById(searchId);
        } else {
            String[] nameParts = searchInput.split(" ");
            String firstName = nameParts[0];
            String lastName = nameParts.length > 1 ? nameParts[1] : "";
            return findByName(firstName, lastName);
        }
    }

    public Person findById(int id) {
        for (Person person : familyTree.getAllPeople()) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public Person findByName(String firstName, String lastName) {
        for (Person person : familyTree.getAllPeople()) {
            if (person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName)) {
                return person;
            }
        }
        return null;
    }

    public void saveTree(String fileName) {
        dataHandler.saveFamilyTree(familyTree, fileName);
    }

    public void loadTree(String fileName) {
        FamilyTree<Person> loadedTree = dataHandler.loadFamilyTree(fileName);
        if (loadedTree != null) {
            familyTree.getAllPeople().clear();
            familyTree.getAllPeople().addAll(loadedTree.getAllPeople());
        }
    }

    public void setParents(int childId, int motherId, int fatherId) {
        familyTree.setParents(childId, motherId, fatherId);
    }

    public FamilyTree<Person> getFamilyTree() {
        return familyTree;
    }
}
