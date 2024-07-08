package ru.gb.family_tree.model.member.descriptionFormation;

import ru.gb.family_tree.model.member.Member;

import java.util.List;

public class JsonType implements MemberDescription {

    public String DescriptionFormation(Member member) {
        return "{" + this.getClass().getSimpleName() + "; " +
                "ID ='" + member.getId() + '\'' +
                "name='" + member.getName() + '\'' +
                ", mother=" + toStrHelper(member.getMother()) +
                ", father=" + toStrHelper(member.getFather()) +
                ", child=" + toStrHelperList(member.getChild()) +
                ", birthDate=" + member.getBirthDate() +
                ", deathDate=" + member.getDeathDate() +
                ", gender=" + member.getGender() +
                '}';
    }
    //вместо объекта в печать возвращаем только его имя для матери и отца
    private String toStrHelper(Member member){
        if (member != null){
            return member.getName();
        }
        else return null;
    }
    //вместо объекта в печать возвращаем только имена детей
    private String toStrHelperList(List<Member> list){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (Member member: list){
            if (sb.length() > 1){
                sb.append(", ");
            }
            sb.append(member.getName());
        }
        sb.append(")");
        return sb.toString();
    }
}
