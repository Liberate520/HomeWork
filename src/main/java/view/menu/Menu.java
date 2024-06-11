package view.menu;

import java.io.IOException;

public interface Menu {

    String menu();
    void execute(int choice) throws IOException, ClassNotFoundException;
    int getSize();
}
