package model.human;

public class HumanBuilder {
    private Human human;

    public HumanBuilder() {
        createHuman();
    }

    private void createHuman() {
        human = new Human();
    }

    public HumanBuilder setName(String name) {
        human.setName(name);
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        human.setGender(gender);
        return this;
    }

    public HumanBuilder setDateOfBirth(int year, int month, int day) {
        human.setDateOfBirth(year, month, day);
        return this;
    }

    public Human build() {
        return this.human;
    }
}
