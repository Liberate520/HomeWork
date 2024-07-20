package Presenter.BaseClasses;

import Presenter.Interface.Performing;

public abstract class Command implements Performing {
    protected final String key;
    protected final String description;

    public Command(String key, String description){
        this.key = key;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
