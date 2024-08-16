package view.commands;

import presenter.Presenter;

// Применяем SRP: Абстрактный класс Command реализует общий функционал для всех команд.
public abstract class Command implements CommandInterface {
    private String description;
    protected Presenter presenter;

    public Command(String description, Presenter presenter) {
        this.description = description;
        this.presenter = presenter;
    }

    @Override
    public String getDescription() {
        return description;
    }

    protected Presenter getPresenter() {
        return presenter;
    }

    @Override
    public abstract void execute();
}