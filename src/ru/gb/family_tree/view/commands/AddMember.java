package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс AddMember представляет собой команду для добавления нового члена семьи в генеалогическое древо.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class AddMember extends Command {

    /**
     * Конструктор AddMember инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public AddMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить члена семьи \uD83D\uDC64";  // Описание команды с использованием Unicode-символа для человека
    }

    /**
     * Выполняет команду добавления нового члена семьи, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.addMember();
    }
}
