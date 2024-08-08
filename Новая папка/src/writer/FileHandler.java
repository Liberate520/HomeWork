package writer;

import java.io.*;

public class FileHandler implements Writer {
    public  String treePath = "src/writer/tree.txt";

    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
            new FileOutputStream(treePath));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();


//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
//            new FileOutputStream(treePath))){
//
//            objectOutputStream.writeObject(serializable);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(treePath));
        Object object = objectInputStream.readObject();
        return object;

//        try (ObjectInputStream objectInputStream = new ObjectInputStream(
//                new FileInputStream(treePath))) {
//            Object object = objectInputStream.readObject();
//            return object;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
    }
}


