package Model.HumanBuilder;

import Model.Human.Gender;
import Model.Human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {

    public Human buildHuman(String name, LocalDate dateBrith, Gender gender){
        return new Human(name, dateBrith, gender);
    }


}
