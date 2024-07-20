package View.Interface;

import Presenter.FamilyTreePresenter.FamilyTreePresenter;

public interface FamilyTreeView {
    void setPresenter(FamilyTreePresenter presenter);
    void mainLoop();
    void exit();
    String nextLine();
    void println(String string);
    void printMessage(String message);
    void printSignedMessage(String name, String message);
}
