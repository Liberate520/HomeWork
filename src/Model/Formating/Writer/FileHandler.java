package Model.Formating.Writer;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.Save;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler implements Writer {
    private final String dirName = "src\\Data";

    private String create_name(String name){
        return dirName + "\\" + name;
    }

    public String getDirName() {
        return dirName;
    }

    public void save(Save save) throws IOException {
        ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(create_name(save.getFileName())));

        data.writeObject(save);

        data.close();
    }

    public Save open(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream object = new ObjectInputStream(new FileInputStream(create_name(name)));

        Save save = (Save) object.readObject();

        object.close();

        return save;
    }

    public ArrayList<String> getSavesList(){
        File dir = new File(getDirName());
        File[] files = dir.listFiles();

        ArrayList<String> info = new ArrayList<>();

        if (files != null) {
            ArrayList<File> list = new ArrayList<>(Arrays.asList(files));


            if (!list.isEmpty()) {
                for (File file : list) {
                    info.add(file.getName());
                }
            }
        }

        return info;
    }
}
