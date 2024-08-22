package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс SetDeathDate представляет собой команду для обозначения даты смерти члена семьи.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class SetDeathDate extends Command {

    /**
     * Конструктор SetDeathDate инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public SetDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обозначить дату смерти члена семьи \uD83E\uDEA6";  // Описание команды с использованием Unicode-символа для флага
    }

    /**
     * Выполняет команду обозначения даты смерти члена семьи, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.setDeathDate();
    }
}
