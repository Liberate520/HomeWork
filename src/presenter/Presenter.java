package presenter;

import model.FamilyTree;
import model.Human;
import view.View;


public class Presenter<T extends Human>{
    View view;
    FamilyTree familyTree;

    public Presenter(View view, FamilyTree familyTree) {
        this.view = view;
        this.familyTree = familyTree;

    }
    public void getAllHuman(){
        String allHumans = familyTree.getAllHuman().toString();
        System.out.println(allHumans);
    }

    public void getHumanByName(String nameOfHuman) {
        Human foundHuman = familyTree.getHumanByName(nameOfHuman);
        if (foundHuman != null) {
            System.out.println(foundHuman.toString());
        } else {
            System.out.println("Человек с таким именем не найден.");
        }
    }


    public void sortByAge(){

        familyTree.sortByAge();
        System.out.println(familyTree.getAllHuman());
    }

    public void sortByName(){
        familyTree.sortByName();
        System.out.println(familyTree.getAllHuman());
    }

}


