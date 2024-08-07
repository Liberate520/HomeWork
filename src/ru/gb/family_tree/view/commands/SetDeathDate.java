package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code SetDeathDate} предназначена для установки даты смерти члена семьи.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code setDeathDate} в {@code ConsoleUI} для указания даты смерти
 * конкретного члена семьи.</p>
 */
public class SetDeathDate extends Command {

    /**
     * Конструктор класса {@code SetDeathDate}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public SetDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обозначить дату смерти члена семьи \uD83E\uDEA6";
    }

    /**
     * Выполняет команду установки даты смерти, вызывая метод {@code setDeathDate}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.setDeathDate();
    }
}
