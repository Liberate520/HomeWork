import java.time.LocalDate;

import family_tree.Tree;
import human.Gender;
import human.Human;
import work_with_files.FileHandler;

public class Main {
    public static void main(String[] args) {
        Tree family = new Tree();
        Human me = new Human("Roman", Gender.Male, LocalDate.of(1991, 12, 28));
        Human wife = new Human("Stacy", Gender.Female);
        Human mom = new Human("Helen", Gender.Female);
        Human dad = new Human("John", Gender.Male);
        Human son = new Human("Leo", Gender.Male);
        Human bro = new Human("Simon", Gender.Male);
        Human granny = new Human("Ann", Gender.Female);
        Human mgranny = new Human("Tam", Gender.Female);
        Human wmom = new Human("Faith", Gender.Female);
        Human wdad = new Human("Alex", Gender.Male);
        Human wgranny = new Human("Ann", Gender.Female);
        me.setParents(dad, mom);
        bro.setParents(mom, dad);
        wife.setParents(wmom, wdad);
        son.setParents(me, wife);
        wmom.setParent(wgranny);
        granny.setChildren(dad);
        mgranny.setChildren(mom);
        granny.setDateOfBirth(LocalDate.of(1929, 8, 20));
        granny.setDateOfDeath(LocalDate.of(2023, 4, 20));
        family.addToTree(granny);
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

        family.showProgenitors(son);

        FileHandler fileHandler = new FileHandler();
        fileHandler.save(family);
        // fileHandler.read();
    }
}
