import java.time.LocalDate;

import family_tree.Tree;
import human.Gender;
import human.Human;
import work_with_files.FileHandler;

public class Main {
    public static void main(String[] args) {
        Tree family = new Tree();
        Human me = new Human("Roman", Gender.Male, LocalDate.of(1991, 12, 28));
        Human wife = new Human("Stacy", Gender.Female, LocalDate.of(1992, 1, 6));
        Human mom = new Human("Helen", Gender.Female, LocalDate.of(1971, 10, 23));
        Human dad = new Human("John", Gender.Male, LocalDate.of(1967, 8, 8));
        Human son = new Human("Leo", Gender.Male, LocalDate.of(2023,6, 4));
        Human bro = new Human("Simon", Gender.Male, LocalDate.of(1997, 5,21));
        Human fgranny = new Human("Ann", Gender.Female, LocalDate.of(1929, 8, 20));
        Human mgranny = new Human("Tam", Gender.Female, LocalDate.of(1941, 10, 10));
        Human wmom = new Human("Faith", Gender.Female);
        Human wdad = new Human("Alex", Gender.Male);
        Human wgranny = new Human("Ann", Gender.Female);
        me.setParents(dad, mom);
        bro.setParents(mom, dad);
        wife.setParents(wmom, wdad);
        son.setParents(me, wife);
        wmom.setParent(wgranny);
        fgranny.setChildren(dad);
        mgranny.setChildren(mom);
        fgranny.setDateOfDeath(LocalDate.of(2023, 4, 20));
        family.addToTree(fgranny);
        family.addToTree(me);
        family.addToTree(mom);
        family.addToTree(dad);
        family.addToTree(son);
        family.addToTree(bro);
        family.addToTree(wife);
        family.addToTree(wmom);
        family.addToTree(wdad);
        family.addToTree(mgranny);
        family.addToTree(wgranny);

        family.sortByAge();
        System.out.println(family);

        // FileHandler fileHandler = new FileHandler();
        // fileHandler.save(family);
        // fileHandler.read();

    }
}
