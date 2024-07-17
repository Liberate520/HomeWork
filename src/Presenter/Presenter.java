package Presenter;

import Model.family_tree.Servise;
import Model.family_tree.human.Gender;
import View.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Servise servise;

    public Presenter(View view) {
        this.view = view;
        servise = new Servise();
    }


    public void addHuman(String name, String sexStr, LocalDate brthDate) {
        servise.addHuman(name, sexStr, brthDate);
        getTree();
    }

    public void getTree() {
        String answer = servise.GetInfoFamilyTree();
        view.printAnswer(answer);
    }

    public void sortByAge() {
        servise.SortBybrthDate();
        getTree();
    }

    public void sortByName() {
        servise.SortByName();
        getTree();
    }

    public void sortById() {
        servise.SortById();
        getTree();
    }

    public void Load() {
        servise.loadTree();
        getTree();
    }

    public void Save() {
        servise.saveTree();
    }

    public void SetSex(String name, String sexStr) {
        servise.SetSex(name, sexStr);
        getTree();
    }

    public void SetFamily(String idStr1, String idStr2) {
        servise.SetFamily(idStr2, idStr1);
        getTree();
    }

    public void setSpouse(String idStr1, String idStr2) {
        servise.SetSpouse(idStr1, idStr2);
        getTree();
    }
}
