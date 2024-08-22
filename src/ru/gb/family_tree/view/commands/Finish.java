package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс Finish представляет собой команду для завершения работы приложения.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class Finish extends Command {

    /**
     * Конструктор Finish инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу приложения ❌";  // Описание команды с использованием Unicode-символа для отмены
    }

    /**
     * Выполняет команду завершения работы приложения, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.finish();
    }
}
