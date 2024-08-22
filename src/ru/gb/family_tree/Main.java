package ru.gb.family_tree;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

/**
 * Класс {@code Main} является точкой входа в приложение.
 * Он создаёт экземпляр {@code ConsoleUI} и запускает его работу.
 */
public class Main {
    /**
     * Основной метод приложения, который создаёт и запускает экземпляр {@code ConsoleUI}.
     *
     * @param args аргументы командной строки (не используются в текущей реализации).
     * @throws IOException если возникает ошибка ввода-вывода при работе {@code ConsoleUI}.
     */
    public static void main(String[] args) throws IOException {
        ConsoleUI app = new ConsoleUI();
        app.start();
    }
}
