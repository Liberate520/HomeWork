package Family_tree.Model;

import java.time.LocalDate;

import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Humans.Human;

public class HumanManagerClass extends ElementManager<Human> {

    private Human activeHuman;

    public HumanManagerClass(){
        this.activeHuman = null;
    }

    @Override
    Human newSubject(String name, Gender gender, LocalDate bd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newSubject'");
    }

    public boolean setDeathDate(LocalDate value){
        try{
            this.activeHuman.setDeathDate(value);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
