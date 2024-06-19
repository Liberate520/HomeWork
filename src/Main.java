
import model.tree.SortType;
import model.service.TreeGenerator;
import model.tree.FamilyTree;
import model.tree.FileHandler;
import model.tree.Writable;
import view.ConsoleUI;
import view.View;

import java.io.Serializable;

import static model.service.Service.createTree;


public class Main {
    public static void main(String[] args) {

        FamilyTree tree = createTree();
        //model.tree.sortByCildrenNumber();
        //System.out.println(tree.getAllInfo(SortType.byAge));
        //save(tree, "Gluhov_ft.dat");
        //tree.saveAsHtml();


        //Service model.service = new Service(model.tree);
        //System.out.println(model.service.getHumanListInfo());


        //System.out.println(getChildInfo(model.tree.)
        /*

        model.tree.FamilyTree model.tree = read("Gluhov_ft.dat");
        System.out.println(model.tree.getAllInfo());

         */
        //model.tree.FamilyTree model.tree = read("Gluhov_ft.dat");
        View view = new ConsoleUI();
        view.start();


    }

}


