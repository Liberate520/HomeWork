import family.FamilyTree;
import file_handler.DataHandler;
import human.Gender;
import human.Human;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        FamilyTree tree = testTree();

        DataHandler dataHandler = new DataHandler(tree);

        String name = "family.txt";

        dataHandler.saveToFile(name);

        dataHandler.loadFromFile(name);

        DataHandler loadedHandler = new DataHandler(null); // Создаем пустой объект file_handler.DataHandler
        loadedHandler.loadFromFile(name);

        // Выведите содержимое загруженного объекта на консоль
        FamilyTree loadedTree = loadedHandler.getTree();

        System.out.println(dataHandler.getTree());

        System.out.println(loadedTree);
    }
    private static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human human1 = new Human();
        human1.setName("Mike");
        human1.setGender(Gender.MALE);
        human1.setBirthDate(LocalDate.of(1967,5,6));
        human1.setDeathDate(LocalDate.of(2015, 4,25));

        Human human2 = new Human("Lola", Gender.FEMALE, LocalDate.of(1969,11, 9));

        tree.addHuman(human1);
        tree.addHuman(human2);
        tree.setWedding(human1, human2);

        Human human3 = new Human("Sara", Gender.FEMALE, LocalDate.of(1991, 1,5), human2, human1);
        Human human4 = new Human("Tara", Gender.FEMALE, LocalDate.of(1998, 1,5), human2, human1);

        tree.addHuman(human3);
        tree.addHuman(human4);

        Human grandmother = new Human("Larisa", Gender.FEMALE, LocalDate.of(1947, 9, 17));
        grandmother.setChildren(human1);

        tree.addHuman(grandmother);

        return tree;
    }
}
