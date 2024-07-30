package View;

import Presenter.Recipient;

public interface View {
    void mainLoop();

    void exit();

    void setConsoleName(String consoleName);

    void setPresenter(Recipient presenter);

    String nextLine();

    void println(String string);

    void printMessage(String name, String message);
}
