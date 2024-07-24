package writer;

import java.io.*;

public class FileHandler implements Writer{
    //из сериализе класса в файл сохранение и загрузка данных
    @Override
    public boolean save(Serializable serializable, String filepath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filepath))) {
            objectOutputStream.writeObject(serializable);
            return true; //если файл создан

        }catch (Exception e){
            e.printStackTrace(); //вывод ошибки
            return false; //если файл не создан
        }
    }
    @Override
    public Object read(String filepath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filepath))){
            return objectInputStream.readObject();
        }catch (Exception e) {
            e.printStackTrace();
            return null; //вывод ошибки файл не найден
        }
    }
}
