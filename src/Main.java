
import group.model.FamilyTree;
import group.model.SaveReed.FileHandler;
import group.model.view.ConsoleUI;
import group.model.view.View;
import group.model.Human;
import group.model.Dogs;
import group.model.Gender;

import java.time.LocalDate;

import static java.awt.SystemColor.menu;


public class Main {
    public static void main(String[] args) {

        FamilyTree tree = mainTree();
        System.out.println(tree);

//        save(tree);

//        System.out.println(tree);
//        tree.sortByName();
//        System.out.println(tree);
//        tree.sortByDeathDate();


       View view = new ConsoleUI(menu);
       view.start();



    }

//    private static FamilyTree read (){
//        FileHandler fileHandler = new FileHandler();
//        String filePath = "src/group/model/Treed.md";
//        return (FamilyTree) fileHandler.read(filePath);
//    }
//
//    private static void save(FamilyTree tree){
//        FileHandler fileHandler = new FileHandler();
//        String filePath = "src/group/model/Treed.md";
//        fileHandler.save(tree,filePath);
//    }


    static FamilyTree mainTree() {
        FamilyTree tree = new FamilyTree();


        int i=0;
        Human vasya = new Human(i++, "Василий", Gender.male,  null, null, LocalDate.of(1980,6,24), null);

        Human masha = new Human( i++, "Маша", Gender.female, null, null, LocalDate.of(1985, 6, 15), null);


        tree.add(vasya);
        tree.add(masha);

//
        tree.setWedding(vasya, masha);
//
        Human lena = new Human(i++, "Лена", Gender.female, vasya, masha, LocalDate.of(2010,7,23), null);

        Human ivan = new Human(i++, "Иван", Gender.male,vasya, masha, LocalDate.of(2005, 7, 1), null);

        tree.add (lena);
        tree.add (ivan);

        Human Inna = new Human(i++, "Инна", Gender.female,null, null, LocalDate.of(1954,11,25), null);
        Inna.addChild(vasya);
        tree.add(Inna);
//

        return tree;
    }


}
