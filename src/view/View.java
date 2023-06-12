package view;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;

    void finish();

    void setPresenter(Presenter presenter);
}
