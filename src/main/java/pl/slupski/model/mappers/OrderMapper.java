package pl.slupski.model.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import pl.slupski.controller.pojo.Client;
import pl.slupski.controller.pojo.Order;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO " + Order.TABLE_NAME + "(" + Order.COLUMNS + ") VALUES (" + Order.PARAMETERS + ")")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    public int insert(Order item);

    @Select("SELECT * FROM " + Order.TABLE_NAME + " WHERE id = " + Order.ID_PARAMETR)
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "client_id", property = "client", javaType = Client.class, one = @One(select = "pl.slupski.model.mappers.ClientMapper.find")),
        @Result(column="realization_date", property = "realizationDate", jdbcType = JdbcType.TIMESTAMP, javaType = java.util.Date.class)
    })
    public Order find(int id);

    @Select("SELECT * FROM " + Order.TABLE_NAME)
    public List<Order> findAll();

    @Delete("DELETE FROM " + Order.TABLE_NAME + " WHERE id=" + Order.ID_PARAMETR)
    public void deleteById(int id);

    @Delete("DELETE FROM " + Order.TABLE_NAME + " WHERE id=" + Order.ID_PARAMETR)
    public void delete(Order item);

    @Delete("DELETE FROM " + Order.TABLE_NAME)
    public void deleteAll();
}
