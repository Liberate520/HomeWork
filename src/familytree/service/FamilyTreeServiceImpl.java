package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.model.SearchCriteria;

import java.util.List;
import java.util.stream.Collectors;

public class FamilyTreeServiceImpl implements FamilyTreeService {
    private FamilyTree<Person> familyTree;
    private FileService fileService;

    public FamilyTreeServiceImpl() {
        this.familyTree = new FamilyTree<>();
        this.fileService = new FileService();
    }

    @Override
    public void addPerson(Person person) {
        familyTree.addMember(person);
    }

    @Override
    public List<Person> getAllPeople() {
        return familyTree.getMembers();
    }

    @Override
    public List<Person> findChildren(String name) {
        for (Person person : familyTree) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person.getChildren();
            }
        }
        return List.of();
    }

    @Override
    public void sortByName() {
        familyTree.sortByName();
    }

    @Override
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    @Override
    public void saveToFile(String fileName) throws Exception {
        fileService.saveToFile(familyTree, fileName);
    }

    @Override
    public void loadFromFile(String fileName) throws Exception {
        familyTree = fileService.loadFromFile(fileName);
    }
}