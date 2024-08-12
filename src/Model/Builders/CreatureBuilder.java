package Model.Builders;

import Model.Creature.Creature;
import Model.Creature.Gender;

public class CreatureBuilder{
    private Creature creature;

    public CreatureBuilder(){
        createEntity();
    }

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public CreatureBuilder setName(String name) {
        this.creature.setName(name);

        return this;
    }

    public CreatureBuilder setSurname(String surname) {
        this.creature.setSurname(surname);

        return this;
    }

    public CreatureBuilder setGender(Gender gender) {
        this.creature.setGender(gender);

        return this;
    }

    public void createEntity() {
        this.creature = new Creature();
    }

    public Creature build(){
        return this.creature;
    }
}
