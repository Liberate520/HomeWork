package family_tree.view.menu;

import family_tree.view.View;

public class Treeget implements command{

    public final String str = "Посмотреть семейное дерево";
    private View view;

    public Treeget(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.getFamily();
    }
}
