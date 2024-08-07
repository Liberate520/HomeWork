package Family_Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Family_Tree.Person> peopleTree = new FamilyTree<>();
        FamilyTree<Family_Tree.Animal> animalsTree = new FamilyTree<>();

        Family_Tree.Person john = new Family_Tree.Person("John", "Doe", Family_Tree.Person.MALE, LocalDate.of(1980, 1, 1));
        Family_Tree.Animal fido = new Family_Tree.Dog("Fido", "Golden Retriever", LocalDate.of(2015, 5, 10));

        peopleTree.addElement(john.getName(), john);
        animalsTree.addElement(fido.getName(), fido);

        peopleTree.saveToFile("people_tree.dat");
        animalsTree.saveToFile("animals_tree.dat");

        // Загрузка данных из файлов
        FamilyTree<Family_Tree.Person> loadedPeopleTree = new FamilyTree<>();
        FamilyTree<Family_Tree.Animal> loadedAnimalsTree = new FamilyTree<>();

        loadedPeopleTree.loadFromFile("people_tree.dat");
        loadedAnimalsTree.loadFromFile("animals_tree.dat");

        System.out.println("Дерево Людей:");
        System.out.println(loadedPeopleTree);

        System.out.println("Дерево Животных:");
        System.out.println(loadedAnimalsTree);
    }
}