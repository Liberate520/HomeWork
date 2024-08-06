package ru.gb.family_tree.view;

import java.io.IOException;

public interface View {
    void startWork() throws IOException, ClassNotFoundException;

    void printAnswer(String answer);
}
