package model.familyTree;

import java.util.Iterator;
import java.util.List;

// Вместо итератора для конкретного типа членов семьи - человека, сделал общий итератор, который работает с объектами интерфейса ItemFamilyTree
// Так я убрал зависимость класса FamilyTree от класса HumanIterator (Принцип инверсии зависимостей, если ничего не путаю)

public class ItemFamilyIterator<ItemFamilyTree> implements Iterator<ItemFamilyTree> {
    private int currentIndex;
    private List<ItemFamilyTree> familyMembers;

    public ItemFamilyIterator(List<ItemFamilyTree> familyMembers){
        this.familyMembers=familyMembers;
    }

    @Override
    public boolean hasNext() {
        return familyMembers.size()> currentIndex;
    }

    @Override
    public ItemFamilyTree next() {
        return familyMembers.get(currentIndex++);
    }

}
