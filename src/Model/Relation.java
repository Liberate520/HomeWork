package Model;

public class Relation <E> {
    private E root;

    public void addHuman(E child, E father, E mother) {
        if (root == null) {
            root = child;  // Устанавливаем ребенка как корень, если это первый вызов
        }
        if (child instanceof Human) {
            ((Human) child).setFather((Human) father);
            ((Human) child).setMother((Human) mother);
        }
    }

    private void printTree(E current) {
        if (current instanceof Human || current != null){
            System.out.println(current);
        }
        if (current instanceof Human) {
            Human human = (Human) current;
            if (human.getFather() != null) {
                System.out.println("Father:");
                printTree((E) human.getFather());
            }
            if (human.getMother() != null) {
                System.out.println("Mather:");
                printTree((E) human.getMother());
            }
        }
    }

    public void printFamilyTree() {
        printTree(root);
    }
}
