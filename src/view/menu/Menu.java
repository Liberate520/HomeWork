package view.menu;

import java.io.IOException;

public interface Menu {
    String showMenu();
    void execute(int choice) throws IOException, ClassNotFoundException;
    int size();
}
