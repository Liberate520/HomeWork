package ru.gb.family;

import ru.gb.family.model.service.Service;
import ru.gb.family.presenter.Presenter;
import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.View;

import java.io.Serializable;


public class Main implements Serializable {

    public static void main(String[] args) {
        View view = new ConsoleUI();
        Service service = new Service<>();
        service.newTestFamilyTree();
        //service = null;
       // System.gc();

        view.start();



    }





}