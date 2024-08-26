package view.commands;

import presenter.Presenter;

// Применяем SRP: Класс SortByBirthDate отвечает за сортировку семейного древа по дате рождения
public class SortByBirthDate extends Command {

    public SortByBirthDate(Presenter presenter) {
        super("Сортировать по дате рождения", presenter);
    }

    public void execute() {
        presenter.sortByBirthDate();
    }
}
