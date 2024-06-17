package ru.gb.famaly_tree.view;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;
    void printText(String text);
}
