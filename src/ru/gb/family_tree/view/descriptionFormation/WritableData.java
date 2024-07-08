package ru.gb.family_tree.view.descriptionFormation;

import ru.gb.family_tree.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public interface WritableData {
    void writeFile(Scanner scanner, Presenter presenter) throws IOException;
}
