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

        // ... (код создания связей остается без изменений)

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

        // Сохранение дерева в файл
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, "family_tree.ser");

        // Загрузка дерева из файла
        FamilyTree loadedTree = fileHandler.load("family_tree.ser");

        if (loadedTree != null) {
            Research loadedResearch = new Research(loadedTree);
            System.out.println("\nДети отца (после загрузки из файла):");
            List<Person> loadedFatherChildren = loadedResearch.findChildren(
                    loadedTree.getAllPeople().stream()
                            .filter(p -> "Отец".equals(p.getName()))
                            .findFirst()
                            .orElse(null)
            );
            for (Person child : loadedFatherChildren) {
                System.out.println(child);
            }
        }
    }
}