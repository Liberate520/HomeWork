package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс SortTreeByAge представляет собой команду для сортировки списка членов семьи по возрасту.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class SortTreeByAge extends Command {

    /**
     * Конструктор SortTreeByAge инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public SortTreeByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов семьи в порядке сортировки по возрасту";  // Описание команды
    }

    /**
     * Выполняет команду сортировки списка членов семьи по возрасту, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.sortTreeByAge();
    }
}
