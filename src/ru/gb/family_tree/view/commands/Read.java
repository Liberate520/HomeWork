package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс Read представляет собой команду для чтения информации о генеалогическом древе из файла.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class Read extends Command {

    /**
     * Конструктор Read инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public Read(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Прочитать информацию по древу из файла \uD83D\uDCE4";  // Описание команды с использованием Unicode-символа для файла
    }

    /**
     * Выполняет команду чтения информации о генеалогическом древе из файла, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.read();
    }
}
