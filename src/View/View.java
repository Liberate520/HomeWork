package View;

import Presenter.Presenter;

public interface View {
    void mainLoop();

    void exit();

    void setPresenter(Presenter presenter);
}
