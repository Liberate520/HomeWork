package model.id_generator;

public class IdGenerator {
    private int currentId;

    public IdGenerator() {
        this.currentId = 0;
    }

    public int generateId() {
        return ++currentId;
    }
}
