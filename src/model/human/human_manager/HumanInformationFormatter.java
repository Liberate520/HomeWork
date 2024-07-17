package model.human.human_manager;

import model.human.Human;

public class HumanInformationFormatter {
    private final Human human;

    public HumanInformationFormatter(Human human) {
        this.human = human;
    }

    public String format() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(human.getId())
                .append(", имя: ").append(human.getName())
                .append(", пол: ").append(human.getGender())
                .append(", возраст: ").append(human.getAge())
                .append(", ").append(getSpouseInfo())
                .append(", ").append(getMotherInfo())
                .append(", ").append(getFatherInfo())
                .append(", ").append(getChildrenInfo());
        return sb.toString();
    }

    private String getSpouseInfo() {
        return "супруг(а): " + (human.getSpouse() != null ? human.getSpouse().getName() : "нет");
    }

    private String getFatherInfo() {
        return "отец: " + (human.getFather() != null ? human.getFather().getName() : "неизвестен");
    }

    private String getMotherInfo() {
        return "мать: " + (human.getMother() != null ? human.getMother().getName() : "неизвестна");
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder("дети: ");
        if (!human.getChildren().isEmpty()) {
            res.append(human.getChildren().get(0).getName());
            for (int i = 1; i < human.getChildren().size(); i++) {
                res.append(", ").append(human.getChildren().get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }
}
