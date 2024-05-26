package homeWork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Создание списка персон
        List<Person> allPersons = createPersonList();

        // Создание экземпляра класса FamilyTree
        FamilyTree familyTree = new FamilyTree();

        // Вызов метода для отображения информации о связях персоны с указанным идентификатором
        familyTree.displayFamilyInfo(1L, allPersons);
    }

    // Метод для создания списка персон (для демонстрации)
    private static List<Person> createPersonList() {
        List<Person> persons = new ArrayList<>();

        // Создание персон и добавление их в список
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Person person1 = new Person("Иванов", "Иван", "Иванович", sdf.parse("1980-01-01"));
            Person person2 = new Person("Иванова", "Мария", "Петровна", sdf.parse("1982-04-15"));
            Person person3 = new Person("Петров", "Петр", "Сергеевич", sdf.parse("1955-06-20"));
            Person person4 = new Person("Сидоров", "Андрей", "Иванович", sdf.parse("1945-10-10"));

            // Устанавливаем связи между персонами
            person1.addChildId(person3.getId()); // Иванов -> Петров
            person1.addChildId(person4.getId()); // Иванов -> Сидоров
            person2.addChildId(person3.getId()); // Иванова -> Петров
            person2.addChildId(person4.getId()); // Иванова -> Сидоров
            person3.addParentId(person1.getId()); // Петров <- Иванов
            person3.addParentId(person2.getId()); // Петров <- Иванова
            person4.addParentId(person1.getId()); // Сидоров <- Иванов
            person4.addParentId(person2.getId()); // Сидоров <- Иванова

            // Заполнение списка персон
            persons.add(person1);
            persons.add(person2);
            persons.add(person3);
            persons.add(person4);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return persons;
    }
}
