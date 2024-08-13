package family_tree.view.menu;

import family_tree.view.View;

public class SortByBirthday implements command{
    public final String str = "Сортировать по дате рождения";
    private View view;

    public SortByBirthday(View view){
        this.view = view;
    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void startcommand() {
        view.sortByBirthday();
    }
}
