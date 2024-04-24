package model.builder;

import model.human.Gender;
import model.human.Human;

public class BasicHumanBuilder extends HumanBuilder {

    @Override
    public Human createName(String name) {
        getHuman().setId(-1);
        getHuman().setName(name);
        if (getHuman().getChildren() == null) getHuman().initChildren();
        if (getHuman().getParents() == null) getHuman().initParents();
        return human;
    }

    @Override
    public Human createGender(Gender gender) {
        getHuman().setGender(gender);
        return human;
    }
}