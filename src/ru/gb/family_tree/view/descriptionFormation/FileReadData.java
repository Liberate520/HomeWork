package ru.gb.family_tree.view.descriptionFormation;

import ru.gb.family_tree.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class FileReadData implements ReadableData {
    public void readData(Scanner scanner, Presenter presenter) throws IOException, ClassNotFoundException {
        System.out.println("Введите название файла для загрузки: ");
        presenter.readData(scanner.nextLine());
    }
}
