package ru.gb.family_tree.view.descriptionFormation;

import ru.gb.family_tree.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public interface ReadableData {
    void readData(Scanner scanner, Presenter presenter) throws IOException, ClassNotFoundException;
}
