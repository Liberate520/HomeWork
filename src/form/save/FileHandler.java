package form.save;

import java.io.*;

public class FileHandler implements Writable {

//    public boolean forms.human.save(FamilyTree tree, String filePath){
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
//            objectOutputStream.writeObject(tree);
//            return true;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }

    @Override
    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath){
        try (ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream(filePath)))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public void forms.human.save(FamilyTree tree, String filePath) {
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
//            Object serializable = null;
//            objectOutputStream.writeObject(serializable);
////            return true;
//        } catch (Exception e){
//            e.printStackTrace();
////            return false;
//        }
//    }
}