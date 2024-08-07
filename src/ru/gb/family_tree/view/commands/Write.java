package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code Write} предназначена для сохранения информации о древе в файл.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code write} в {@code ConsoleUI} для сохранения текущего состояния древа
 * в файл.</p>
 */
public class Write extends Command {

    /**
     * Конструктор класса {@code Write}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public Write(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить информацию по древу в файл \uD83D\uDCE5";
    }

    /**
     * Выполняет команду сохранения информации о древе в файл, вызывая метод {@code write}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.write();
    }
}
