package src.View;

import java.io.IOException;

public interface View {
    void start() throws ClassNotFoundException, IOException;

    void printMessage(String message);
}
