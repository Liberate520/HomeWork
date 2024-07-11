package ru.gb.family_tree.view.descriptionFormation;

import ru.gb.family_tree.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class FileWriteData implements WritableData{
    public void writeFile(Scanner scanner, Presenter presenter) throws IOException {
        System.out.println("Введите название файла для сохранения: ");
        presenter.writeData(scanner.nextLine());
    }
}
