package my_fam_tree;

import my_fam_tree.inf.InterfaceUsers;

public class Main {
    public static void main (String[] args) {
        System.setProperty("file.encoding","UTF-8");
        System.setProperty("console.encoding","UTF-8");
        InterfaceUsers inf = new InterfaceUsers();
        inf.start();
    }
}