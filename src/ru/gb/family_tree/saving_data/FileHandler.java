package ru.gb.family_tree.saving_data;

// import java.io.ByteArrayInputStream;
// import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ru.gb.family_tree.tree.FamilyTree;

public class FileHandler implements Writable {

    public FileHandler(Object obj) {

    }

    @Override
    public void write_object(Object obj, String target) throws FileNotFoundException, IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(target));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree read_object(String target) throws FileNotFoundException, IOException, ClassNotFoundException { 
        Object obj;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(target));
        obj = objectInputStream.readObject();
        objectInputStream.close();
        return (FamilyTree) obj;
    }

}




















    // // @Override
    // // public void write_object(Object obj, String target) throws
    // // FileNotFoundException, IOException {
    // // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    // // ObjectOutputStream objectOutputStream2 = new
    // // ObjectOutputStream(byteArrayOutputStream);
    // // objectOutputStream2.writeObject(igor);
    // // objectOutputStream2.flush();

    // // // Восстановление с помощью класса ByteArrayInputStream
    // // ObjectInputStream objectInputStream2 = new ObjectInputStream(
    // // new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
    // // Person igorRestoredFromByte = (Person) objectInputStream2.readObject();
    // // Person renatRestoredFromByte = (Person) objectInputStream2.readObject();
    // // objectInputStream2.close();

    // // }

    // // } // return дерево

    // // ByteArrayInputStream(byte[] buf)
    // // ByteArrayInputStream(byte[] buf, int offset, int length)

    // // import java.io.*;

    // // public class Program {

    // // public static void main(String[] args) {


    // @Override
    // public void read_object(Object obj, String target) throws FileNotFoundException, IOException, ClassNotFoundException {
    //     ObjectInputStream objectInputStream = new ObjectInputStream(
    //         new FileInputStream(target));
    //     this.obj = objectInputStream.readObject();
    //     objectInputStream.close();
    // // throw new UnsupportedOperationException("Unimplemented method 'read_object'");        

    // // byte[] array1 = new byte[] { 1, 3, 5, 7 };
    // ByteArrayInputStream byteStream1 = new ByteArrayInputStream((byte[]) obj);
    // int b;
    // while((b=byteStream1.read())!=-1)
    // {
    //     System.out.println(b);
    // }

    // String text = "Hello world!";
    // byte[] array2 = text.getBytes();
    // // считываем 5 символов
    // ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 0, 5);
    // int c;while((c=byteStream2.read())!=-1)
    // {
    //     System.out.println((char) c);
    // }
    // // }
    // // }

    // // ByteArrayOutputStream()
    // // ByteArrayOutputStream(int size)

    // // import java.io.*;

    // // public class Program {

    // // public static void main(String[] args) {

    // // ByteArrayOutputStream baos = new ByteArrayOutputStream();
    // // String text = "Hello Wolrd!";
    // // byte[] buffer = text.getBytes();
    // // try{
    // // baos.write(buffer);
    // // }
    // // catch(Exception ex){

    // // System.out.println(ex.getMessage());
    // // }
    // // // превращаем массив байтов в строку
    // // System.out.println(baos.toString());

    // // // получаем массив байтов и выводим по символьно
    // // byte[] array = baos.toByteArray();
    // // for(byte b: array){

    // // System.out.print((char)b);
    // // }
    // // System.out.println();
    // // }
    // // }

    //     @Override
    //     public void write_object(Object obj, String target) throws
    //     FileNotFoundException, IOException {
    //     // ObjectOutputStream objectOutputStream = new ObjectOutputStream(
    //     // new FileOutputStream("family_tree.out"));
    //     // objectOutputStream.writeObject(obj);
    //     // objectOutputStream.close();
    //     // }
    //     ByteArrayOutputStream baos = new ByteArrayOutputStream();
    //     // String text = "Hello Wolrd!";
    //     byte[] buffer = ((String) obj).getBytes(); //text.getBytes()
    //     try{
    //         baos.write(buffer);
    //     }
    //     catch(Exception ex){
    //         System.out.println(ex.getMessage());
    //     }
    //     try(FileOutputStream fos = new FileOutputStream("family_tree.out")){
    //         baos.writeTo(fos);
    //     }
    //     catch(IOException e){
    //         System.out.println(e.getMessage());
    //     }

    //     }
    // }        




// /// *** РЕШЕНИЕ ПРЕПОДАВАТЕЛЯ *** ///
// import java.io.*;

// public class FileHandler implements Writable {
    
//     public boolean save(Serializable serializable, String filePath) {
//         try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
//             objectOutputStream.writeObject(serializable);
//             return true;
//         } catch (Exception e) {
//             e.printStackTrace();
//             return false;
//         }
//     }

//     public Object read(String filePath) {
//         try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
//             return objectInputStream.readObject();
//         } catch (Exception e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
    
// }