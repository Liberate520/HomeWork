package ru.gb.family_tree;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

/**
 * Класс {@code Main} содержит точку входа в приложение.
 *
 * <p>Этот класс запускает приложение, создавая экземпляр {@code ConsoleUI}
 * и вызывая его метод {@code start()} для начала работы пользовательского интерфейса.</p>
 */
public class Main {

    /**
     * Точка входа в приложение.
     *
     * <p>Создаёт экземпляр {@code ConsoleUI} и запускает основной цикл работы приложения.
     * Возможное исключение {@code IOException} может быть выброшено в случае проблем с вводом/выводом.</p>
     *
     * @param args аргументы командной строки (не используются).
     * @throws IOException если возникнут проблемы с вводом/выводом.
     */
    public static void main(String[] args) throws IOException {
        ConsoleUI app = new ConsoleUI();
        app.start();
    }
}
