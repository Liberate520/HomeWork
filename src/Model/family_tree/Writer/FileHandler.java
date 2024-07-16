package Model.family_tree.Writer;

import java.io.*;

public class FileHandler implements Writer{

        //метод сохранения метод загрузки

    @Override
    public  void Save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Desktop\\Cемейное древо.txt"))) {
            objectOutputStream.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
            public  Object Load() {

                try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Desktop\\Cемейное древо.txt"))) {
                    Object object = objectInputStream.readObject();
                    return object;
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }




