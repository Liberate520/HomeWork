import Classes.FamilyTree;
import Classes.Human;

import java.time.LocalDate;

import static Classes.Gender.female;
import static Classes.Gender.male;

public class Main {
    public static void main(String[] args){

        FamilyTree tree =new FamilyTree();
        tree.add(new Human(1,"Пушкин","","Александр","Сергеевич",male,
                LocalDate.of(1799,06,06),LocalDate.of(1837,02,10),null,null));
        tree.add(new Human(2,"Пушкина","Гончарова","Наталья","Николаевна",female,
              LocalDate.of(1812,9,8),LocalDate.of(1863,12,8),null,null));
        tree.add(new Human(3,"Гартунг","Пушкина","Мария","Александровна",female,
                LocalDate.of(1832,5,31),LocalDate.of(1919,3,7),null,null));
        tree.add(new Human(4,"Пушкин","","Александр","Александрович",male,
                LocalDate.of(1833,7,18),LocalDate.of(1914,8,1),null,null));
        tree.add(new Human(5,"Пушкин","","Григорий","Александрович",male,
                LocalDate.of(1835,5,26),LocalDate.of(1905,8,18),null,null));


//       Human as=new Human(1,"Пушкин","","Александр","Сергеевич",male,
//              LocalDate.of(1799,06,06),LocalDate.of(1837,02,10),null,null);
//       tree.humanList.add(as);
//       Human nn=new Human(2,"Пушкина","Гончарова","Наталья","Николаевна",female,
//              LocalDate.of(1812,9,8),LocalDate.of(1863,12,8),null,null);
//        tree.humanList.add(nn);

        System.out.println(tree.humanList.size());
//        System.out.println(as.getInfo());
//        System.out.println(nn.getInfo());
        System.out.println(tree.getInfo());
    }



}
