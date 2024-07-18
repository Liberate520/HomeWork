import java.security.AllPermission;
import java.util.ArrayList;

public static void main(String[] args) { 

    Human h1 = new Human(0,"Иван", 2000, "Мужской");

    Human h1_1 = new Human(1, "Маша", 2001, "Женский");

    Human h2 = new Human(2, "Петр Папа Ивана и Маши", 1970, "Мужской");

    Human h3 = new Human(3, "Наталья Мама Ивана и Маши", 1980, "Женский");
 
    Human h2_1 = new Human(4, "Василий Папа Петра", 1950, 2020, "Мужской");

    Human h2_2 = new Human(5, "Василиса Мама Петра", 1951, 2022, "Женский");
    
    Human h3_1 = new Human(6, "Василий Папа Натальи", 1952, 2019, "Мужской");

    Human h3_2 = new Human(7, "Василиса Мама Натальи", 1953, 2023, "Женский");

    h1.setFather(h2);
    h1.setMother(h3);  
    h1_1.setFather(h2);
    h1_1.setMother(h3);


    h2.setFather(h2_1);
    h2.setMother(h2_2);

    h3.setFather(h3_1);
    h3.setMother(h3_2);

   // System.out.print(h1.setFather(h2));

    // System.out.print(h1.setMother(h3));   
    // System.out.print(h1.setFather(h2));
    // System.out.print(h1.setMother(h3));
    // System.out.print(h1.getParents(h1));





    ArrayList<Human> HumansFamily = new ArrayList<>();
    HumansFamily.add(h1);
    HumansFamily.add(h1_1);
    HumansFamily.add(h2);
    HumansFamily.add(h3);
    HumansFamily.add(h2_1);
    HumansFamily.add(h2_2);
    HumansFamily.add(h3_1);
    HumansFamily.add(h3_2);
    FamilyTree F1 = new FamilyTree(0, "Соколовы", HumansFamily);


    System.out.println(F1);
    // System.out.println(F1.HumansFamily); ВСЕ
    System.out.println(F1.HumansFamily.get(0));
    System.out.println(F1.HumansFamily.get(1));
    System.out.println(F1.HumansFamily.get(2));
    System.out.println(F1.HumansFamily.get(3));


    


}
