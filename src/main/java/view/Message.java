package view;

public enum Message {
    GOODNIGHT("Доброй ночи"),
    GOODMORNING("Доброго утра"),
    GOODDAY("Добрый день"),
    GOODEVENING("Добрый Вечер"),
    CREATETREE("Создать дерево");

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