// Класс Main - Это мотор а именно для запуска приложения.
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        Person rustam = new Person("Рустам", "04-04-1962", null, null);
        Person boyjon = new Person("Бойжон", "01-01-1940", null, null);
        Person mukaddas = new Person("Мукаддас", "05-05-1962", null, boyjon);
        Person doniyor = new Person("Дониёр", "08-11-1987", mukaddas, rustam);
        Person sevora = new Person("Севара", "02-02-1962", null, null);
        Person samiy = new Person("Самий", "03-12-2015", sevora, doniyor);

        // Добавление людей в генеалогическое древо
        familyTree.addPerson(rustam);
        familyTree.addPerson(boyjon);
        familyTree.addPerson(mukaddas);
        familyTree.addPerson(doniyor);
        familyTree.addPerson(sevora);
        familyTree.addPerson(samiy);

        // Вариант 1: Получение и вывод всех детей выбранного человека
        System.out.println("Вариант 1: Дети Дониёра");
        List<Person> childrenOfDoniyor = familyTree.getChildren(doniyor);
        for (Person child : childrenOfDoniyor) {
            System.out.println(child.getName());
        }

        // Вариант 2: Вывод всей информации о человеке
        System.out.println("\nВариант 2: Информация о Рустаме");
        Person person = rustam;
        System.out.println("Имя: " + person.getName());
        System.out.println("Дата рождения: " + person.getBirthDate());
        System.out.println("Мать: " + (person.getMother() != null ? person.getMother().getName() : "Нет данных"));
        System.out.println("Отец: " + (person.getFather() != null ? person.getFather().getName() : "Нет данных"));
    }
}
