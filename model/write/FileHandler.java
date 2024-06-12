package OOP.SemDZ.homeWork.model.write;

import java.io.*;

public class FileHandler implements Writables {

        public boolean save(Serializable serializable){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\korpa\\Documents\\Разработчик\\Java\\OOP\\SemDZ\\homeWork\\model\\write\\tree.data"))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\korpa\\Documents\\Разработчик\\Java\\OOP\\SemDZ\\homeWork\\model\\write\\tree.data"))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
}
