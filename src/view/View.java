package view;

import presenter.Presenter;

public interface View {
    void start();
    void setPresenter(Presenter presenter);
}
