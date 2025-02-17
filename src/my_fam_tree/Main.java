package my_fam_tree;

import my_fam_tree.model.FamTreeOper;
import my_fam_tree.model.FamilyTree;
import my_fam_tree.model.Human;

import my_fam_tree.presenter.FamTreePres;
import my_fam_tree.service.FamTreeMan;
import my_fam_tree.service.FamTreeSer;
import my_fam_tree.service.FileHandler;
import my_fam_tree.service.HumanFact;
import my_fam_tree.view.FamTreeView;
import my_fam_tree.view.UserFamTreeView;


public class Main {
    public static void main (String[] args) {
        System.setProperty("file.encoding","UTF-8");
        System.setProperty("console.encoding","UTF-8");

        FamTreeOper<Human> familyTree = new FamilyTree<>();
        HumanFact humanFact = new HumanFact();
        FamTreeSer service = new FamTreeSer(familyTree, humanFact);
        FamTreeView view = new UserFamTreeView();
        FileHandler fileOps = new FileHandler();
        FamTreeMan fileMan = new FamTreeMan(fileOps);

        FamTreePres presenter = new FamTreePres(service, view, fileMan);

        presenter.run();
    }
}