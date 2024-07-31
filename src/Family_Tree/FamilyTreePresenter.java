package Family_Tree;

import java.util.Map;

public class FamilyTreePresenter {
    private FamilyTree model;

    public FamilyTreePresenter(FamilyTree model) {
        this.model = model;
    }

    public void addPerson(String name, int gender, LocalDate birthDate) {
        Person person = new Person(name, gender, birthDate);
        model.addPerson(person);
    }

    public void saveToFile(String fileName) {
        model.saveToFile(fileName);
    }

    public void loadFromFile(String fileName) {
        model.loadFromFile(fileName);
    }

    public Map<String, Person> getPeople() {
        return model.getPeople();
    }
}