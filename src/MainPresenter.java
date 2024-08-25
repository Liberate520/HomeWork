class MainPresenter {
    private GenealogyTreeModel model;
    private GenealogyTreeView view;
    private FamilyRelationsService relationsService;
    private Saver saver;
    private Loader loader;

    public MainPresenter(GenealogyTreeView view, Saver saver, Loader loader) {
        this.view = view;
        this.model = new GenealogyTreeModel();
        this.relationsService = new FamilyRelationsService();
        this.saver = saver;
        this.loader = loader;
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
            saver.save(model.getGenealogyTree());
            System.out.println("Древо сохранено.");
        });

        view.addLoadButtonClickListener(() -> {
            GenealogyTree loadedTree = (GenealogyTree) loader.load();
            if (loadedTree != null) {
                model.setGenealogyTree(loadedTree);
                view.showGenealogyTree(model.getGenealogyTree());
            } else {
                System.out.println("Не удалось загрузить древо.");
            }
        });
    }
}
