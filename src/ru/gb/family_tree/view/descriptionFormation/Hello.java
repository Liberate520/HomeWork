package ru.gb.family_tree.view.descriptionFormation;

import ru.gb.family_tree.model.member.descriptionFormation.JsonType;
import ru.gb.family_tree.model.member.descriptionFormation.MemberDescription;

public class Hello implements HelloHandler{
    private MemberDescription descriptionFormation;
    public void hello() {
        System.out.println("Добро пожаловать!");
        System.out.println("Формат описания членов древа установлен в стиле JSON");
        descriptionFormation = new JsonType();
    }
}
