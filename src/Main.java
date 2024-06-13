
import service.Service;
import service.SortType;
import service.TreeGenerator;
import tree.FamilyTree;
import tree.FileHandler;
import tree.Writable;

import java.io.Serializable;


public class Main {
    public static void main(String[] args) {

        FamilyTree tree = createTree();
        //tree.sortByCildrenNumber();
        System.out.println(tree.getAllInfo(SortType.byAge));
        save(tree, "Gluhov_ft.dat");
        tree.saveAsHtml();


        //Service service = new Service(tree);
        //System.out.println(service.getHumanListInfo());


        //System.out.println(getChildInfo(tree.)
        /*

        tree.FamilyTree tree = read("Gluhov_ft.dat");
        System.out.println(tree.getAllInfo());

         */

    }
    public static void save(FamilyTree tree, String fileName) {
        Writable writable = new FileHandler();
        writable.save((Serializable) tree, fileName);

        //System.out.println(tree.getAllInfo());
        //save(tree, "Gluhov_ft.dat");
    }
    public static FamilyTree read(String fileName) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read((fileName));

        //tree.FamilyTree tree = (tree.FamilyTree) rw.readTree("Gluhov_ft.dat");

        //System.out.println(tree.getAllInfo());
    }
    private static FamilyTree createTree(){
        FamilyTree tree = new FamilyTree();
        /*
        human.Human polina = new human.Human("Полина", "Андроникова", LocalDate.of(1914, 12, 31),LocalDate.of(1972, 5, 15), human.Gender.Female);
        human.Human anton = new human.Human("Антон", "Пиантковский", LocalDate.of(1910, 6, 15),LocalDate.of(1943, 2, 3), human.Gender.Male);
        human.Human dariya = new human.Human("Людмила", "Пиантковская", LocalDate.of(1926, 8, 1), human.Gender.Female, polina, anton);

         */
        TreeGenerator tg = new TreeGenerator(tree, 3436);
        tree = tg.treeGenerator();
        //tree.add(polina);
        //tree.add(anton);
        //tree.add(dariya);
        return tree;
    }
}