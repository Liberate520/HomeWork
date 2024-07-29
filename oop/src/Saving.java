import java.io.*;

public class Saving implements Serializable {
    public void saveTree(String filepath, FamilyTree tree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(tree);
        } catch (IOException e) {
            System.out.println("Сохранение не удалось" + e.getMessage());
        }
    }

    public FamilyTree loadingTree (String filepath){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))){
            return (FamilyTree) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Загрузка не удалась " + e.getMessage());
            return null;
        }
    }
}