package Model.family_tree.human;

import java.util.ArrayList;
import java.util.List;

public class Information {
    private Human human;
    private List<Human> children;
    private Human father;
    private Human mother;
    private Human spouse;
    private Сommunications сommunications;

    public Information(Human human) {

        this.human = human;
        children = сommunications.getChildren();
        this.father = father;
        this.mother = mother;
    }

    public String getSpousInfo() {
        String infoSpous = "супруг(а): ";
        if (spouse == null) {
            infoSpous += "отсутствует";
        } else {
            infoSpous += spouse.getName();
        }
        return infoSpous;
    }

    public String getFatherInfo() {
        String infoSpous = "отец: ";
        Human father = сommunications.getFather();
        if (father == null) {
            infoSpous += "отсутствует";
        } else {
            infoSpous += father.getName();
        }
        return infoSpous;
    }

    public String getMotherInfo() {
        String infoSpous = "мать: ";
        Human mather = сommunications.getMother();
        if (mather == null) {
            infoSpous += "отсутствует";
        } else {
            infoSpous += mather.getName();
        }
        return infoSpous;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.getFirst().getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }


    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("id: ");
        info.append(human.getId());
        info.append(", ");
        info.append("имя: ");
        info.append(human.getName());
        info.append(", ");
        info.append("пол: ");
        info.append(human.getSex());
        info.append(", ");
        info.append("дата рождения: ");
        info.append(human.getBrthDate());
        info.append(", ");
        info.append(getSpousInfo());
        info.append(", ");
        info.append(getFatherInfo());
        info.append(", ");
        info.append(getMotherInfo());
        info.append(", ");
        info.append(getChildrenInfo());
        return info.toString();

    }
}
