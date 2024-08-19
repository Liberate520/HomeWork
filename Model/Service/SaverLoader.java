package homeWork.Model.Service;

import java.io.IOException;

import homeWork.Model.Human.Human;
import homeWork.Model.Tree.FamilyTree;
import homeWork.Model.Writer.FileHandler;

public class SaverLoader {
    FileHandler fileHandler = new FileHandler();
    public void saveToFile(FamilyTree<Human> service, String fileName){
        try {
            fileHandler.writeToFile(service, fileName);
            System.out.println("Family tree сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения family tree: " + e.getMessage());
        }
    }

    public void loadFromFile(String fileName){
        try {
            FamilyTree loadedTree = fileHandler.readFromFile(fileName);
            System.out.println("Family tree загружен из файла:");
            System.out.println(loadedTree);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка загрузки family tree: " + e.getMessage());
        }
    }
}
