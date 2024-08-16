package view.commands;

import presenter.Presenter;

// Применяем SRP: Класс SortByLastName отвечает за сортировку семейного древа по фамилии
public class SortByLastName extends Command {

    public SortByLastName(Presenter presenter) {
        super("Сортировать по фамилии", presenter);
    }

    public void execute() {
        presenter.sortByLastName();
    }
}
