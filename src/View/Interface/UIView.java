package View.Interface;

public interface UIView {
    void mainLoop();
    void exit();
    String nextLine();
    void println(String string);
    void printMessage(String message);
    void printSignedMessage(String name, String message);
}
