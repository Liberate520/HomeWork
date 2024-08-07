package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code Finish} предназначена для завершения работы приложения через пользовательский интерфейс.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code finish} в {@code ConsoleUI} для завершения работы приложения.</p>
 */
public class Finish extends Command {

    /**
     * Конструктор класса {@code Finish}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершить работу приложения ❌";
    }

    /**
     * Выполняет команду завершения работы приложения, вызывая метод {@code finish} в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.finish();
    }
}
