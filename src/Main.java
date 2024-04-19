import java.io.File;
import java.io.IOException;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иван");
        Person person2 = new Person("Алексей");
        Person person3 = new Person("Екатерина");

        person1.addChild(person2);
        person1.addChild(person3);

        GenealogyTree tree = new GenealogyTree(person1);

        FileHandler fileHandler = new FileHandler();

        try {
            fileHandler.serialize("genealogy_tree.dat", tree);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            GenealogyTree loadedTree = (GenealogyTree) fileHandler.deserialize("genealogy_tree.dat");
            List<Person> allChildren = loadedTree.getAllChildrenOfPerson("Иван");
            for (Person child : allChildren) {
                System.out.println(child.getName());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
