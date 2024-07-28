package ru.gb.familytree;


import ru.gb.familytree.model.human.Gender;
import ru.gb.familytree.model.human.Human;
import ru.gb.familytree.model.human.SomeBody;
import ru.gb.familytree.model.human.saveload.FileHandler;
import ru.gb.familytree.model.human.tree.TreeFamily;
import ru.gb.familytree.view.ConsoleUI;
import ru.gb.familytree.view.View;

public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI();
        view.start();
    }

//        TreeFamily<SomeBody> treeFamily = new TreeFamily<>();
//
//        Human irina = new Human("Ирина", 33, Gender.FEMALE);
//        Human ivan = new Human("Иван", 37, Gender.MALE);
//        Human sacha = new Human("Саша", 9, Gender.MALE);
//        Human masha = new Human("Маша", 5, Gender.FEMALE);
//        Human kira = new Human("Кира", 59, Gender.FEMALE);
//        Human egor = new Human("Егор", 62, Gender.MALE);
//        Human vera = new Human("Вера", 57, Gender.FEMALE);
//        Human valera = new Human("Валера", 63, Gender.MALE);
//
//        kira.addChild(irina);
//        egor.addChild(irina);
//        vera.addChild(ivan);
//        valera.addChild(ivan);
//        irina.addChild(sacha);
//        irina.addChild(masha);
//        ivan.addChild(sacha);
//        ivan.addChild(masha);
//
//        treeFamily.add(irina);
//        treeFamily.add(ivan);
//        treeFamily.add(sacha);
//        treeFamily.add(masha);
//        treeFamily.add(kira);
//        treeFamily.add(egor);
//        treeFamily.add(vera);
//        treeFamily.add(valera);

        //System.out.println(treeFamily.getInfo());

        //String filePatch = "src/ru/gb/familytree/saveload/tree.txt";

        //save(treeFamily, filePatch);

//        TreeFamily treeFamily = read(filePatch);
//        System.out.println(treeFamily.getListOfHumans());
//        treeFamily.sortTreeByName();
//        System.out.println(treeFamily.getListOfHumans());
//        treeFamily.sortTreeByAge();
//        System.out.println(treeFamily.getListOfHumans());
//
//    }
//
//    static void save(TreeFamily<SomeBody> treeFamily, String filePatch) {
//        FileHandler fileHandler = new FileHandler();
//        fileHandler.save(treeFamily, filePatch);
//    }
//
//    static TreeFamily read(String filePatch) {
//        FileHandler fileHandler = new FileHandler();
//        return (TreeFamily) fileHandler.read(filePatch);
//    }
}