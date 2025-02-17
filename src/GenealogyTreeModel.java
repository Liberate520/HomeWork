class GenealogyTreeModel {
    private GenealogyTree genealogyTree;

    public GenealogyTreeModel() {
        this.genealogyTree = new GenealogyTree();
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

    public GenealogyTree getGenealogyTree() {
        return genealogyTree;
    }

    public void setGenealogyTree(GenealogyTree genealogyTree) {
        this.genealogyTree = genealogyTree;
    }
}
