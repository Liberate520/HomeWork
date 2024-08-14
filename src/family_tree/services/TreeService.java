package family_tree.services;

import family_tree.program_classes.FamilyTree;
import family_tree.program_classes.Human;
import family_tree.saving_data.FileHandler;

import java.util.Formatter;

public class TreeService {
    private FamilyTree my_family;
    private FileHandler fh;

    public TreeService(String filePath) {
        this.my_family = new FamilyTree();
        fh = new FileHandler(filePath);
    }

    public void saveDataFile(FamilyTree data) {
        fh.writeData(data);
    }

    public FamilyTree loadDataFile() {
        return fh.readData();
    }

    public void PrintData(FamilyTree data) {
        StringBuilder header = new StringBuilder();
        Formatter formatter = new Formatter(header);
        formatter.format("|%13s | " +
                        "%13s |" +
                        "%13s |" +
                        "%14s |" +
                        "%13s |" +
                        "%13s |" +
                        "%13s |" +
                        "%50s |"
                , "Документ",
                "Имя",
                "Пол",
                "Дата рождения",
                "Дата смерти",
                "Мать",
                "Отец",
                "Дети");
        String header_line = "";
        for (int i = 0; i < header.length(); i++) {
            header_line += "-";
        }
        System.out.println(header_line);
        System.out.println(header);
        System.out.println(header_line);
        for (Object human : data)
            if (human != null) {
                System.out.println(human);
            }
        System.out.println(header_line);
    }
}
