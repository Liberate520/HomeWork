package ru.gb.oop.family_tree;

import ru.gb.oop.family_tree.file.FileManajer;
import ru.gb.oop.family_tree.service.Service;

import java.util.logging.Logger;

public class Main {
    public final static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
       Service service = new Service();
       FileManajer fileManajer = new FileManajer();
       service.setTree(fileManajer.load());
       service.run();
    }
}
