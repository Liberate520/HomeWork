package ru.gb.oop.family_tree;

import ru.gb.oop.family_tree.service.Service;

import java.util.logging.Logger;

public class Main {
    public final static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
       Service service = new Service();
       service.run();
    }
}
