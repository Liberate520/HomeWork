import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляров класса Person
        Person ivan = new Person(1, "Ivan");
        Person maria = new Person(2, "Maria");
        Person deti1 = new Person(3, "Deti1");
        Person deti2 = new Person(4, "Deti2");

        // Установка родителей и детей
        ivan.addChild(deti1);
        ivan.addChild(deti2);
        deti1.setFather(ivan);
        deti2.setFather(ivan);

        maria.addChild(deti1);
        maria.addChild(deti2);
        deti1.setMother(maria);
        deti2.setMother(maria);

        // Создание экземпляра класса Researcher и FamilyTree
        Researcher researcher = new Researcher();
        FamilyTree familyTree = new FamilyTree(researcher);

        // Получение всех потомков
        List<Person> descendants = familyTree.getAllDescendants(ivan);

        // Вывод потомков
        System.out.println("Descendants of Ivan:");
        for (Person descendant : descendants) {
            System.out.println(descendant.getName());
        }
    }
}
