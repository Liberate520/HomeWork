import java.time.LocalDate;

import static java.time.LocalDate.of;


public class Main {

    public static void main(String[] args) {

        String filePath = "src/tree.txt";

        Family_Tree tree = read(filePath);
        //Family_Tree tree = testTree();
        System.out.println(tree);

        save(tree, filePath);
    }

    static Family_Tree read(String filePath) {
        FailHandler failHandler = new FailHandler();
        return (Family_Tree) failHandler.read(filePath);
    }

    static void save(Family_Tree familyTree, String filePath) {
        FailHandler failHandler = new FailHandler();
        failHandler.save(familyTree, filePath);
    }

    static Family_Tree testTree() {
        Family_Tree tree = new Family_Tree();

        Human slava = new Human("Вячеслав", Gender.Male, of(1976, 3, 19));
        Human ira = new Human("Ирина", Gender.Female, of(1979, 11, 22));

        tree.add(slava);
        tree.add(ira);
        tree.setWedding(slava.getId(), ira.getId());

        Human anastasia = new Human("Анастасия", Gender.Female, of(1999, 9, 28), ira, slava);
        Human dasha = new Human("Дарья", Gender.Female, of(2003, 10, 16), ira, slava);

        tree.add(anastasia);
        tree.add(dasha);

        Human grandMother = new Human("Галина", Gender.Female, LocalDate.of(1948, 4, 15));

        tree.add(grandMother);

        System.out.println(tree);

        Writable writable = new FailHandler();


        return tree;
    }
}

//Создал древо
// Создал людей
// Создал связи между людьми и т.д.