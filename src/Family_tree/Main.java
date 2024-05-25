package Family_tree;

import java.time.LocalDate;

import Family_tree.Humans.*;
import Family_tree.Recorder.Recorder;
import Family_tree.Tree.Family_tree;

public class Main {
    

    public static void main(String[] args){

      /*   
        Human man1 = new Human("Иванов Виктор Иванович ", Gender.Male, LocalDate.of(1905, 8, 14), LocalDate.of(1972, 12, 20),null,null);
        Human man2 = new Human("Петров Сергей Харитонович ", Gender.Male, LocalDate.of(1907, 8, 14), LocalDate.of(1980, 7, 24),null,null);
        Human man3 = new Human("Иванов Владимир Викторович ", Gender.Male, LocalDate.of(1941, 1, 22), LocalDate.of(2023, 6, 29), man1,null);
        Human man4 = new Human("Иванов Виктор Владимирович ", Gender.Male, LocalDate.of(1972, 1, 2), null, man3,null);

        Human woman1 = new Human("Иванова Анна Харлампиевна ", Gender.Female, LocalDate.of(1910, 12, 22), LocalDate.of(1999, 10, 2),null,null);
        Human woman2 = new Human("Петрова Наталия Клементиевна ", Gender.Female, LocalDate.of(1920, 9, 1), LocalDate.of(2001, 3, 12),null,null);
        Human woman3 = new Human("Иванова Людмила Петровна ", Gender.Female, LocalDate.of(1950, 1, 29), null, man2, woman2);

        man3.setMother(woman1);
        man4.setMother(woman3);
        man1.setSpouse(woman1);
        man2.setSpouse(woman2);
        man3.setSpouse(woman3);
        woman1.setSpouse(man1);
        woman2.setSpouse(man2);
        woman3.setSpouse(man3);

        Human sp1 = new Human("Иванова Елена Сергеевна", Gender.Female, LocalDate.of(1974, 3, 4), LocalDate.of(1994, 5, 12), null, null);
        Link link1 = new Link(LinkType.Married, man4, sp1, false, LocalDate.of(1992, 6, 18), LocalDate.of(1994, 5, 12));
        sp1.getLinks().add(link1);
        man4.getLinks().add(link1);
        Human ch1 = new Human("Иванов Сергей Викторович ", Gender.Male, LocalDate.of(1995, 11, 2), null, man4,sp1);
        sp1.addChild(ch1);
        man4.addChild(ch1);
        
        Human sp2 = new Human("Степанова Кира Радиковна", Gender.Female, LocalDate.of(1974, 7, 14), null, null, null);
        Human sp3 = new Human("Куприянова Светлана Андреевна", Gender.Female, LocalDate.of(1980, 8, 20));
        Human ch2 = new Human("Степанов Иван Викторович ", Gender.Male, LocalDate.of(1995, 12, 27), null, man4,sp2);
        sp2.addChild(ch2);
        man4.addChild(ch2);
        Link link2 = new Link(LinkType.In_a_relationship, man4, sp2, false, LocalDate.of(1994, 11, 1), LocalDate.of(1999, 12, 1));
        sp2.getLinks().add(link2);
        man4.getLinks().add(link2);

        Family_tree tree = new Family_tree("Ивановы");
        tree.add(man1);
        tree.add(man3);
        tree.add(man4);
        tree.add(woman1);
        tree.add(woman3);
        tree.add(sp1);
        tree.add(sp3);
        tree.add(ch1);
        tree.createUnion(LocalDate.of(2001,5,25),man4, sp3, LinkType.Married);
        tree.search(6).changeName("Иванова Светлана Андреевна");
        tree.add("Иванова Елена Викторовна", Gender.Female , LocalDate.of(2005, 5, 28));
        man4.addChild(tree.search(8));
        sp3.addChild(tree.search(8));

        System.out.println(tree.getMemberList());
        System.out.println(man4.getSpouse()); 
        System.out.println(tree.search(6).getlnfo());
        System.out.println("_______________________________________________________________________");
        Human X = tree.search(2);
        System.out.println(X.getChildrenlnfo());
        System.out.println(X.showLinks()); 
        */

        String path = "mine.tree";

        Recorder rwr = new Recorder();
        Family_tree tree = (Family_tree) rwr.read(path);

        System.out.println(rwr.save(tree, path));
        System.out.println(tree.getMemberList());
        
        
    }


}
