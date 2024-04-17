package re.zip.famely_tree;
import re.zip.famely_tree.humans.Human;

import java.time.LocalDate;
import java.util.logging.FileHandler;

import re.zip.famely_tree.famely_tree.FamelyTree;
import re.zip.famely_tree.humans.Gender;

public class Main {
    public static void main(String[] args) {
        

        String filePath = "src/re/zip/famely_tree/writer/tree.sav";

        //загружаем
        //FamelyTree tree = readFromFile(filePath);


        FamelyTree tree = simpleTree();
        System.out.println(tree);

        //сохраняем
        saveToFile(tree, filePath);
    }

    static FamelyTree readFromFile(String filePath){
        FileHandler fileHandler = new FileHandler();
        return (FamelyTree) fileHandler.readFromFile(filePath);
    }

    static void saveToFile(FamelyTree tree, String filePath){
        FileHandler fileHandler = new FileHandler();
        fileHandler.saveToFile(tree, filePath);
    }

    
    static FamelyTree simpleTree() {

        FamelyTree tree = new FamelyTree();

        Human viktor = new Human("Виктор", "Кондрухов", LocalDate.of(1936, 1, 1), Gender.Male);
        Human lev = new Human("Лев", "Бор", LocalDate.of(1930, 1, 1), Gender.Male);
        Human irina = new Human("Ирина", "Кондрухова", LocalDate.of(1952, 6, 29), null, Gender.Female, null, viktor);
        Human evgenij = new Human("Евгений", "Бор", LocalDate.of(1952, 4, 16), null, Gender.Male, null, lev);
        Human andrej1 = new Human("Андрей", "Бор", LocalDate.of(1977, 8, 19), null, Gender.Male, irina, evgenij);
        Human pavel = new Human("Павел", "Бор", LocalDate.of(1979, 6, 29), null, Gender.Male, irina, evgenij);
       
        tree.addToFamely(viktor);
        tree.addToFamely(lev);
        tree.addToFamely(irina);
        tree.addToFamely(evgenij);
        tree.setWeddding(irina, evgenij, "Шапиро");
        tree.addToFamely(andrej1);
        tree.addToFamely(pavel);

        return tree;

    }
}
