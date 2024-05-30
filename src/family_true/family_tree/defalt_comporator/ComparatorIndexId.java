/**
 * @author Ostrovskiy Dmitriy
 * @created 28.05.2024
 * class ComparatorIndexId
 * @version v1.0
 */

package family_true.family_tree.defalt_comporator;

import family_true.family_tree.Entity;
import family_true.api.IndexId;

import java.util.Comparator;

public class ComparatorIndexId<T extends Entity> implements Comparator<IndexId> {

    @Override
    public int compare(IndexId o1, IndexId o2) {
        return Integer.compare(o1.getIndexId(), o2.getIndexId());
    }
}
