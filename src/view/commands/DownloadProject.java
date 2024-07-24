package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class DownloadProject extends Command {

    public DownloadProject(ConsoleUI consoleUI) {

        super(consoleUI);
        description = "Загрузить семейное древо";
    }

    public void execute() {
        try {
            consoleUI.downloadTree();
        } catch (IOException e) {
            System.out.println("Файл не найден! Проверьте, что он был сохранен\n");

        } catch (ClassNotFoundException e) {
            System.out.println("Класс не найден при загрузке проекта!\n");
        }
    }
}