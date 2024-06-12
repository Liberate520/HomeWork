package view;

import view.commands.SaveTree;

public enum Message {
    GOODNIGHT("Доброй ночи"),
    GOODMORNING("Доброго утра"),
    GOODDAY("Добрый день"),
    GOODEVENING("Добрый Вечер"),
    LOADTREE("Загрузить дерево из файла"),
    SSAVETREE("Сохранить в файл"),
    THEEND("Завершить работу."),
    INPUT_ERROR("Ошибка ввода");

    private String message;
    Message(String mess) {
        this.message = mess;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public String getMessage(){
        return message;
    }
}