package src;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Human member1 = new Human("John Smith", LocalDate.of(1965, 1, 2), null, Gender.Male, null, null, null);
        Human member2 = new Human("Jane Smith", LocalDate.of(1967, 2, 23), null, Gender.Female, null, null, null);
        Human member3 = new Human("Orvin Smith", LocalDate.of(1985, 6, 15), null, Gender.Male, member2, member1, null);
        Human member4 = new Human("George Smith", LocalDate.of(1988, 1, 7), null, Gender.Male, member2, member1, null);
        Human member5 = new Human("Jenevieve Smith", LocalDate.of(1990, 8, 18), null, Gender.Female, member2, member1, null);
        Human member6 = new Human("Penelope Smith", LocalDate.of(1987, 12, 13), null, Gender.Female, null, null, null);
        Human member7 = new Human("Fernando Smith", LocalDate.of(1989, 7, 9), null, Gender.Male, null, null, null);
        Human member8 = new Human("Reece Smith", LocalDate.of(2012, 9, 11), null, Gender.Male, null, null, null);
        Human member9 = new Human("Lucas Smith", LocalDate.of(2013, 11, 26), null, Gender.Male, null, null, null);
        Human member10 = new Human("Mario Smith", LocalDate.of(2013, 5, 30), null, Gender.Male, null, null, null);
        Human member11 = new Human( "Bethany Smith", LocalDate.of(2005, 3, 4), null, Gender.Female, null, null, null);

        
        // Adding members to family tree
        FamilyTree familytree = new FamilyTree();
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

        // Setting date of death if somebody died
        member1.setDeathDate(LocalDate.of(2023,1,14));

        // Setting parents and children
        member7.setChildren(member11);
        member3.setChildren(member8);
        member3.setChildren(member9);
        member3.setChildren(member10);
        member7.setMother(member2);
        member7.setFather(member1);

        // Print entire tree
        familytree.printTree();
        // Print information of one member
        System.out.println(member3);
        System.out.println(member11.getName() + '\n');
        System.out.println(familytree.getMember("Orvin Smith"));
    }

    
    

}
