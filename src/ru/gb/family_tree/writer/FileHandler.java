package ru.gb.family_tree.writer;

import java.io.*;

public class FileHandler implements Writable{

    public boolean save(Serializable serializable, String filePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
    public Object read(String filePath) {
//        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
//            return objectInputStream.readObject();
//        } catch (Exception e){
//            e.printStackTrace();
 //           return null;
         try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
             return objectInputStream.readObject();
         } catch (FileNotFoundException e) {
             System.err.println("Файл не найден: " + e.getMessage());
         } catch (IOException | ClassNotFoundException e) {
             System.err.println("Ошибка при чтении: " + e.getMessage());
             e.printStackTrace(); // Либо используйте логирование
         }

         return null;  // Вернуть null в случае ошибки
         }
    }

