package PR.hW1Golubev;



public class Relationship1 {
    private Human1 parent;
    private Human1 child;

    public Relationship1(Human1 parent, Human1 child) {
        this.parent = parent;
        this.child = child;
    }

    public Human1 getParent() {
        return parent;
    }

    public void setParent(Human1 parent) {
        this.parent = parent;
    }

    public Human1 getChild() {
        return child;
    }

    public void setChild(Human1 child) {
        this.child = child;
    }
}