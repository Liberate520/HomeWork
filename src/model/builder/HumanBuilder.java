package model.builder;

import java.time.LocalDate;

import model.human.Gender;
import model.human.Human;

public class HumanBuilder {
    private static HumanBuilder humanBuilder;
    private int genId;

    private HumanBuilder(){}

    public static HumanBuilder getHumanBuilder(){
        if (humanBuilder == null){
            humanBuilder = new HumanBuilder();
        }
        return humanBuilder;
    }

    public Human build(String name, Gender gender, LocalDate dateOfBirth){
        return new Human(genId++, name, gender, dateOfBirth);
    }

}
