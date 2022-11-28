public class Link {
    private Tree first;
    private Tree second;
    private int tipeLink; // ��� �������� ������ �������� ��������

    public Link(Tree first, Tree second, int tipeLink, boolean flag) {
        this.first = first;
        this.second = second;
        this.setTipeLink(tipeLink);
        first.addLink(this);
    }

    public Link(Tree first, Tree second, int tipeLink) {
        this(first, second, tipeLink, true);
        new Link(second, first, Link.counterDetection(tipeLink,second.getGender()), true);

    }

    private static int counterDetection(int tipeLink, int secondGender) {
//        byte conter;
        // ���������� ��������� �����
        if (tipeLink / 100 == 3) {return (100 + secondGender);}
        if (tipeLink / 100 == 4) {return (200 + secondGender);}
        if (tipeLink / 100 >= 5) {return ((1200 - tipeLink - (tipeLink - 500)) + secondGender);}

        return 0;
    }


    public Tree getFirst() {
        return first;
    }

    public Tree getSecond() {
        return second;
    }

    public int getTipeLink() {
        return tipeLink;
    }

    public void setTipeLink(int tipeLink) {
        this.tipeLink = tipeLink;
    }
}

/*
���� ������
**0, **1 (������ ������ �����) ������
*0*, *1* (������ �����) ��������� ���������� �������� �������
0**, 1** (� ��� �����������) ��� �������

3 = ����/������
4 = ���/����


5 = ��������
6 = ������/����������
7 = ���/�������
8 = ����/����
--
9 = ���/����
10 = ����/������
11 = �������/���������
12 = ������

12-����-(����-5)
*/
