package re.zip.famely_tree;

import re.zip.famely_tree.view.ConsoleUI;
import re.zip.famely_tree.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}

//        String filePath = "C:\\Users\\Asus\\IdeaProjects\\famely_tree\\src\\re\\zip\\famely_tree\\writer\\tree.sav";
//
//        //загружаем
//        // FamelyTree tree = readFromFile(filePath);
//
//        // создаем
//        FamelyTree<Human> tree = simpleTree();
//
//        System.out.println(tree);
//
//        tree.sortByFirstName();
//        System.out.println(tree);
//
//        tree.sortByFamelyName();
//        System.out.println(tree);
//
//        tree.sortByBirthDate();
//        System.out.println(tree);
//
//        //сохраняем
//        saveToFile(tree, filePath);
//    }
//
//    @SuppressWarnings("unchecked")
//    static FamelyTree<Human> readFromFile(String filePath){
//        FileHandler fileHandler = new FileHandler();
//        return (FamelyTree<Human>) fileHandler.readFromFile(filePath);
//    }
//
//    static void saveToFile(FamelyTree<Human> tree, String filePath){
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.saveToFile(tree, filePath);
//    }
//
//
//    static FamelyTree<Human> simpleTree() {
//
//        // FamelyTree tree = new FamelyTree();
//        FamelyTree<Human> tree = new FamelyTree<>();
//
//
//        Human viktor = new Human("Виктор", "Кондрухов", LocalDate.of(1936, 1, 1), Gender.Male);
//        Human lev = new Human("Лев", "Бор", LocalDate.of(1930, 1, 1), Gender.Male);
//        Human irina = new Human("Ирина", "Кондрухова", LocalDate.of(1952, 6, 29), null, Gender.Female, null, viktor);
//        Human evgenij = new Human("Евгений", "Бор", LocalDate.of(1952, 4, 16), null, Gender.Male, null, lev);
//        Human andrej1 = new Human("Андрей", "Бор", LocalDate.of(1977, 8, 19), null, Gender.Male, irina, evgenij);
//        Human pavel = new Human("Павел", "Бор", LocalDate.of(1979, 6, 29), null, Gender.Male, irina, evgenij);
//
//        tree.addToFamely(viktor);
//        tree.addToFamely(lev);
//        tree.addToFamely(irina);
//        tree.addToFamely(evgenij);
//        tree.setWeddding(irina, evgenij, "Шапиро");
//        tree.addToFamely(andrej1);
//        tree.addToFamely(pavel);
//
//        return tree;
//
//    }
