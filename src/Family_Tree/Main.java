package Family_Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> peopleTree = new FamilyTree<>();
        FamilyTree<Dog> dogsTree = new FamilyTree<>();

        Person john = new Person("John", Person.MALE, LocalDate.of(1980, 1, 1));
        Dog fido = new Dog("Fido", "Golden Retriever", LocalDate.of(2015, 5, 10));

        peopleTree.addElement(john.getName(), john);
        dogsTree.addElement(fido.getName(), fido);

        peopleTree.saveToFile("people_tree.dat");
        dogsTree.saveToFile("dogs_tree.dat");

        // Загрузка данных из файлов
        FamilyTree<Person> loadedPeopleTree = new FamilyTree<>();
        FamilyTree<Dog> loadedDogsTree = new FamilyTree<>();

        loadedPeopleTree.loadFromFile("people_tree.dat");
        loadedDogsTree.loadFromFile("dogs_tree.dat");

        System.out.println("People Tree:");
        System.out.println(loadedPeopleTree);

        System.out.println("Dogs Tree:");
        System.out.println(loadedDogsTree);
    }
}