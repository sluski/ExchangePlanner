package pl.slupski.model.sqlbuilder;

import java.util.Arrays;
import java.util.List;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class UnitSqlBuilder {
    public String generateUpdate() {
        List<String> columns = Arrays.asList(Unit.COLUMNS.replaceAll(" ", "").split(","));
        List<String> parameters = Arrays.asList(Unit.PARAMETERS.replaceAll(" ", "").split(","));
        String result = " UPDATE  " + Unit.TABLE_NAME + " SET";
        for (int i = 0; i < columns.size(); i++) {
            result += " " + columns.get(i) + "=" + parameters.get(i);
            if (i < columns.size() - 1) {
                result += ",";
            }
        }
        result += " where id=" + Unit.ID_PARAMETER;
        return result;
    }
}
