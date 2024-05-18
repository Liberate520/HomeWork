package Family_tree;

import java.time.LocalDate;

import Family_tree.Humans.*;
import Family_tree.Tree.Family_tree;

public class Main {
    

    public static void main(String[] args){
        Male man1 = new Male("Василий", LocalDate.of(2000, 1, 2));
        Female lady1 = new Female("Василиса");
        lady1.setBirhDate ( LocalDate.of(2002, 5, 15));
        Male man2 = new Male("Иван", LocalDate.of(1980, 11, 25));
        man2.setDeathDate(LocalDate.of(2015,12,12));
        Female lady2 = new Female("Мария");
        lady2.setBirhDate ( LocalDate.of(1986, 6, 1));
        Male man3 = new Male("Дмитрий", LocalDate.of(2023, 4, 22));
        Female lady3 = new Female("Светлана", LocalDate.of(2023, 4, 22));
        Female lady4 = new Female("Ирина");
        lady4.setBirhDate ( LocalDate.of(2001, 8, 5));
        lady4.setDeathDate(LocalDate.of(2020,3,17));
       
        man2.addChild(man1);
        lady2.addChild(man1);

        man1.addChild(man3);
        lady1.addChild(lady3);

        man1.setFather(man2);
        man1.setMother(lady2);
        man1.addPartner(lady1);
        lady1.addPartner(man1);

        man2.addPartner(lady2);
        lady2.addPartner(man2);
        man1.addPartner(lady4);

        Family_tree tree = new Family_tree();
        tree.add(man1);
        tree.add(man2);
        tree.add(man3);

        tree.add(lady1);
        tree.add(lady2);
        tree.add(lady3);
        tree.add(lady4);


        System.out.println(man1);
        System.out.println("#############################################################################");
        System.out.println(man2.showInfo());
        System.out.println("#############################################################################");
        
    }


}
