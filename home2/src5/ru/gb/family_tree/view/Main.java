package ru.gb.family_tree.view;

import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.model.writer.FileHandler;
import ru.gb.family_tree.presenter.Presenter;

public class Main {
    public static void main(String[] args) {
        String filePath = "data.txt";
        Service service = new Service();
        FileHandler fileHandler = new FileHandler(filePath);
        ConsoleUI ui = new ConsoleUI();
        Presenter presenter = new Presenter(ui, service, fileHandler);
        ui.setPresenter(presenter);
        ui.start();
    }
}