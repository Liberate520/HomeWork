package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.commands.*;

/**
 * Класс MainMenu представляет собой главное меню приложения, содержащее список доступных команд для выполнения.
 * Наследует класс Menu и инициализирует список команд, доступных из главного меню.
 */
public class MainMenu extends Menu {

    /**
     * Конструктор MainMenu инициализирует главное меню с объектом пользовательского интерфейса и добавляет все доступные команды в меню.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), через который будет взаимодействовать меню.
     */
    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        // Добавление команд в список команд главного меню
        commandList.add(new GetAboutFamily(consoleUI));
        commandList.add(new AddMember(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new SetParent(consoleUI));
        commandList.add(new SetSpouse(consoleUI));
        commandList.add(new Read(consoleUI));
        commandList.add(new Write(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
