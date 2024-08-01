package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import src.FamilyTree.FamilyTree;
import src.Human.Gender;
import src.Human.Human;
import src.Service.Service;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Service service = new Service();
        FamilyTree <Human> myTree = service.createTree();
        Human member1 = service.addToTree("John Smith", LocalDate.of(1965, 1, 2), null, Gender.Male, null, null, null);
        Human member2 = service.addToTree("Jane Smith", LocalDate.of(1967, 2, 23), null, Gender.Female, null, null, null);
        Human member3 = service.addToTree("Orvin Smith", LocalDate.of(1985, 6, 15), null, Gender.Male, member2, member1, null);
        Human member4 = service.addToTree("George Smith", LocalDate.of(1988, 1, 7), null, Gender.Male, member2, member1, null);
        Human member5 = service.addToTree("Jenevieve Smith", LocalDate.of(1990, 8, 18), null, Gender.Female, member2, member1, null);
        Human member6 = service.addToTree("Penelope Smith", LocalDate.of(1987, 12, 13), null, Gender.Female, null, null, null);
        Human member7 = service.addToTree("Fernando Smith", LocalDate.of(1989, 7, 9), null, Gender.Male, null, null, null);
        Human member8 = service.addToTree("Reece Smith", LocalDate.of(2012, 9, 11), null, Gender.Male, null, null, null);
        Human member9 = service.addToTree("Lucas Smith", LocalDate.of(2013, 11, 26), null, Gender.Male, null, null, null);
        Human member10 = service.addToTree("Mario Smith", LocalDate.of(2013, 5, 30), null, Gender.Male, null, null, null);
        Human member11 = service.addToTree("Bethany Smith", LocalDate.of(2005, 3, 4), null, Gender.Female, null, null, null);  
        
        service.addChildren(member11, member7);
        service.addChildren(member11, member5);
        service.addChildren(member8, member3);
        service.addChildren(member8, member6);
        service.addChildren(member9, member3);
        service.addChildren(member9, member6);
        service.addChildren(member10, member3);
        service.addChildren(member10, member6);
        service.addChildren(member4, member1);
        service.addChildren(member4, member2);
        service.addParent(member11, member7);
        service.addParent(member11, member5);
        service.addParent(member8, member3);
        service.addParent(member8, member6);
        service.addParent(member9, member3);
        service.addParent(member9, member6);
        service.addParent(member10, member3);
        service.addParent(member10, member6);        
        
        // Save the tree and read it from file
        service.save();
        service.load();
        // Print entire tree (actions should be done from an imported tree)
        service.printTreeInfo();
        // Sort list by name
        service.sortByName();
        service.printTreeInfo();
        // Sort list by birth date
        service.sortByBirthday();
        service.printTreeInfo();
        // Sort list by number of children
        service.sortByChildren();
        service.printTreeInfo();
        // Find family member by name
         System.out.println(myTree.getMember("Orvin Smith"));        
    }
}
