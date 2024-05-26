package homeWork;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создание объектов Person
        Person person1 = new Person("Иванов", "Иван", "Иванович", Gender.MALE, new Date(80, 0, 15));
        Person person2 = new Person("Петрова", "Мария", "Петровна", Gender.FEMALE, new Date(85, 5, 20));
        Person person3 = new Person("Иванова", "Ольга", "Ивановна", Gender.FEMALE, new Date(92, 8, 10));

        // Создание объекта FamilyTree и добавление в него персон
        FamilyTree familyTree = new FamilyTree();
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);

        // Отображение информации о персоне по id
        List<Person> allPersons = new ArrayList<>();
        allPersons.add(person1);
        allPersons.add(person2);
        allPersons.add(person3);

        familyTree.displayFamilyInfo(person1.getId(), allPersons);
    }
}
