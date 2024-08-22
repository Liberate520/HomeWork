package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс Write представляет собой команду для сохранения информации о генеалогическом древе в файл.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class Write extends Command {

    /**
     * Конструктор Write инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public Write(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить информацию по древу в файл \uD83D\uDCE5";  // Описание команды с использованием Unicode-символа для сохранения в файл
    }

    /**
     * Выполняет команду сохранения информации о генеалогическом древе в файл, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.write();
    }
}
