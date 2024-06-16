package FamTree.presenter;

import FamTree.model.ft.FamilyTree;
import FamTree.model.ft.human.Human;
import FamTree.view.View;

public class Presenter {
    private FamilyTree familyTree;
    private View view;

    public Presenter(View view) {
        this.view = view;
        this.familyTree = new FamilyTree();
    }

    public void addItem(Human human) {
        familyTree.add(human);
    }

    public void getItemList(long id){
        familyTree.getById(id);
    }
    public void getItemListName(String name){
        familyTree.getByName(name);
    }

    public void getItemListAge(){
        familyTree.getInfo();
    }

}
