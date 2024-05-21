/**
 * @author Ostrovskiy Dmitriy
 * @created 21.05.2024
 * interface Externalizable
 * @version v1.0
 */

package family_true.api;

import family_true.FamilyTree;

import java.io.Serializable;
import java.util.List;

public interface Externalizable extends Serializable {

    void writeExternal(List<FamilyTree> familyTreeList);
    List<FamilyTree> readExternal();
}
