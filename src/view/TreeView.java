package view;

import presenter.Presenter;

public interface TreeView {
    void setPresenter(Presenter presenter);
    void displayMessage(String message);
    void displayPerson(String personInfo);
    void displayAllPersons(String personsInfo);
}
