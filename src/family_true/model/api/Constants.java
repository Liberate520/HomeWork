/**
 * @author Ostrovskiy Dmitriy
 * @created 02.06.2024
 * interface Constants
 * @version v1.0
 */

package family_true.model.api;

import java.time.format.DateTimeFormatter;

public interface Constants {

    String DD_MM_YYYY_MATCHER = "(((0[1-9])|([12][0-9])|(3[01]))\\.((0[0-9])|(1[012]))\\.(([0-9]{4})))";
    String D_MATCHER = "[0-9]*";
    String DD_MM_YYYY_PATTERN = "dd.MM.yyyy";
    DateTimeFormatter DD_MM_YYYY_FORMATTER = DateTimeFormatter.ofPattern(DD_MM_YYYY_PATTERN);
}
