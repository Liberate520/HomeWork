package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Абстрактный класс Command определяет общую структуру для всех команд в приложении.
 * Каждая конкретная команда должна наследоваться от этого класса и реализовывать метод execute.
 */
public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    /**
     * Конструктор Command инициализирует команду с объектом консольного пользовательского интерфейса.
     *
     * @param consoleUI Объект консольного интерфейса пользователя (ConsoleUI), с которым команда будет взаимодействовать.
     */
    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    /**
     * Возвращает описание команды.
     *
     * @return Описание команды в виде строки.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Абстрактный метод execute, который должен быть реализован в каждом подклассе.
     * Этот метод определяет, что конкретно делает команда при ее выполнении.
     */
    public abstract void execute();
}
