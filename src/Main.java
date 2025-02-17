public class Main {
    public static void main(String[] args) {
        GenealogyTreeView view = new ConsoleGenealogyTreeView();
        Saver saver = new FileHandler();
        Loader loader = new FileHandler();

        MainPresenter presenter = new MainPresenter(view, saver, loader);
        presenter.initialize();
    }
}
