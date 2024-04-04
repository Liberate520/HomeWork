import family_tree.person.Gender;
import family_tree.person.Human;
import family_tree.tree.FamilyTree;
import family_tree.writer.WriterAndReaderByteCode;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Human nikita = new Human("Khrushev Nikita Sergeevich", LocalDate.of(1894, 4, 15), Gender.Male);
        nikita.setDeadDate(LocalDate.of(1971, 9, 11));
        Human serega = new Human("Khrushev Sergei Nikitich", LocalDate.of(1935, 7, 2), Gender.Male);
        Human lyonya = new Human("Khrushev Leonid Nikitich", LocalDate.of(1917, 11, 10), Gender.Male);
        Human nina = new Human("Kucharchuk-Khrusheva Nina Petrovna", LocalDate.of(1900, 4, 14), Gender.Female);
        nina.setDeadDate(LocalDate.of(1984, 8, 13));
        Human frosya = new Human("Pisareva Efrosiniya Ivanovna", LocalDate.of(1896, 1, 01), Gender.Female, LocalDate.of(1919, 01, 01), null, null);
        Human juliya1st = new Human("Khrusheva Julia Nitichna", LocalDate.of(1916, 3, 04), Gender.Female, LocalDate.of(1981, 4, 03), nikita, frosya);
        Human rada = new Human("Adjubey(Khrusheva) Rada Nitichna", LocalDate.of(1929, 4, 04), Gender.Female, LocalDate.of(2016, 8, 11), nikita, nina);


        /*
        1-st wife
         */
        nikita.setPartner(frosya);
        nikita.addChildFromThisPartner(frosya, lyonya);
        nikita.addChildFromThisPartner(frosya, juliya1st);

        frosya.setPartner(nikita);
        frosya.addChildFromThisPartner(nikita, lyonya);
        frosya.addChildFromThisPartner(nikita, juliya1st);

        /*
        3-rd wife
         */
        nikita.setPartner(nina);
        nikita.addChildFromThisPartner(nina, serega);
        nikita.addChildFromThisPartner(nina, rada);

        nina.setPartner(nikita);
        nina.addChildFromThisPartner(nikita, serega);
        nina.addChildFromThisPartner(nikita, rada);

        /*
        Add the information about parents
         */
        lyonya.setFather(nikita);
        lyonya.setMother(frosya);

        serega.setFather(nikita);
        serega.setMother(nina);

        /*
        Create the family tree
         */
        FamilyTree tree = new FamilyTree();
        tree.addPersonToFamily(nikita, 2);
        tree.addPersonToFamily(nina, 2);
        tree.addPersonToFamily(serega, 1);
        tree.addPersonToFamily(lyonya, 1);
        tree.addPersonToFamily(frosya, 2);
        tree.addPersonToFamily(juliya1st, 1);
        tree.addPersonToFamily(rada, 1);

        System.out.println(tree);

        /*
         Serialization using ObjectOutputStream class
         Created the method for writing an object as byte code
         */
        WriterAndReaderByteCode serializator = new WriterAndReaderByteCode();
        serializator.writerInitialization("FamilyTree.out");
        serializator.writeTreeAsByteCode(tree);

        //Renewing of an object from a byte code file using the class ObjectInputStream
        serializator.readerInitialization(serializator.getFileName());
        FamilyTree treeRestored = serializator.readTreeFromByteCodeFile();







    }
}