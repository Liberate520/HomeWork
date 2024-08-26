package view.commands;

import java.time.LocalDate;

import model.human.Gender;
import presenter.Presenter;
import java.util.Scanner;

// Применяем SRP: Класс AddHuman отвечает за добавление человека.
public class AddHuman extends Command {

    public AddHuman(Presenter presenter) {
        super("Добавить человека", presenter);
    }

    @Override
    public void execute() {
        presenter.getView().promptAddHuman();
    }
}
