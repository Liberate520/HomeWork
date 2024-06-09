package Model.Organisms.Mammals;
import Model.Organisms.Mammals.Persons.Enums.Gender;
import Model.Organisms.Organism;

public abstract class Mammals<T extends Mammals> extends Organism<T> {
    protected T mother, father;
    protected Gender gender;
    public void addParent(T parent) {
        if (parent.gender == Gender.male)
            this.father = parent;
        else
            this.mother = parent;
    }
    public Gender getGender() {
        return this.gender;
    }
    public String getFather() {
        return this.father.toString();
    }
    public String getMother() {
        return this.mother.toString();
    }
}
