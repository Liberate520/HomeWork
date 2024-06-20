package project.Main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import project.Members.Gender;
import project.Members.Human;
import project.Presenter.FamilyTreePresenter;
import project.Presenter.FamilyTreePresenterImpl;
import project.View.FamilyTreeConsoleView;
import project.View.FamilyTreeView;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView view = new FamilyTreeConsoleView();
        view.start();
    }
}

