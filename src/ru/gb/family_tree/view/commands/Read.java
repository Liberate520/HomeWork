package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code Read} предназначена для чтения информации о древе из файла.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code read} в {@code ConsoleUI} для загрузки данных из файла и обновления
 * состояния древа.</p>
 */
public class Read extends Command {

    /**
     * Конструктор класса {@code Read}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public Read(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Прочитать информацию по древу из файла \uD83D\uDCE4";
    }

    /**
     * Выполняет команду чтения информации о древе из файла, вызывая метод {@code read}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.read();
    }
}
