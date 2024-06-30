import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание генеалогического древа
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        Person anastasiya = new Person("Анастасия", 35, "Жен");
        Person mihail = new Person("Михаил", 40, "Муж");
        Person anton = new Person("Антон", 10, "Муж");
        Person diana = new Person("Диана", 8, "Жен");
        Person varvara = new Person("Варвара", 60, "Жен");
        Person nikola = new Person("Николай", 65, "Муж");

        // Установка родственных связей
        anastasiya.addChild(anton);
        anastasiya.addChild(diana);
        mihail.addChild(anton);
        mihail.addChild(diana);
        varvara.addChild(anastasiya);
        nikola.addChild(anastasiya);

        // Добавление людей в генеалогическое древо
        familyTree.addPerson(anastasiya);
        familyTree.addPerson(mihail);
        familyTree.addPerson(anton);
        familyTree.addPerson(diana);
        familyTree.addPerson(varvara);
        familyTree.addPerson(nikola);

        // Демонстрация дерева
        System.out.println("Фамильное древо:");
        familyTree.displayTree();

        // Сохранение генеалогического древа в файл
        familyTree.saveToFile("family_tree.dat");

        // Очистка текущего дерева для демонстрации загрузки
        familyTree = new FamilyTree();

        // Загрузка генеалогического древа из файла
        familyTree.loadFromFile("family_tree.dat");

        // Демонстрация дерева после загрузки
        System.out.println("\nФамильное древо после загрузки из файла:");
        familyTree.displayTree();

        // Получение всех детей выбранного человека
        System.out.println("\nДети Анастасии:");
        List<Person> childrenOfAnastasiya = familyTree.getChildrenOf("Анастасия");
        for (Person child : childrenOfAnastasiya) {
            System.out.println(child);
        }

        // Пример поиска человека по имени
        System.out.println("\nНайти человека по имени 'Михаил':");
        Person foundPerson = familyTree.findPersonByName("Михаил");
        if (foundPerson != null) {
            System.out.println(foundPerson);
        } else {
            System.out.println("Человек не найден");
        }
    }
}