package Presenter.Commands;

public interface Performing {
    String getKey();

    String getDescription();

    void execute();
}