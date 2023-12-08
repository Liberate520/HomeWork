package ru.gb.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyTreeList;

    //�����������
    public FamilyTree(){
        familyTreeList = new ArrayList<>(); //�� ��������� ������� ������ List - ������������ �������
    }

    //���������� ��������
    public void addHuman(Human human){
        familyTreeList.add(human);
    }

    //���������� ������� ��� ��������

    //������ �������� �� ID
    public Human getHumanByID(int ID){
        for (Human human : familyTreeList) {
            if (human.getID() == ID) {
                return human;
            }
        }
        return null;
    }

    //������ �������� �� ���
    public Human getHumanByFIO(String fio){
        for (Human human : familyTreeList) {
            if (human.getFIO().equals(fio)){
                return human;
            }
        }
        return null;
    }

    //�������� �� �� ��� �������� ������� - ����� ��� �������
    public String getDescendant(Human human){
        if (human.getGender().equals(Gender.Male)){
            return "son";
        }
        return "daughter";
    }

    //������ �������� �� ����� ������
    public String getChildren(Human parent){
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append(parent);
        //stringBuilder.append("\n\t ����: ");
        for (Human human : familyTreeList) {
            //if ((human.getMother().equals(parent)) || (human.getFather().equals(parent))){
            if (((human.getMother() != null) && (human.getMother().equals(parent))) ||
            ((human.getFather() != null) && (human.getFather().equals(parent))))
            {
                stringBuilder.append("\n\t" + getDescendant(human) + " " + human.getFIO() + " (ID " + human.getID() + ")");
            }
        }
        return stringBuilder.toString();
    }

    //������ ������ ���� �����
    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("=== �������� ����� ===\n");
        for (Human human : familyTreeList){
            stringBuilder.append(human);
            stringBuilder.append(getChildren(human));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString(){
        return getFamilyTree();
    }




}
