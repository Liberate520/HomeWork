package lv.homeWork.presenter;

import lv.homeWork.model.FamilyTree;
import lv.homeWork.model.Gender;
import lv.homeWork.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTree familyTree;


    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree<>();
    }

    public void addHuman(Integer passportID, String name, Gender gender, LocalDate dateOfBirth){
        familyTree.addHuman(passportID,name,gender,dateOfBirth);
        showList();
    }

    public void findHumanByName(String fullname){
        familyTree.findHumanByName(fullname);
        showList();
    }

    public void sortByAge(){
        familyTree.sortByBrith();
        showList();

    }

    public void showList(){
        String info = familyTree.getInfo();
        view.getAnswer(info);
    }

    public void sortByGen(){
        familyTree.sortByGen();
        showList();
    }


}