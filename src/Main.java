public class Main {
    public static void main(String[] args) {
        // Создание экземпляра генеалогического древа
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        Person john = new Person("John", 50);
        Person jane = new Person("Jane", 48);
        Person mike = new Person("Mike", 20);
        Person anna = new Person("Anna", 18);

        // Добавление детей
        john.addChild(mike);
        john.addChild(anna);

        // Добавление людей в генеалогическое древо
        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(mike);
        familyTree.addMember(anna);

        // Проведение исследования: получение всех детей Джона
        Person parent = familyTree.findPersonByName("John");
        if (parent != null) {
            System.out.println("Children of " + parent.getName() + ":");
            for (Person child : familyTree.getChildrenOf(parent)) {
                System.out.println(child);
            }
        } else {
            System.out.println("Person not found");
        }
    }
}