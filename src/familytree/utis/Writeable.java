package familytree.utis;

import java.io.Serializable;

//public interface Writeable {
////    void writeToFile(T obj, String filename) throws IOException;
////    T readFromFile(String filename) throws IOException, ClassNotFoundException;
////    boolean save(Serializable serializable, String filePath);
//
//    //    @Override
//    //    public void writeToFile(T obj, String filename) throws IOException {
//    //        try (FileOutputStream fileOut = new FileOutputStream(filename);
//    //             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
//    //            out.writeObject(obj);
//    //        }
//    //    }
//    //
//    //    @Override
//    //    public T readFromFile(String filename) throws IOException, ClassNotFoundException {
//    //        try (FileInputStream fileIn = new FileInputStream(filename);
//    //             ObjectInputStream in = new ObjectInputStream(fileIn)) {
//    //            return (T) in.readObject();
//    //        }
//    //    }
////    boolean save(Serializable serializable, String filePath);
//
//    //    @Override
//    //    public void writeToFile(T obj, String filename) throws IOException {
//    //        try (FileOutputStream fileOut = new FileOutputStream(filename);
//    //             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
//    //            out.writeObject(obj);
//    //        }
//    //    }
//    //
//    //    @Override
//    //    public T readFromFile(String filename) throws IOException, ClassNotFoundException {
//    //        try (FileInputStream fileIn = new FileInputStream(filename);
//    //             ObjectInputStream in = new ObjectInputStream(fileIn)) {
//    //            return (T) in.readObject();
//    //        }
//    //    }
//    default boolean save(Serializable serializable, String filePath) {
//        return false;
//    }
//
//    Object read(String filePath);
//
//}

//public interface Writeable {
//    void save(Object obj, String filePath);
//    Object read(String filePath);
//}

//public class FileHandler implements Writeable {
//
//    @Override
//    public void save(Object obj, String filePath) {
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
//            oos.writeObject(obj);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Object read(String filePath) {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
//            return ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}


//public interface Writeable {
//    <T> void writeToFile(T obj, String filename) throws IOException;
//    <T> T readFromFile(String filename) throws IOException, ClassNotFoundException;
//}


public  interface Writeable {


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
    boolean save(Serializable serializable, String filePath);

    Object read(String filePath);
}



