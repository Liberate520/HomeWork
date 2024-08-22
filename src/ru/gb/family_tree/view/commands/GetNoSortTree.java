package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс GetNoSortTree представляет собой команду для вывода неотсортированного списка членов семьи из генеалогического древа.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class GetNoSortTree extends Command {

    /**
     * Конструктор GetNoSortTree инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public GetNoSortTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести неотсортированный список членов семьи";  // Описание команды
    }

    /**
     * Выполняет команду вывода неотсортированного списка членов семьи, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.getNoSortTree();
    }
}
