package ru.gb.family_tree.model.tools.writer;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.FamilyTreeElement;

import java.io.*;

/**
 * Класс {@code FileHandler} предоставляет методы для записи и чтения объектов {@code FamilyTree} в/из файлов.
 *
 * @param <E> тип элемента дерева семьи, который должен наследовать {@code FamilyTreeElement}.
 */
public class FileHandler<E extends FamilyTreeElement<E>> implements Writable {

    /**
     * Записывает сериализуемый объект в файл по указанному пути.
     *
     * @param serializable объект, который нужно записать в файл. Должен реализовывать интерфейс {@code Serializable}.
     * @param path путь к файлу, в который будет записан объект.
     * @return {@code true}, если запись прошла успешно; {@code false} в случае ошибки.
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
     * Читает объект {@code FamilyTree} из файла по указанному пути.
     *
     * @param path путь к файлу, из которого будет прочитан объект.
     * @return объект {@code FamilyTree}, прочитанный из файла, или {@code null} в случае ошибки.
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
