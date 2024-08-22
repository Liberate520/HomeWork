package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Класс GetAboutFamily представляет собой команду для вывода списка всех членов семьи из генеалогического древа.
 * Наследует класс Command и реализует метод execute для выполнения команды.
 */
public class GetAboutFamily extends Command {

    /**
     * Конструктор GetAboutFamily инициализирует команду с объектом пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет выполняться команда.
     */
    public GetAboutFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список всех членов семьи из древа \uD83D\uDCDD";  // Описание команды с использованием Unicode-символа для документа
    }

    /**
     * Выполняет команду вывода списка всех членов семьи, вызывая соответствующий метод в ConsoleUI.
     */
    @Override
    public void execute() {
        consoleUI.getAboutFamily();
    }
}
