package writer;

import java.io.*;

public class FileHandler implements Writer {

    public String fileName = "src\\Writer\\FamilyTree.txt";

    public void oos(Serializable serializable) {
        // метод сохранения состояния программы (процесс записи состояния объекта в поток - сериализация)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
//            System.out.println("---------------------------------------");  // сделать отдельный класс для вывода сообщений!
//            System.out.printf("Файл \"%s\" успешно создан", fileName);
            oos.writeObject(serializable);
//            System.out.println("\n---------------------------------------");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Object ois(Object obj) {
        // метод восстановления состояния программы (процесс восстановления состояния объекта из потока - десериализация)

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
//            System.out.println("---------------------------------------"); // сделать отдельный класс для вывода сообщений!
//            System.out.printf("Восстановление файла \"%s\": \n", fileName);
//            System.out.println("---------------------------------------");
            obj = ois.readObject();
//            System.out.println(obj);
            return obj;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
