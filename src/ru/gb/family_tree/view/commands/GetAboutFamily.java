package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

/**
 * Команда {@code GetAboutFamily} предназначена для вывода списка всех членов семьи из древа.
 *
 * <p>Этот класс расширяет абстрактный класс {@code Command} и реализует метод {@code execute},
 * который вызывает метод {@code getAboutFamily} в {@code ConsoleUI} для получения и отображения
 * информации о всех членах семьи.</p>
 */
public class GetAboutFamily extends Command {

    /**
     * Конструктор класса {@code GetAboutFamily}.
     *
     * @param consoleUI экземпляр {@code ConsoleUI}, который используется для взаимодействия с пользователем.
     */
    public GetAboutFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список всех членов семьи из древа \uD83D\uDCDD";
    }

    /**
     * Выполняет команду получения информации о всех членах семьи, вызывая метод {@code getAboutFamily}
     * в {@code ConsoleUI}.
     */
    @Override
    public void execute() {
        consoleUI.getAboutFamily();
    }
}
