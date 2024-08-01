package ru.gb.family_tree.model.tools.writer;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.io.*;

/**
 * Класс {@code FileHandler} предоставляет методы для записи и чтения
 * объектов семейного дерева в файл и из файла. Этот класс реализует
 * интерфейс {@code Writable}.
 *
 * @param <E> Тип элемента семейного дерева, который должен расширять
 *            {@code FamilyTreeElement}.
 */
public class FileHandler<E extends FamilyTreeElement<E>> implements Writable {

    /**
     * Записывает сериализуемый объект в файл по указанному пути.
     *
     * @param serializable Объект, который необходимо записать в файл. Этот объект
     *                     должен реализовывать интерфейс {@code Serializable}.
     * @param path Путь к файлу, в который будет записан объект.
     * @return {@code true}, если запись прошла успешно, {@code false} в случае ошибки.
     */
    @Override
    public boolean write(Serializable serializable, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Читает объект семейного дерева из файла по указанному пути.
     *
     * @param path Путь к файлу, из которого будет считан объект семейного дерева.
     * @return Объект {@code FamilyTree<E>} из файла, если чтение прошло успешно,
     *         {@code null} в случае ошибки.
     */
    @Override
    public FamilyTree<E> read(String path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            FamilyTree<E> treeRead = (FamilyTree<E>) objectInputStream.readObject();
            return treeRead;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
