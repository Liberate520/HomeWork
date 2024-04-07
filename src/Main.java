import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();


        Human human1 = new Human("Иван", Gender.Мужской, LocalDate.of(1928, 5, 15));
        Human human2 = new Human("Мария", Gender.Женский, LocalDate.of(1929, 10, 13));
        Human human3 = new Human("Сергей", Gender.Мужской, LocalDate.of(1957, 5, 15));
        Human human4 = new Human("Федор", Gender.Мужской, LocalDate.of(1984, 7, 9));
        Human human5 = new Human("Светлана", Gender.Женский, LocalDate.of(1985, 3, 8));
        Human human6 = new Human("Василий", Gender.Мужской, LocalDate.of(1988, 12, 12));

        human1.setDod(LocalDate.of(2013, 10, 19));
        human3.setFather(human1);
        human3.setMother(human2);
        human4.setFather(human3);
        human5.setFather(human2);
        human1.addChildren(human3);
        human2.addChildren(human3);
        human3.addSpouse(human5);


        tree.addHumantoTree(human1);
        tree.addHumantoTree(human2);
        tree.addHumantoTree(human3);
        tree.addHumantoTree(human4);
        tree.addHumantoTree(human5);
        tree.addHumantoTree(human6);
        //System.out.println(tree);

        //записываем в файл
        String filePath = "MyFamilyTree.txt";
        FileHandler fileHandler = new FileHandler();
        boolean saveResult = fileHandler.save(tree, filePath);
        if (saveResult) {
            System.out.println("FamilyTree saved in a file successfully");
        } else {
            System.out.println("FamilyTree saved in a file successfully");
        }

        //достаём из файла
        FamilyTree readResult = fileHandler.read(filePath);
        if (readResult != null) {
            System.out.println("Объект успешно прочитан из файла");
            System.out.println(readResult);
        } else {
            System.out.println("Ошибка при чтении объекта из файла");
        }
    }
}
