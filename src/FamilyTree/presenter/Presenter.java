package FamilyTree.presenter;

import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.human.Gender;
import FamilyTree.model.service.Service;
import FamilyTree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service = new Service();

    public Presenter(View view){
        this.view = view;
    }

    public void createFamilyTree(String name){
        service.setName(name);
    }

    public void addElement(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        service.addElement(name, gender, birthDate, deathDate);
    }

    public void viewFamilyTree(){
        service.viewFamilyTree();
    }

    public void setWedding(long item1, long item2){
        service.setWadding(item1, item2);
    }
}
