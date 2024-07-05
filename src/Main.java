import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создание объектов людей
        Human grandfather = new Human(1, "Алексей Петров", LocalDate.of(1940, 1, 1), null, Gender.Male, null, null);
        Human grandmother = new Human(2, "Екатерина Петрова", LocalDate.of(1945, 1, 1), null, Gender.Famale, null,
                null);
        Human father = new Human(3, "Иван Петров", LocalDate.of(1965, 1, 1), null, Gender.Male, grandfather,
                grandmother);
        Human mother = new Human(4, "Мария Петрова", LocalDate.of(1970, 1, 1), null, Gender.Famale, null, null);
        Human uncle = new Human(5, "Николай Петров", LocalDate.of(1968, 1, 1), null, Gender.Male, grandfather,
                grandmother);
        Human aunt = new Human(6, "Светлана Петрова", LocalDate.of(1972, 1, 1), null, Gender.Famale, grandfather,
                grandmother);
        Human child1 = new Human(7, "Алексей Иванов", LocalDate.of(1990, 1, 1), null, Gender.Male, father, mother);
        Human child2 = new Human(8, "Анна Иванова", LocalDate.of(1992, 1, 1), null, Gender.Famale, father, mother);
        Human cousin1 = new Human(9, "Петр Николаев", LocalDate.of(1995, 1, 1), null, Gender.Male, uncle, null);
        Human cousin2 = new Human(10, "Дарья Николаева", LocalDate.of(1998, 1, 1), null, Gender.Famale, uncle, null);

        // Добавление детей к родителям
        grandfather.addChild(father);
        grandfather.addChild(uncle);
        grandfather.addChild(aunt);
        grandmother.addChild(father);
        grandmother.addChild(uncle);
        grandmother.addChild(aunt);

        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);

        uncle.addChild(cousin1);
        uncle.addChild(cousin2);

        // Создание дерева и добавление людей в дерево
        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(grandfather);
        familyTree.addHuman(grandmother);
        familyTree.addHuman(father);
        familyTree.addHuman(mother);
        familyTree.addHuman(uncle);
        familyTree.addHuman(aunt);
        familyTree.addHuman(child1);
        familyTree.addHuman(child2);
        familyTree.addHuman(cousin1);
        familyTree.addHuman(cousin2);


        //  // Вывод детей Ивана Иванова
        //  System.out.println("Дети Ивана Иванова:");
        //  for (Human child : familyTree.getChildren(1)) {
        //      System.out.println(child.getName());
        //  }

        // Печать всего дерева
        familyTree.printTree();
    }
}
