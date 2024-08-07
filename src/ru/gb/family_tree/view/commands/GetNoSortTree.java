package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code GetNoSortTree} предназначена для вывода неотсортированного списка членов семьи.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code getNoSortTree} в {@code ConsoleUI} для получения и отображения
 * неотсортированного списка членов семьи.</p>
 */
public class GetNoSortTree extends Command {

    /**
     * Конструктор класса {@code GetNoSortTree}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public GetNoSortTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести неотсортированный список членов семьи";
    }

    /**
     * Выполняет команду получения неотсортированного списка членов семьи, вызывая метод {@code getNoSortTree}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.getNoSortTree();
    }
}
