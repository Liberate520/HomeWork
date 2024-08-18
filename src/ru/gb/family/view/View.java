package ru.gb.family.view;


public interface View {
    public void start();
    public default void printAnswer(String answer){
        System.out.println(answer);
    }

}
