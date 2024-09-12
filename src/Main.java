import model.Service;
import model.human.Gender;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/model.human.saver/back_up_tree.but";

    public static void main(String[] args) {
        Service serviceHuman = new Service();

        serviceHuman.addHuman("Олег", Gender.MALE, LocalDate.of(2010,11,2));
        serviceHuman.addHuman("Ольга", Gender.FEMALE, LocalDate.of(2013, 3,13));
        serviceHuman.addHuman("Георгий", Gender.MALE, LocalDate.of(1988,12,4));
        serviceHuman.addHuman("Елизавета", Gender.FEMALE, LocalDate.of(1990, 4,21));
        serviceHuman.addHuman("Потап", Gender.MALE, LocalDate.of(1960,02,3));
        serviceHuman.addHuman("Дуся", Gender.FEMALE, LocalDate.of(1965, 5,12));

        serviceHuman.printTree();


        //FamilyTree myTree = restore();
       // FamilyTree myTree = buildTree();

        //save_tree(myTree);
        /*

        System.out.println(myTree);

        myTree.sortByName();

        System.out.println(myTree);

        myTree.sortById();

        System.out.println(myTree);

        myTree.sortByBirsday();

        System.out.println(myTree);

         */


    }
    /*
    private static void save_tree(FamilyTree familyTree) {
        FileSaver fileSaver = new FileSaver();
        fileSaver.setPath(filePath);
        fileSaver.save(familyTree);
        }
        private static FamilyTree restore(){
        FileSaver fileSaver = new FileSaver();
        fileSaver.setPath(filePath);
        return (FamilyTree) fileSaver.restore();
        }


    private static FamilyTree buildTree(){
        FamilyTree tree = new FamilyTree();

        Human oleg = new Human("Олег", Gender.MALE, LocalDate.of(2010,11,2));
        Human olia = new Human("Ольга", Gender.FEMALE, LocalDate.of(2013, 3,13));
        Human zhora = new Human("Георгий", Gender.MALE, LocalDate.of(1988,12,4));
        Human lisa = new Human("Елизавета", Gender.FEMALE, LocalDate.of(1990, 4,21) );
        Human potap = new Human("Потап", Gender.MALE, LocalDate.of(1960,02,3),
                LocalDate.of(2013, 4,5));
        Human dusia = new Human("Дуся", Gender.FEMALE, LocalDate.of(1965, 5,12),
                LocalDate.of(2020, 7,23));

        tree.add(oleg);
        tree.add(zhora);
        tree.add(lisa);
        tree.add(olia);
        tree.add(potap);
        potap.addChildren(zhora);
        zhora.addParent(potap);
        zhora.addChildren(oleg);
        zhora.addChildren(olia);
        lisa.addChildren(oleg);
        lisa.addChildren(olia);
        oleg.addParent(zhora);
        oleg.addParent(lisa);
        olia.addParent(zhora);
        olia.addParent(lisa);
        zhora.setSpouse(lisa);
        tree.add(dusia);
        dusia.setSpouse(potap);
        dusia.addChildren(zhora);
        zhora.addParent(dusia);

        return tree;
    }

     */
}