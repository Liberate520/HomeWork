
public class Main {
    public static void main(String[] args) {
        GenealogyTreeView view = new ConsoleGenealogyTreeView();
        MainPresenter presenter = new MainPresenter(view);
        presenter.initialize();
    }
}
