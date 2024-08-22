package ru.gb.family_tree.model.tools.writer;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.io.*;

/**
 * Класс FileHandler реализует интерфейс Writable для работы с файлами.
 * Предназначен для сериализации и десериализации объектов типа FamilyTree.
 *
 * @param <E> Тип элементов, которые наследуются от FamilyTreeElement.
 */
public class FileHandler<E extends FamilyTreeElement<E>> implements Writable<FamilyTree<E>>  {

    /**
     * Записывает объект FamilyTree в файл.
     *
     * @param serializable Объект FamilyTree, который нужно сериализовать.
     * @param path Путь к файлу, в который будет записан объект.
     * @return Возвращает true, если запись прошла успешно, иначе false.
     */
    @Override
    public boolean write(FamilyTree<E> serializable, String path) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Читает объект FamilyTree из файла.
     *
     * @param path Путь к файлу, из которого будет десериализован объект.
     * @return Возвращает объект FamilyTree, если чтение прошло успешно, иначе null.
     */
    @Override
    public FamilyTree<E> read(String path) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            FamilyTree<E> treeRead = (FamilyTree<E>) objectInputStream.readObject();
            return treeRead;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
