package family_tree.family;

import family_tree.person.Person;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GenealogyTree {
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
                           ", возраст: " + person.getAge() +
                           ", супруг(а): " + (person.getSpouse() != null ? person.getSpouse().getName() : "Нет") +
                           ", мать: " + (person.getMother() != null ? person.getMother().getName() : "Нет") +
                           ", отец: " + (person.getFather() != null ? person.getFather().getName() : "Нет") +
                           ", дети: " + person.getChildrenNames());
    } else {
        System.out.println("Человек с id " + id + " не найден.");
    }
}

    public void addPerson(Person person) {
        Person put = people.put(person.getId(), person);
    }
public Collection<Person> getAllPeople() {
    return people.values();
}
}
