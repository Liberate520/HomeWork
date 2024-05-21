import java.util.List;
/**
 * Главный класс приложения, содержащий точку входа для запуска программы.
 * Демонстрирует использование классов FamilyTree и Human для создания генеалогического древа.
 */
public class Main {
    public static void main(String[] args) {
        // Создание экземпляра генеалогического древа
        FamilyTree familyTree = new FamilyTree();

        // Создание членов древа
        Human person1 = new Human("Иван", Gender.MALE);
        Human person2 = new Human("Мария", Gender.FEMALE);
        Human child1 = new Human("Алексей", Gender.MALE);
        Human child2 = new Human("Ольга", Gender.FEMALE);

        // Добавление членов древа
        familyTree.addMember(person1);
        familyTree.addMember(person2);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        // Установка брачных отношений
        familyTree.setSpouse(person1, person2);

        // Установка родителей для детей
        familyTree.setParents(child1, person1, person2);
        familyTree.setParents(child2, person1, person2);

        // Получение детей выбранного человека
        List<Human> children = familyTree.getChildren(person1);
        System.out.println("Дети " + person1.getName() + ": ");
        for (Human child : children) {
            System.out.println("- " + child.getName());
        }

        // Поиск родителей, супруга, братьев/сестер выбранного человека
        Human spouse = familyTree.getSpouse(person1);
        System.out.println("Супруг(а) " + person1.getName() + ": " + spouse.getName());

        List<Human> parents = familyTree.getParents(child1);
        System.out.println("Родители " + child1.getName() + ": ");
        for (Human parent : parents) {
            System.out.println("- " + parent.getName());
        }

        List<Human> siblings = familyTree.getSiblings(child1);
        System.out.println("Братья/Сестры " + child1.getName() + ": ");
        for (Human sibling : siblings) {
            System.out.println("- " + sibling.getName());
        }

        // Сохранение и загрузка древа
        familyTree.saveToFile("family_tree.txt");
        FamilyTree loadedTree = FamilyTree.loadFromFile("family_tree.txt");
    }
}