package com.oop.homeWorkOOP;


import com.oop.homeWorkOOP.model.lineAgeSave.LineAgeFile;
import com.oop.homeWorkOOP.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        LineAgeFile lFile = new LineAgeFile("lineage.db");
        // LineageTree lineAge = lFile.loadLineAge();
        ConsoleUI console = new ConsoleUI();
        console.start();

    }
}
