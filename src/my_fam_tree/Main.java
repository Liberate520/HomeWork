package my_fam_tree;

import my_fam_tree.model.FamilyTree;
import my_fam_tree.model.Human;
import my_fam_tree.presenter.FamTreePres;
import my_fam_tree.view.UserFamTreeView;

public class Main {
    public static void main (String[] args) {
        System.setProperty("file.encoding","UTF-8");
        System.setProperty("console.encoding","UTF-8");
        FamilyTree<Human> model = new FamilyTree<>();
        UserFamTreeView view = new UserFamTreeView();
        FamTreePres presenter = new FamTreePres(model, view);

        presenter.run();
    }
}