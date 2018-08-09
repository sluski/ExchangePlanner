package pl.slupski.model.sqlbuilder;

import java.util.Arrays;
import java.util.List;
import pl.slupski.controller.pojo.Order;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class OrderSqlBuilder {
    public String generateUpdate() {
        List<String> columns = Arrays.asList(Order.COLUMNS.replaceAll(" ", "").split(","));
        List<String> parameters = Arrays.asList(Order.PARAMETERS.replaceAll(" ", "").split(","));
        String result = " UPDATE  " + Order.TABLE_NAME + " SET";
        for (int i = 0; i < columns.size(); i++) {
            result += " " + columns.get(i) + "=" + parameters.get(i);
            if (i < columns.size() - 1) {
                result += ",";
            }
        }
        result += " where id=" + Order.ID_PARAMETER;
        return result;
    }
}
