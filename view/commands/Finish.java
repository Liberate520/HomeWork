package view.commands;

import presenter.Presenter;
import view.ConsoleUI;
import view.View;

// Применяем SRP: Класс FinishCommand отвечает за завершение работы.
public class Finish extends Command {
    private ConsoleUI consoleUI;

    public Finish(Presenter presenter, View view) {
        super("Закончить работу", presenter);
        this.consoleUI = (ConsoleUI) view;
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}