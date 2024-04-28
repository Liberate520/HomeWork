package Model;

public class FamilyTree<E extends Human> {
    private E root;

    public FamilyTree() {
        this.root = root;
    }

    public E findByName(String name) {
        return findByName(root, name);
    }

    private E findByName(E current, String name) {
        if (current == null) return null;
        if (current.getName().equals(name)) return current;
        E result = findByName((E) current.getFather(), name);
        if (result != null) return result;
        return findByName((E) current.getMother(), name);
    }

    public void addHuman(Human child, Human father, Human mother) {
        if (root == null) root = (E) child;
        child.setFather(father);
        child.setMother(mother);
    }

    public void addFather(Human child, Human father) {
        child.setFather(father);
    }

    public void addMother(Human child, Human mother) {
        child.setMother(mother);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        printTree(root, builder, "");
        return builder.toString();
    }

    private void printTree(Human current, StringBuilder builder, String prefix) {
        if (current == null) return;
        builder.append(prefix).append(current.toString()).append("\n");
        printTree(current.getFather(), builder, prefix + "    ");
        printTree(current.getMother(), builder, prefix + "    ");
    }
}