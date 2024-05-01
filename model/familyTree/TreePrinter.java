package homeWork.model.familyTree;


public class TreePrinter<T extends FamTree> {
    private FamilyTree<T> tree;
    public TreePrinter(FamilyTree<T> tree){
        this.tree = tree;
    } 

    public String printTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        for (T element : tree) {
            stringBuilder.append(element);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}