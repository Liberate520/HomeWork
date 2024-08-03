import writer.FileHandler;

class MainPresenter {
    private GenealogyTreeModel model;
    private GenealogyTreeView view;

    public MainPresenter(GenealogyTreeView view) {
        this.view = view;
        this.model = new GenealogyTreeModel();
    }

    public void initialize() {
        view.showGenealogyTree(model.getGenealogyTree());

        view.addButtonClickListener(() -> {
            Person person = view.getPersonInput();
            model.addPerson(person);
            view.showGenealogyTree(model.getGenealogyTree());
        });

        view.addSortByNameButtonClickListener(() -> {
            model.sortByName();
            view.showGenealogyTree(model.getGenealogyTree());
        });

        view.addSortByBirthDateButtonClickListener(() -> {
            model.sortByBirthDate();
            view.showGenealogyTree(model.getGenealogyTree());
        });

        view.addSaveButtonClickListener(() -> {
            FileHandler fileHandler = new FileHandler();
            fileHandler.setPath("genealogy_tree.txt");
            fileHandler.save(model.getGenealogyTree());
        });

        view.addLoadButtonClickListener(() -> {
            FileHandler fileHandler = new FileHandler();
            fileHandler.setPath("genealogy_tree.txt");
            GenealogyTree loadedTree = (GenealogyTree) fileHandler.read();
            model.setGenealogyTree(loadedTree);
            view.showGenealogyTree(model.getGenealogyTree());
        });
    }
}