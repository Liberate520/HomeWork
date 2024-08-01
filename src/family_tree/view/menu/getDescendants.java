package family_tree.view.menu;

import family_tree.view.View;

public class getDescendants implements command{
    public final String str = "Получить потомков человека";
    private View view;

    public getDescendants(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.getDescendants();
    }
}
