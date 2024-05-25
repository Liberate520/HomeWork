package familytree.io;

import com.familytree.utis.Writeable;

import java.io.*;

public class FileHandler implements Writeable {





    ////    @Override
////    public void writeToFile(T obj, String filename) throws IOException {
////        try (FileOutputStream fileOut = new FileOutputStream(filename);
////             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
////            out.writeObject(obj);
////        }
////    }
////
////    @Override
////    public T readFromFile(String filename) throws IOException, ClassNotFoundException {
////        try (FileInputStream fileIn = new FileInputStream(filename);
////             ObjectInputStream in = new ObjectInputStream(fileIn)) {
////            return (T) in.readObject();
////        }
////    }
    @Override
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true ;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}









//import java.io.*;
//
//public class FileHandler implements Writeable {
//
//    @Override
//    public <T> void writeToFile(T obj, String filename) throws IOException {
//        try (FileOutputStream fileOut = new FileOutputStream(filename);
//             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
//            out.writeObject(obj);
//        }
//    }
//
//    @Override
//    public <T> T readFromFile(String filename) throws IOException, ClassNotFoundException {
//        try (FileInputStream fileIn = new FileInputStream(filename);
//             ObjectInputStream in = new ObjectInputStream(fileIn)) {
//            return (T) in.readObject();
//        }
//    }
//}







//    public Object read(String filePath) {
//        System.out.println("Чтение файла: " + filePath);
//        Object result = null;
//
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
//            result = objectInputStream.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Результат чтения: " + result);
//        return result;
//    }
//
//    public void save(Object object, String filePath) {
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
//            objectOutputStream.writeObject(object);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}





