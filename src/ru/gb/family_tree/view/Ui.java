package ru.gb.family_tree.view;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.model.human.Human;

public interface Ui {
    void startUi();
    void printAnswer(String answer);
    boolean askForReload();
    void initNewCollector();
    void setInfoInCollector(Object obj, CollectorItems collectorItem);
    void addHuman(boolean ignoreSuccessMessage);
    void editHuman(int id);
    Human getHumanById(int id);
}
