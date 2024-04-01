import FamilyTree.FamilyTree;
import Person.Person;
import Person.Sex;
import Writable.FamilyTreeWritable;
import Writable.PersonWritable;

import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        FamilyTree tree = testTree();
        System.out.println(tree);
    }

    static FamilyTree testTree() throws IOException {
        FamilyTree tree = null;

        try {
            // Считываем информацию о дереве семьи из файла
            tree = Writable.FamilyTreeWritable.readFamilyTree("familyTree.dat");
            System.out.println("Family Tree считан успешно:");
            System.out.println(tree);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не удалось загрузить Family Tree из файла, такой файл будет создан.");
            tree = new FamilyTree();
        }

        try {
            // Считываем информацию о персонах из файлов
            Person vasya = Writable.PersonWritable.readPerson("vasya.dat");
            Person masha = Writable.PersonWritable.readPerson("masha.dat");
            Person christina = Writable.PersonWritable.readPerson("christina.dat");
            Person semyon = Writable.PersonWritable.readPerson("semyon.dat");
            Person grandMother = Writable.PersonWritable.readPerson("grandMother.dat");

            // Добавляем людей persons в дерево семьи, если они были успешно считаны
            if (vasya != null) tree.add(vasya);
            if (masha != null) tree.add(masha);
            if (christina != null) tree.add(christina);
            if (semyon != null) tree.add(semyon);
            if (grandMother != null) tree.add(grandMother);

            // Устанавливаем брак между Васей и Машей, если это необходимо
            if (vasya != null && masha != null) tree.setWedding(vasya, masha);

            // Если в коде произошли изменения, перезаписываем информацию о дереве и персонах в файлы
            // Я пока предположила, что такие изменения есть, хотя и их нет
            // код написан таким образом, чтобы просто проверить работоспособность,
            // естественно в будущем надо будет определить какие изменения могут быть и как ими управлять
            boolean isChange = true;
            if (isChange) {
                Writable.FamilyTreeWritable.writeFamilyTree(tree, "familyTree.dat");
                Writable.PersonWritable.writePerson(vasya, "vasya.dat");
                Writable.PersonWritable.writePerson(masha, "masha.dat");
                Writable.PersonWritable.writePerson(christina, "christina.dat");
                Writable.PersonWritable.writePerson(semyon, "semyon.dat");
                Writable.PersonWritable.writePerson(grandMother, "grandMother.dat");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не удалось загрузить членов семьи Persons из файла: " + e.getMessage());
            // Обработать ошибку, если не удалось загрузить персон из файлов
        }

        return tree;
    }
}
