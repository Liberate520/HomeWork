package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.io.File;

public class main {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        FamilyTree ft;
        File f = new File("FamilyTree.out");

        if (f.exists()) {
             ft = FileHandler.FileUpload();
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

        FileHandler.SavingToFile(ft);

        System.out.println(ft.printList());
    }

}
