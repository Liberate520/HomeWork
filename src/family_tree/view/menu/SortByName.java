package family_tree.view.menu;

import family_tree.view.View;

public class SortByName implements command{
    public final String str = "Сортировать по имени";
    private View view;

    public SortByName(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.sortByName();
    }
}
