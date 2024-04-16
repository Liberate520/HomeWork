package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.io.File;

public class main {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        FamilyTree ft;
        File filePath = new File("FamilyTree.out");

        if (filePath.exists()) {
            ft = fileUpload(filePath);
        } else {
            ft = new FamilyTree();
        }

        Person vania = new Person("Ваня", Gender.male, LocalDate.of(1986, 10, 16));
        Person any = new Person("Аня", Gender.female, LocalDate.of(1987, 9, 5));
        // vania.setDateD(LocalDate.of(2022, 5, 22));
        Person ura = new Person("Юра", Gender.male, LocalDate.of(2010, 12, 17));
        vania.setChild(ura);
        any.setChild(ura);

        ft.addPerson(any);
        ft.addPerson(vania);
        ft.addPerson(ura);

        savingToFile(ft, filePath);

        System.out.println(ft.printList());
    }

    static void savingToFile(FamilyTree ft, File filePath) {
        FileHandler fh = new FileHandler();
        try {
            fh.savingToFile(ft, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static FamilyTree fileUpload(File filePath) {

        FileHandler fh = new FileHandler();
        try {
            return (FamilyTree) fh.fileUpload(filePath);
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
        }
        return null;
    }

}
