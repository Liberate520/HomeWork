import java.time.LocalDate;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
       
        Human grandparent = new Human("Prohor", LocalDate.of(1949, 5, 21));
        Human parent1 = new Human("Alice",  LocalDate.of(1973, 8, 15));
        Human parent2 = new Human("Ignat",  LocalDate.of(1975, 1, 22));
        Human child1 = new Human("Alla",  LocalDate.of(2003, 11, 10));
        Human child2 = new Human("Diana",  LocalDate.of(2005, 6, 4));
               
        grandparent.addChild(parent1);
        grandparent.addChild(parent2);
        parent1.addChild(child1);
        parent2.addChild(child2);

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
        //System.out.println(familyTree.getAllHumans());
       //System.out.println(grandparent.getChildren());

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
