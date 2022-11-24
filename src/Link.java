import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Link {
    Map<Human, String> firstHuman;
    Map<Human, String> secondHuman;

    String kinship;

    public Link(Human firstHuman, String firstKinship, Human secondHuman, String secondKinship) {
        this.firstHuman = new HashMap<Human, String>();
        this.secondHuman = new HashMap<Human, String>();

        this.firstHuman.put(firstHuman, firstKinship);
        this.secondHuman.put(secondHuman, secondKinship);

        String[] massStrings;
        massStrings = new String[] {"����", "����"};
        if (Arrays.asList(massStrings).contains(firstKinship)){
            firstHuman.addChildren(secondHuman, this);
            secondHuman.addParent(firstHuman, this);
        }
        massStrings = new String[] {"���", "����"};
        if (Arrays.asList(massStrings).contains(firstKinship)){
            firstHuman.addParent(secondHuman, this);
            secondHuman.addChildren(firstHuman, this);
        }
        massStrings = new String[] {"����", "������"};
        if (Arrays.asList(massStrings).contains(firstKinship)){
            firstHuman.addNearCons(secondHuman, this);
            secondHuman.addNearCons(firstHuman, this);
        }
//        if (firstKinship == "������"){
//            firstHuman.setWife(secondHuman, this);
//            secondHuman.setWife(firstHuman, this);
//        }


    }

    public static void autoLinks (Human member){
        for (Human link : member.getChildrens().keySet()) { // ���������� ��������� �����
            autoLinks(member, link, -1);
        }
        for (Human link : member.getParents().keySet()) { // ���������� ��������� ���������
            autoLinks(member, link, 1);
        }
        for (Human link : member.getNearCons().keySet()) { // ���������� ��������� ������� � �����
            autoLinks(member, link, 0);
        }
    }

    public static void autoLinks (Human member, Human toMember, int layer){

        // ���������� ��������� ������ (����: l -1, 0)

        // ���������� ������� ������ (����: l -1)
        if (layer > -1) {
            Map<Human, Link> consB = toMember.getNearCons(); // �������� ��� ������ �������
            Map<Human, Link> consP = toMember.getNearCons(); // �������� ��� ������ ��������
            for (Map.Entry link : member.getNearCons().entrySet()) {

                if (layer + 0 == 0) { //�������� ��� �� ������
                    if (!consB.containsKey(link.getKey())); {// ���������� �������
                        new Link(toMember, "����", (Human) link.getKey(), "����");// ��������� ��� �����
                    }
                }

                if (layer + 0 == 1){ //��� ��� �������
                    if (!consP.containsKey(link.getKey())); {// ���������� �����
                        new Link(toMember, "����", (Human) link.getKey(), "����");// ��������� ��� �����
                    }
                }
            }
        }

        // ���������� �������� ������ (����: l 0, 1)
        if (layer == -1) {
            Map<Human, Link> consB = toMember.getNearCons(); // �������� ��� ������ �������
            Map<Human, Link> consP = toMember.getNearCons(); // �������� ��� ������ ��������
            for (Map.Entry link : member.getChildrens().entrySet()) {

                if (layer - 1 == -2) { //�������� ��� �� ������
                    if (!consB.containsKey(link.getKey())); {// ���������� �������
                        new Link(toMember, "����", (Human) link.getKey(), "����");// ��������� ��� �����
                    }
                }

            }
        }


    }

}
