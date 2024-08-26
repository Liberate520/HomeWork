package view.commands;

import presenter.Presenter;

// Применяем SRP: Класс GetFamilyTreeInfo отвечает за вывод информации о семейном дереве
public class GetFamilyTreeInfo extends Command {

    public GetFamilyTreeInfo(Presenter presenter) {
        super("Вывести дерево", presenter);
    }

    public void execute() {
        presenter.getFamilyTreeInfo();
    }
}
