/**
 * @author Ostrovskiy Dmitriy
 * @created 21.05.2024
 * interface Externalizable
 * @version v1.0
 */

package family_true.api;

import family_true.family_tree.FamilyTree;

import java.io.Serializable;
import java.util.List;

public interface Externalizable extends Serializable {

    /**
     * Запись в файл
     * @param familyTreeList
     */
    void writeAllExternal(List<FamilyTree> familyTreeList);

    /**
     * Обновление объекта и запись в файл
     * @param familyTreeList
     */
    void updateExternal(FamilyTree familyTreeList);

    /**
     * Чтение и возвращение объекта из файла
     * @return List<FamilyTree>
     */
    List<FamilyTree> readExternal();
}
