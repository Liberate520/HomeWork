/**
 * @author Ostrovskiy Dmitriy
 * @created 04.06.2024
 * class Validator
 * @version v1.0
 */

package family_true.view;

import static family_true.model.api.Constants.DD_MM_YYYY_MATCHER;
import static family_true.model.api.Constants.D_MATCHER;

public class Validator {

    public boolean isValidLocalData(String dateStr) {
        return dateStr.matches(DD_MM_YYYY_MATCHER);
    }

    public boolean isNotValidDigit(String checkIndexStr) {
        return checkIndexStr == null || checkIndexStr.isBlank() || !checkIndexStr.matches(D_MATCHER);
    }

    public boolean isNotValidIndex(int checkIndex, int size) {
        return checkIndex < 1 || checkIndex > size;
    }
}
