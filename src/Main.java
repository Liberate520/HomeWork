package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import src.FamilyTree.FamilyTree;
import src.FileHandling.FileHandler;
import src.Human.Gender;
import src.Human.Human;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FamilyTree myTree = createTree();
        
        
        // Save the tree and read it from file
        writeTree(myTree);
        readTree();
        // Print entire tree (actions should be done from an imported tree)
        System.out.println(myTree.GetFamilyInfo());
        // Sort list by name
         myTree.sortByName();
         System.out.println(myTree.GetFamilyInfo());
        // Sort list by birth date
         myTree.sortByBirthday();
         System.out.println(myTree.GetFamilyInfo());
        // Sort list by number of children
         myTree.sortByChildren();
         System.out.println(myTree.GetFamilyInfo());
        // Find family member by name
         System.out.println(myTree.getMember("Orvin Smith"));        
    }

    private static FamilyTree readTree() throws ClassNotFoundException, IOException {
        FileHandler fh = new FileHandler();
        return(FamilyTree) fh.read();
    }

    private static void writeTree (FamilyTree tree) throws FileNotFoundException, IOException {
        FileHandler fh = new FileHandler();
        fh.write(tree);
    }

    private static FamilyTree createTree() {
        FamilyTree familytree = new FamilyTree();

        int id = 0;

        Human member1 = new Human(id++, "John Smith", LocalDate.of(1965, 1, 2), null, Gender.Male, null, null, null);
        Human member2 = new Human(id++, "Jane Smith", LocalDate.of(1967, 2, 23), null, Gender.Female, null, null, null);
        Human member3 = new Human(id++, "Orvin Smith", LocalDate.of(1985, 6, 15), null, Gender.Male, member2, member1, null);
        Human member4 = new Human(id++, "George Smith", LocalDate.of(1988, 1, 7), null, Gender.Male, member2, member1, null);
        Human member5 = new Human(id++, "Jenevieve Smith", LocalDate.of(1990, 8, 18), null, Gender.Female, member2, member1, null);
        Human member6 = new Human(id++, "Penelope Smith", LocalDate.of(1987, 12, 13), null, Gender.Female, null, null, null);
        Human member7 = new Human(id++, "Fernando Smith", LocalDate.of(1989, 7, 9), null, Gender.Male, null, null, null);
        Human member8 = new Human(id++, "Reece Smith", LocalDate.of(2012, 9, 11), null, Gender.Male, null, null, null);
        Human member9 = new Human(id++, "Lucas Smith", LocalDate.of(2013, 11, 26), null, Gender.Male, null, null, null);
        Human member10 = new Human(id++, "Mario Smith", LocalDate.of(2013, 5, 30), null, Gender.Male, null, null, null);
        Human member11 = new Human(id++, "Bethany Smith", LocalDate.of(2005, 3, 4), null, Gender.Female, null, null, null);

        
        // Adding members to family tree        
        familytree.addMember(member1);
        familytree.addMember(member2);
        familytree.addMember(member3);
        familytree.addMember(member4);
        familytree.addMember(member5);
        familytree.addMember(member6);
        familytree.addMember(member7);
        familytree.addMember(member8);
        familytree.addMember(member9);
        familytree.addMember(member10);
        familytree.addMember(member11);

        // Setting date of death 
        member1.setDeathDate(LocalDate.of(2023,1,14));

        // Setting parents and children
        member7.setChildren(member11);
        member5.setChildren(member11);
        member3.setChildren(member8);
        member3.setChildren(member9);
        member3.setChildren(member10);
        member6.setChildren(member8);
        member6.setChildren(member9);
        member6.setChildren(member10);        
        member1.setChildren(member3);
        member1.setChildren(member4);
        member1.setChildren(member5);
        member2.setChildren(member3);
        member2.setChildren(member4);
        member2.setChildren(member5);        
        member11.setMother(member5);
        member11.setFather(member7);
        member10.setMother(member6);
        member10.setFather(member3);
        member9.setMother(member6);
        member9.setFather(member3);
        member8.setMother(member6);
        member8.setFather(member3);

        
        return familytree;
    }
}
