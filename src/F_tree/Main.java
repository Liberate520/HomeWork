package F_tree;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person grandpa = new Person("Дедушка", "мужской");
        Person grandma = new Person("Бабушка", "женский");
        Person father = new Person("Отец", "мужской");
        Person mother = new Person("Мать", "женский");
        Person child1 = new Person("Ребенок1", "мужской");
        Person child2 = new Person("Ребенок2", "женский");

        grandpa.addChild(father);
        grandma.addChild(father);
        father.setFather(grandpa);
        father.setMother(grandma);

        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);

        child1.setFather(father);
        child1.setMother(mother);
        child2.setFather(father);
        child2.setMother(mother);

        familyTree.addPerson(grandpa);
        familyTree.addPerson(grandma);
        familyTree.addPerson(father);
        familyTree.addPerson(mother);
        familyTree.addPerson(child1);
        familyTree.addPerson(child2);

        Research research = new Research(familyTree);

        System.out.println("Дети отца:");
        List<Person> fatherChildren = research.findChildren(father);
        for (Person child : fatherChildren) {
            System.out.println(child);
        }
    }
}