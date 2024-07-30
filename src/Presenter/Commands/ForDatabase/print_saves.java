package Presenter.Commands.ForDatabase;

import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class print_saves extends Command implements Performing {
    private final View view;
    private final String path;

    public print_saves(View view, String path){
        super("print saves", "Вывод сохранённых семейных деревьев");

        this.view = view;
        this.path = path;
    }

    @Override
    public void execute() {
        File dir = new File(this.path);
        File[] files = dir.listFiles();

        if (files != null){
            ArrayList<File> list = new ArrayList<>(Arrays.asList(files));

            StringBuilder info = new StringBuilder();

            if (!list.isEmpty()){
                for (File file: list){
                    info.append("\t").append(file.getName()).append("\n");
                }

                this.view.println(info.toString());

            } else {
                this.view.printMessage("Result", "Database is empty");
            }
        }
    }
}
