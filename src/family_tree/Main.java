package family_tree;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(); // Новое древо

        Human human1 = new Human("John", Gender.Male, LocalDate.of(1965, 12, 10)); // Реализую людей
        Human human2 = new Human("Mary", Gender.Female, LocalDate.of(1967, 4, 22));
        Human human3 = new Human("Peter", Gender.Male, LocalDate.of(1990, 3, 27), human1, human2);

        human1.addChild(human3.getName());   // Добавляю имени детей человека (хотел добавить полностью весь список людей, но Java выдавал ошибку)
        human2.addChild(human3.getName());

        familyTree.addHuman(human1);
        familyTree.addHuman(human2); // Добавляю людей в семейное дерево
        familyTree.addHuman(human3);

        System.out.println(familyTree.toString()); // Вывод
    }
}
