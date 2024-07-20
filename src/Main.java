import Model.Database;
import Model.Interface.DatabaseInterface;
import Presenter.DatabasePresenter.DatabasePresenter;
import Presenter.FamilyTreePresenter.FamilyTreePresenter;
import Presenter.Interface.DatabaseRecipient;
import Presenter.Interface.FamilyTreeRecipient;
import View.DatabaseUI;
import View.FamilyTreeUI;
import View.Interface.DatabaseView;
import View.Interface.FamilyTreeView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTreeView familyTreeView = new FamilyTreeUI("Family tree", new Scanner(System.in));
        FamilyTreeRecipient familyTreePresenter = new FamilyTreePresenter(familyTreeView);

        DatabaseView databaseView = new DatabaseUI("Database", new Scanner(System.in));
        DatabaseInterface database = new Database();

        DatabaseRecipient databasePresenter = new DatabasePresenter(databaseView, database, familyTreePresenter);

        databasePresenter.start();
    }
}
