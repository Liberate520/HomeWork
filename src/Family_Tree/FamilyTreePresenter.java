package Family_Tree;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private FamilyTreeConsoleView view;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeConsoleView view) {
        this.service = service;
        this.view = view;
    }

    public void addPerson(String firstName, String lastName, int gender, LocalDate birthDate) {
        Person person = new Person(firstName, lastName, gender, birthDate);
        service.addPerson(person);
        view.displayPersonAdded(person);
    }

    public Person findPersonByName(String name) {
        return service.findPersonByName(name);
    }

    public void saveToFile(String fileName) {
        service.savePeopleToFile(fileName);
        service.saveAnimalsToFile(fileName);
        view.displayFileSaved(fileName);
    }

    public void loadFromFile(String fileName) {
        service.loadPeopleFromFile(fileName);
        service.loadAnimalsFromFile(fileName);
        view.displayFileLoaded(fileName);
    }

    public Collection<Person> getPeople() {
        return service.getPeople().values().stream()
                .collect(Collectors.toList());
    }

    public Collection<Animal> getAnimals() {
        return service.getAnimals().values().stream()
                .collect(Collectors.toList());
    }
}