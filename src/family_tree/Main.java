package family_tree;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import family_tree.util.GenealogyTree;
import family_tree.person.Person;
import family_tree.view.FamilyTreeViewImpl;
import family_tree.writable.CSVFileHandler;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр обобщенного класса GenealogyTree<Person>
            GenealogyTree<Person> tree = new GenealogyTree<>();
            CSVFileHandler csvFileHandler = new CSVFileHandler("listfamily.csv");
            FamilyTreeViewImpl familyTreeView = new FamilyTreeViewImpl(tree, csvFileHandler);

            // Показываем меню
        familyTreeView.showMenu();

        // Добавление людей в древо
        Person vasily = new Person(0, "Василий", "Male", 50);
        Person maria = new Person(1, "Мария", "Female", 45);
        Person larisa = new Person(2, "Лариса", "Female", 90);
        Person gena = new Person(3, "Геннадий", "Male", 95);
        Person jora = new Person(4, "Жора", "Male", 18);

        // Добавляем всех людей в древо
        tree.addElement(vasily.getId(), vasily);
        tree.addElement(maria.getId(), maria);
        tree.addElement(larisa.getId(), larisa);
        tree.addElement(gena.getId(), gena);
        tree.addElement(jora.getId(), jora);

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
        csvFileHandler = new CSVFileHandler("listfamily.csv");

        // Создаем и заполняем карту peopleMap
        Map<Integer, Person> peopleMap = new HashMap<>();
        for (Person person : tree.getAllElements()) {
            peopleMap.put(person.getId(), person);
        }

        // Записываем данные в файл CSV
        csvFileHandler.writeToFile(peopleMap);

        // Читаем данные из файла
        Map<Integer, Person> loadedPeopleMap = csvFileHandler.readFromFile();

        // Вывод информации о всех людях
        System.out.println("Информация о всех людях в древе:");
        for (Person person : loadedPeopleMap.values()) {
            tree.displayInfo(person.getId());
        }

        // Получаем список всех людей из дерева
        Collection<Person> allPeople = tree.getAllElements();

        // Сортируем список по имени
        List<Person> sortedByName = tree.sortByName(allPeople);
        System.out.println("\nСписок людей, отсортированный по имени:");
        for (Person person : sortedByName) {
            tree.displayInfo(person.getId());
        }

        // Сортируем список по возрасту
        List<Person> sortedByAge = tree.sortByAge(allPeople);
        System.out.println("\nСписок людей, отсортированный по возрасту:");
        for (Person person : sortedByAge) {
            tree.displayInfo(person.getId());
        }
    }
}
