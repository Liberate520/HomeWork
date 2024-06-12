package seminar2.Service;

import java.io.*;

public class FileHandler implements Writable{
    //метод сохранения и загрузки


    @Override
    public void save(Serializable stream, String path) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))){
            out.writeObject(stream);
        }catch (Exception e){
            System.out.println("Во время сериализации что-то пошло не так " + e);
        }

    }

    @Override
    public Object load(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        return objectInputStream.readObject();

    }
}
