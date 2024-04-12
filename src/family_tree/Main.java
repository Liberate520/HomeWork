package family_tree;

import java.time.LocalDate;
import family_tree.human.Human;
import family_tree.human.Gender;
import family_tree.writer.FileHandler;
import family_tree.family_tree.*;

public class Main {
    public static void main(String[] args) {
        FileHandler handler = new FileHandler();
        String filePath = "src/family_tree/writer/myfamily.txt";
        
        FamilyTree<Human> tree = read(filePath);
        // FamilyTree<Human> tree = myTree();
        System.out.println("Дерево до сортировки:");
        System.out.println(tree);

        tree.sortName();
        System.out.println("Отсортированное дерево по имени:");
        for (Human human : tree) {
            System.out.println(human.getInfo());
        }

        tree.sortBirthday();
        System.out.println();
        System.out.println("Отсортированное дерево по возрасту:");
        for (Human human : tree) {
            System.out.println(human.getInfo());
        }

        handler.save(tree, filePath);
        
    }

    static FamilyTree<Human> read(String filePath) {
        FileHandler handler = new FileHandler();
        return handler.read(filePath);
    }

    static FamilyTree<Human> myTree() {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1985, 5, 5));
        Human olga = new Human("Ольга", Gender.Female, LocalDate.of(1984, 8, 16));
        tree.add(ivan);
        tree.add(olga);
        tree.setWedding(ivan, olga);

        Human igor = new Human("Игорь", Gender.Male, LocalDate.of(2011, 10, 9), ivan, olga);
        Human alena = new Human("Алена", Gender.Female, LocalDate.of(2015, 7, 1), ivan, olga);
        Human lera = new Human("Лера", Gender.Female, LocalDate.of(2021, 9, 10), ivan, olga);
        tree.add(igor);
        tree.add(alena);
        tree.add(lera);

        Human grandMother1 = new Human("Марина", Gender.Female, LocalDate.of(1958, 3, 7));
        grandMother1.addChild(olga);
        Human grandMother2 = new Human("Ирина", Gender.Female, LocalDate.of(1957, 10, 16));
        grandMother2.addChild(ivan);
        tree.add(grandMother1);
        tree.add(grandMother2);

        return tree;
    }

}
