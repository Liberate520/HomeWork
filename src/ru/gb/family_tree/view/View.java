package ru.gb.family_tree.view;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface View {
    void printAnswer(String text);
    void start() throws FileNotFoundException, ClassNotFoundException, IOException;
}
