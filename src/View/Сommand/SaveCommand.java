package View.Сommand;

import java.util.Scanner;

import Presenter.FamilyTreePresenter;
import Writer.FamilyTreeFileHandler;
import Writer.Writer;

public class SaveCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final Scanner scanner;

    public SaveCommand(FamilyTreePresenter presenter, Scanner scanner) {
        this.presenter = presenter;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("Введите имя файла для сохранения:");
        String filename = scanner.nextLine();
        Writer fileHandler = new FamilyTreeFileHandler();
        presenter.onSave(fileHandler, filename);
    }
}
