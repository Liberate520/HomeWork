package family_tree.view.menu;

import family_tree.view.View;

public class LoadTree implements command{
    public final String str = "Загрузить дерево";
    private View view;

    public LoadTree(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.load();
    }
}
