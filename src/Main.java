import familytree.human.Human;
import familytree.human.Gender;
import familytree.family_tree.FamilyTree;
import familytree.util.FileHandler;

import java.time.LocalDate;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
       
        Human grandparent = new Human("Prohor", Gender.Male, LocalDate.of(1949, 5, 21));
        Human parent1 = new Human("Alice", Gender.Female, LocalDate.of(1973, 8, 15));
        Human parent2 = new Human("Ignat", Gender.Male, LocalDate.of(1975, 1, 22) );
        Human child1 = new Human("Alla", Gender.Female, LocalDate.of(2003, 11, 10));
        Human child2 = new Human("Diana", Gender.Female, LocalDate.of(2005, 6, 4));
        
        grandparent.addChild(parent1);
        grandparent.addChild(parent2);
        parent1.addChild(child1);
        parent2.addChild(child2);

        parent1.addParent(grandparent);
        parent2.addParent(grandparent);
        child1.addParent(parent1);
        child2.addParent(parent2);

        familyTree.addHuman(grandparent);
        familyTree.addHuman(parent1);
        familyTree.addHuman(parent2);
        familyTree.addHuman(child1);
        familyTree.addHuman(child2);

        System.out.println("Family Tree: \n" + familyTree.toString());

        saveTree(familyTree);        

        FamilyTree loadedTree = readTree();
        if (loadedTree != null) {
            System.out.println("Loaded tree from file:");
            System.out.println(loadedTree.toString());
        }

         // Сортировка по имени
         loadedTree.sortByName();
         System.out.println("Sorted tree by name:");
         System.out.println(loadedTree.toString());

         // Сортировка по дате рождения
         loadedTree.sortByAge();
         System.out.println("Sorted tree by age:");
         System.out.println(loadedTree.toString());

        // Вывод элементов дерева с использованием цикла for/each 
        //  System.out.println("Вывод элементов дерева с использованием цикла for/each");        
        //  for (Human human : familyTree) {
        //     System.out.println(human);
        // }
    }

    // Запись в файл
    private static void saveTree(FamilyTree tree) {
        FileHandler fileHandler = new FileHandler();        
        fileHandler.writeToFile(tree);
        System.out.println("Family tree written to file\n" );
    }

    // Чтение из файла
    private static FamilyTree readTree(){
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.readFromFile();
    }
}
