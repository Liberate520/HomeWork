package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс SetParent представляет собой команду для установки родителя для члена семьи.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class SetParent extends Command {

    /**
     * Конструктор SetParent инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public SetParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя \uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66";  // Описание команды с использованием Unicode-символов для семьи
    }

    /**
     * Выполняет команду установки родителя для члена семьи, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.setParent();
    }
}
