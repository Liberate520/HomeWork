package src.view;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface View {

    void printAnswer(String txt);
    void start() throws FileNotFoundException, IOException, ClassNotFoundException;

}
