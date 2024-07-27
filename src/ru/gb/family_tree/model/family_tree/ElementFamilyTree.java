package ru.gb.family_tree.model.family_tree;
//Интерефейс разделен в соотвествии первым принципом SOLID.
//Для чего интерфейс ElementFamilyTree был разделен по числу методов на 3 интерйесам
// так как каждый класс или интерфейс должен иметь только одну ответственность
public interface ElementFamilyTree<E> extends DatedEntity, AgeEntity, Comparable<E> {
}

