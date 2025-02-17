package view;

import model.human.Human;

import java.util.List;

public interface View {
    void start();
    void printAnswer(String answer);
    void printAnswer(List<Human> answer);
}
