package View.Сommand;

import java.util.Scanner;

import Presenter.FamilyTreePresenter;
import Writer.FamilyTreeFileHandler;
import Writer.Writer;

public class LoadCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final Scanner scanner;

    public LoadCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Введите имя файла для загрузки:");
        String filename = scanner.nextLine();
        Writer fileHandler = new FamilyTreeFileHandler();
        fileHandler.setPath(filename);
        presenter.onLoad(fileHandler, filename); // Добавлен аргумент filename
    }
}
