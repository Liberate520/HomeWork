package familytree;

import familytree.model.familytree.FamilyTree;
import familytree.model.filehandler.FileHandler;
import familytree.model.human.Human;
import familytree.model.service.Service;
import familytree.view.ConsoleUI;
import familytree.view.View;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //String filePath = "/Users/ramilbagirov/Desktop/Murad/GeekBrains/git_education/Git_Java/homeWork/src/familytree/tree.txt";
        //Service<Human> service = testTreeHuman();
        View view = new ConsoleUI();
        view.start();

    }


//        static void save(Service<Human> service, String filePath) {
//            FileHandler fileHandler = new FileHandler();
//            fileHandler.save(service, filePath);
//        }

//       static Service<Human> read(String filePath) {
//            FileHandler fileHandler = new FileHandler();
//            return (Service<Human>) fileHandler.read(filePath);
//    }


    }