import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        String filePath = "src/family.txt";

        FamilyTree tree = read(filePath);
        // FamilyTree tree = myTree();
        System.out.println(tree);

        handler.save(tree, filePath);

    }

    static FamilyTree read(String filePath) {
        FileHandler handler = new FileHandler();
        return (FamilyTree) handler.read(filePath);
    }

    static FamilyTree myTree() {
        FamilyTree tree = new FamilyTree();

        // заполнить своими данными

        return tree;
    }
}
