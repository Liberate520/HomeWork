package view;

import Presenter.FamilyTreePresenter;

public interface IUserInterface {
    void setPresenter(FamilyTreePresenter presenter);
    void start();
    void displayMessage(String message);
    void displayErrorMessage(String message);
}