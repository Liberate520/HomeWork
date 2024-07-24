package View.Interface;

import Presenter.DatabasePresenter.DatabasePresenter;

public interface DatabaseView extends UIView{
    void setPresenter(DatabasePresenter databasePresenter);
}
