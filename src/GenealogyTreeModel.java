public class GenealogyTreeModel {
    private GenealogyTree<Person> genealogyTree;

    public GenealogyTreeModel() {
        this.genealogyTree = new GenealogyTree<>();
    }

    public void addPerson(Person person) {
        genealogyTree.addPerson(person);
    }

    public void sortByName() {
        genealogyTree.sortByName();
    }

    public void sortByBirthDate() {
        genealogyTree.sortByBirthDate();
    }

    public GenealogyTree<Person> getGenealogyTree() {
        return genealogyTree;
    }

    public void setGenealogyTree(GenealogyTree<Person> genealogyTree) {
        this.genealogyTree = genealogyTree;
    }
}
