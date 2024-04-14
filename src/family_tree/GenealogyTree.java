package family_tree;

import family_tree.person.Person;

import java.io.Serializable;
import java.util.*;

public class GenealogyTree implements Serializable, Iterable<Person> {
    private final Map<Integer, Person> people;

    public GenealogyTree() {
        this.people = new HashMap<>();
    }

    // Метод для поиска человека по его id
    public Person findPersonById(int id) {
        return people.getOrDefault(id, null);
    }

    public void displayPersonInfo(int id) {
        Person person = findPersonById(id);
        if (person != null) {
            System.out.println("id: " + id +
                    ", имя: " + person.getName() +
                    ", пол: " + person.getGender() +
                    ", возраст: " + person.getAge() + // Используем возраст вместо даты рождения
                    ", супруг(а): " + (person.getSpouse() != null ? person.getSpouse().getName() : "Нет") +
                    ", мать: " + (person.getMother() != null ? person.getMother().getName() : "Нет") +
                    ", отец: " + (person.getFather() != null ? person.getFather().getName() : "Нет") +
                    ", дети: " + person.getChildrenNames());
        } else {
            System.out.println("Человек с id " + id + " не найден.");
        }
    }

    public void addPerson(Person person) {
        people.put(person.getId(), person);
    }

    public Collection<Person> getAllPeople() {
        return people.values();
    }

    @Override
    public Iterator<Person> iterator() {
        return people.values().iterator();
    }

    // Метод сортировки списка людей по имени
    public List<Person> sortByNames(Collection<Person> people) {
        List<Person> sortedList = new ArrayList<>(people);
        Collections.sort(sortedList, Comparator.comparing(Person::getName));
        return sortedList;
    }

    // Метод сортировки списка людей по возрасту
    public List<Person> sortByAge(Collection<Person> people) {
        List<Person> sortedList = new ArrayList<>(people);
        Collections.sort(sortedList, Comparator.comparingInt(Person::getAge));
        return sortedList;
    }
}
