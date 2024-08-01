package family_tree.view.menu;

import family_tree.view.View;

public class SaveTree implements command{
    public final String str = "Сохранить дерево";
    private View view;

    public SaveTree(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.Save();
    }
}
