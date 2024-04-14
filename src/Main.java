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

        static FamilyTree testFamilyTree() throws IOException, ClassNotFoundException {
            FamilyTree tree = new FamilyTree();

            Human Ivan = new Human("Василий", Gender.Male, LocalDate.of(1978, 9, 4));
            tree.add(Ivan);
            writeTo(Ivan);
            return tree;
        }

        public static void writeTo(Family_Tree.Human human) throws IOException, ClassNotFoundException {
            //АЛТЕРНАТИВА
        /*ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("human.out"));
        objectOutputStream.writeObject(human);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.out"));
        human = (Human) objectInputStream.readObject();
        objectInputStream.close();*/

            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("human.out"));
            Family_Tree.Human Restored = (Family_Tree.Human) objectInputStream.readObject();
            objectInputStream.close();

            //Сериализация с помощью класса ByteArrayOutputStream
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream2.writeObject(human);
            objectOutputStream2.flush();

            //Восстановление с помощью класса ByteArrayInputStream
            ObjectInputStream objectInputStream2 = new ObjectInputStream(
                    new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            Family_Tree.Human RestoredFromByte = (Family_Tree.Human) objectInputStream2.readObject();
            objectInputStream2.close();


            System.out.println("Before Serialize: " + "\n" + human + "\n");
            System.out.println("After Restored From Byte: " + "\n" + RestoredFromByte + "\n");
            System.out.println("After Restored: " + "\n" + Restored + "\n");


        }
    }
}
