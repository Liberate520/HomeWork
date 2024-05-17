package Family_Tree.Writer;

import Family_Tree.model.FamilyTree.FamilyTree;

import java.io.*;

public class Writer implements WriteTo {
    private FamilyTree familytree;


    public void save(FamilyTree familyTree) throws IOException {
        this.familytree=familyTree;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("human.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
        /*System.out.println("Before Serialize: " + "\n" + human + "\n");*/
    }


    public void read(FamilyTree familyTree) throws IOException, ClassNotFoundException {
        this.familytree=familyTree;
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.out"));
        familytree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        /*System.out.println("After Restored: " + "\n" + human + "\n");*/
    }
}





        /*ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("human.out"));
        Human Restored = (Human) objectInputStream.readObject();
        objectInputStream.close();
*/
        //Сериализация с помощью класса ByteArrayOutputStream
        /*ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream2.writeObject(human);
        objectOutputStream2.flush();

        //Восстановление с помощью класса ByteArrayInputStream
        ObjectInputStream objectInputStream2 = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Human Restored = (Human) objectInputStream2.readObject();
        objectInputStream2.close();*/


