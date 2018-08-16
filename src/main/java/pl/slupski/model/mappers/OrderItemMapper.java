package pl.slupski.model.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import pl.slupski.controller.pojo.Order;
import pl.slupski.controller.pojo.OrderItem;
import pl.slupski.controller.pojo.Product;
import pl.slupski.model.sqlbuilder.OrderItemSqlBuilder;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Mapper
public interface OrderItemMapper {

    @Insert("INSERT INTO " + OrderItem.TABLE_NAME + "(" + OrderItem.COLUMNS + ") VALUES (" + OrderItem.PARAMETERS + ")")
    @Options(useGeneratedKeys=true, keyColumn="id")
    public int insert(OrderItem item);

    @Select("SELECT * FROM " + OrderItem.TABLE_NAME + " WHERE id = " + OrderItem.ID_PARAMETER)
    @Results({
        @Result(column = "product_id", property = "product", javaType = Product.class, one = @One(select = "pl.slupski.model.mappers.ProductMapper.find")),
        @Result(column = "order_id", property = "order", javaType = Order.class, one = @One(select = "pl.slupski.model.mappers.OrderMapper.find")),
        @Result(column = "quantity", property = "quantity")
    })
    public OrderItem find(final int id);

    @Select("SELECT * FROM " + OrderItem.TABLE_NAME)
    public List<OrderItem> findAll();

    @Delete("DELETE FROM " + OrderItem.TABLE_NAME + " WHERE id=" + OrderItem.ID_PARAMETER)
    public void deleteById(int id);

    @Delete("DELETE FROM " + OrderItem.TABLE_NAME + " WHERE id=" + OrderItem.ID_PARAMETER)
    public void delete(OrderItem item);
    
    @Delete("DELETE FROM " + OrderItem.TABLE_NAME)
    public void deleteAll();
    
    @UpdateProvider(type = OrderItemSqlBuilder.class, method = "generateUpdate")
    public void update(OrderItem item);
}
