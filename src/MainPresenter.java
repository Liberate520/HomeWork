import writer.Writer;
import writer.FileHandler;

public class MainPresenter {
    private GenealogyTreeModel model;
    private GenealogyTreeView view;
    private Writer fileWriter;

    public MainPresenter(GenealogyTreeView view) {
        this.view = view;
        this.model = new GenealogyTreeModel();
        this.fileWriter = new FileHandler(); // Зависимость от Writer
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
            fileWriter.save(model.getGenealogyTree());
        });

        view.addLoadButtonClickListener(() -> {
            GenealogyTree loadedTree = (GenealogyTree) fileWriter.load();
            model.setGenealogyTree(loadedTree);
            view.showGenealogyTree(model.getGenealogyTree());
        });
    }
}
