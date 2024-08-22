package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс SortTreeByName представляет собой команду для сортировки списка членов семьи по имени.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class SortTreeByName extends Command {

    /**
     * Конструктор SortTreeByName инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public SortTreeByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов семьи в порядке сортировки по имени";  // Описание команды
    }

    /**
     * Выполняет команду сортировки списка членов семьи по имени, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.sortTreeByName();
    }
}
