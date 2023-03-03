package Comparator;

import java.util.Iterator;
import java.util.List;

import Model.Nimale;

public class NimaleIterator<T extends Nimale> implements Iterator<T>
{
    private int index;
    private List<T> humans;

    public NimaleIterator(List<T> humans)
    {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() // ���� �� ��������� �������
    {
        return humans.size() > index;
    }

    @Override
    public T next() // ������ �������
    {
        return humans.get(index++);
    }

}