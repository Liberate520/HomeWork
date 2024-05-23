import java.time.LocalDate;

import family_tree.Tree;
import human.Gender;
import human.Human;

public class Main {
    public static void main(String[] args) {
        Tree family = new Tree();
        Human me = new Human("Roman", Gender.Male);
        Human wife = new Human("Stacy",Gender.Female);
        Human mom = new Human("Helen", Gender.Female);
        Human dad = new Human("John", Gender.Male);
        Human son = new Human("Leo", Gender.Male);
        Human bro = new Human("Simon", Gender.Male);
        Human granny = new Human("Ann", Gender.Female);
        Human mgranny = new Human("Tam", Gender.Female);
        Human wmom = new Human("Faith",Gender.Female);
        Human wdad = new Human("Alex",Gender.Male);
        me.setParents(dad, mom);
        son.setParents(me, wife);
        me.setDateOfBirth(LocalDate.of(1991, 12, 28));
        wife.setParents(wmom, wdad);
        mom.setChildren(bro);
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
        
        family.showProgenitors(son);
    }
}
