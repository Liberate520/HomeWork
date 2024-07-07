import java.util.ArrayList;

public static void main(String[] args) {
    
    FamilyTree f1 = new FamilyTree("Петушковых",  3);
    Human h1 = new Human("Nick", 2002, "Male", new Human("Batya", "Male", "Nick", 1982), new Human("Mama", "Female", "Nick", 1982), "No");
    System.out.println(f1);
    System.out.print(h1);

    
    FamilyTree f2 = new FamilyTree("Творожковых",  7);
    String iAm = "Masha";
    Human batyaBati = new Human("Vlad", "Male", "Batya2", 1950);
    Human mamaBati = new Human("Vladislava", "Female", "Batya2", 1955);
    Human batyaMami = new Human("Volks", "Male", "Mama2", 1952);
    Human mamaMami = new Human("Wagen", "Female", "Mama2", 1953);
    Human batya2 = new Human("Batya2", 1970, "Male", batyaBati, mamaBati, iAm);
    Human mama2 = new Human("Mama2", 1975, "Female", batyaMami, mamaMami, iAm);
    Human iAmCreate = new Human(iAm, 1999, "Female", batya2, mama2, "No");
    System.out.println(f2);
    System.out.print(iAmCreate);

    

}
