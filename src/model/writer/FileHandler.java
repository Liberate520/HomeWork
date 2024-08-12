package model.writer;

import java.io.*;

public class FileHandler implements Writer {

    public String fileName = "src\\model\\Writer\\FamilyTree.txt";

    public void oos(Serializable serializable) {
        // метод сохранения состояния программы (процесс записи состояния объекта в поток - сериализация)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));) {
            System.out.printf("Файл \"%s\" успешно создан\n", fileName);
            oos.writeObject(serializable);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Object ois(Object obj) {
        // метод восстановления состояния программы (процесс восстановления состояния объекта из потока - десериализация)

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));) {
            System.out.printf("Восстановление файла \"%s\": \n", fileName);
            obj = ois.readObject();
            return obj;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
