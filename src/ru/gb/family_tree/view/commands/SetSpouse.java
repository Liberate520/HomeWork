package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс SetSpouse представляет собой команду для установки супруга(и) для члена семьи.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class SetSpouse extends Command {

    /**
     * Конструктор SetSpouse инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить супруга(у) \uD83D\uDC6B";  // Описание команды с использованием Unicode-символа для супружеской пары
    }

    /**
     * Выполняет команду установки супруга(и) для члена семьи, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.setSpouse();
    }
}
