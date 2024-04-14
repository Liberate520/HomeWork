package Family_Tree;
import java.io.*;
import java.time.LocalDate;

public class Main {
    public Main() throws IOException {
    }
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = testFamilyTree();
        System.out.print(tree);
    }
    static FamilyTree testFamilyTree()throws IOException, ClassNotFoundException {
        FamilyTree tree = new FamilyTree();

        Human Ivan = new Human("Василий", Gender.Male, LocalDate.of(1978, 9, 4));
        tree.add(Ivan);
        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("human.out"));
        objectOutputStream.writeObject(Ivan);
        objectOutputStream.close();

        // Востановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.out"));
        Human IvanRestored = (Human) objectInputStream.readObject();
        objectInputStream.close();
        return tree;
    }
}
