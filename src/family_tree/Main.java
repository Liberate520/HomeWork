package family_tree;

import family_tree.person.Person;
import family_tree.writable.CSVFileHandler;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GenealogyTree tree = new GenealogyTree();

        // Добавление людей в древо
        Person vasily = new Person(0, "Василий", "Male", 50);
        Person maria = new Person(1, "Мария", "Female", 45);
        Person larisa = new Person(2, "Лариса", "Female", 90);
        Person gena = new Person(3, "Геннадий", "Male", 95);
        Person jora = new Person(4, "Жора", "Male", 18);

        // Добавляем всех людей в древо
        tree.addPerson(vasily);
        tree.addPerson(maria);
        tree.addPerson(larisa);
        tree.addPerson(gena);
        tree.addPerson(jora);

        // Установка супругов
        vasily.setSpouse(maria);
        maria.setSpouse(vasily);

        // Установка родителей
        vasily.setMother(larisa);
        vasily.setFather(gena);

        // Установка детей
        vasily.addChild(new Person(3, "Кристина", "Female", 25));
        vasily.addChild(new Person(4, "Семен", "Male", 20));

        // Создаем экземпляр класса CSVFileHandler
        CSVFileHandler csvFileHandler = new CSVFileHandler("listfamily.csv");

        // Создаем и заполняем карту peopleMap
        Map<Integer, Person> peopleMap = new HashMap<>();
        for (Person person : tree.getAllPeople()) {
            peopleMap.put(person.getId(), person);
        }

        // Записываем данные в файл CSV
        csvFileHandler.writeToFile(peopleMap);

        // Читаем данные из файла
        Map<Integer, Person> loadedPeopleMap = csvFileHandler.readFromFile();

        // Вывод информации о всех людях
        System.out.println("Информация о всех людях в древе:");
        for (Person person : loadedPeopleMap.values()) {
            tree.displayPersonInfo(person.getId());
        }

        // Получаем список всех людей из дерева
        Collection<Person> allPeople = tree.getAllPeople();

        // Сортируем список по имени
        List<Person> sortedByName = tree.sortByNames(allPeople);
        System.out.println("\nСписок людей, отсортированный по имени:");
        for (Person person : sortedByName) {
            tree.displayPersonInfo(person.getId());
        }

        // Сортируем список по возрасту
        List<Person> sortedByAge = tree.sortByAge(allPeople);
        System.out.println("\nСписок людей, отсортированный по возрасту:");
        for (Person person : sortedByAge) {
            tree.displayPersonInfo(person.getId());
        }
    }
}
