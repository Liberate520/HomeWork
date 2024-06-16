/**
 * @author Ostrovskiy Dmitriy
 * @created 21.05.2024
 * interface Externalizable
 * @version v1.0
 */

package family_true.api;

import family_true.model.family_tree.FamilyTree;
import family_true.model.family_tree.Service;
import family_true.model.human.Human;

import java.io.Serializable;
import java.util.List;

public interface Externalizable extends Serializable {

    void setService(Service service);

    /**
     * Запись в файл
     * @param familyTreeList
     */
    void writeAllExternal(List<FamilyTree<Human>> familyTreeList);

    /**
     * Обновление объекта и запись в файл
     * @param familyTreeList
     */
    void updateExternal(FamilyTree<Human> familyTreeList);

    /**
     * Чтение и возвращение объекта из файла
     * @return List<FamilyTree>
     */
    List<FamilyTree<Human>> readExternal();
}
