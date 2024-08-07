package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Абстрактный класс {@code Command} представляет собой базовый класс для всех команд,
 * которые могут быть выполнены в пользовательском интерфейсе.
 *
 * <p>Каждая конкретная команда должна наследовать этот класс и реализовать метод {@code execute}.
 * Команды могут использовать {@code ConsoleUI} для взаимодействия с пользователем.</p>
 */
public abstract class Command {
    /**
     * Описание команды, которое может быть отображено пользователю.
     */
    String description;

    /**
     * Экземпляр {@code ConsoleUI}, используемый для взаимодействия с пользовательским интерфейсом.
     */
    ConsoleUI consoleUI;

    /**
     * Конструктор класса {@code Command}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который будет использоваться для взаимодействия с пользователем.
     */
    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    /**
     * Возвращает описание команды.
     *
     * @return описание команды в виде строки.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Выполняет команду.
     * <p>Этот метод должен быть реализован в каждом конкретном подклассе для выполнения
     * специфической задачи, связанной с командой.</p>
     */
    public abstract void execute();
}
