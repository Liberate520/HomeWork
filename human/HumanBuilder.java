package human;

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

    public HumanBuilder setDateOfDeath(int year, int month, int day) {
        human.setDateOfDeath(year, month, day);
        return this;
    }

    public HumanBuilder setSpouse(Human human) {
        human.setSpouse(human);
        return this;
    }

    public HumanBuilder setParents(Human father, Human mother) {
        human.setParents(father, mother);
        return this;
    }

    public Human build() {
        return this.human;
    }
}
