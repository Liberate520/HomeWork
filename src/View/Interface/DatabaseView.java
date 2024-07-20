package View.Interface;

import Presenter.DatabasePresenter.DatabasePresenter;

public interface DatabaseView {
    void setPresenter(DatabasePresenter databasePresenter);
    void mainLoop();
    void exit();
    String nextLine();
    void println(String string);
    void printMessage(String message);
    void printSignedMessage(String name, String message);
}
