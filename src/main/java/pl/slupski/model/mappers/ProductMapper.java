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
import pl.slupski.controller.pojo.Client;
import pl.slupski.controller.pojo.Product;
import pl.slupski.controller.pojo.Unit;
import pl.slupski.model.sqlbuilder.ClientSqlBuilder;
import pl.slupski.model.sqlbuilder.ProductSqlBuilder;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Mapper
public interface ProductMapper {

    @Insert("INSERT INTO " + Product.TABLE_NAME + "(" + Product.COLUMNS + ") VALUES (" + Product.PARAMETERS + ")")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    public int insert(Product item);

    @Select("SELECT * FROM t_product where id=#{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "unit_id", property = "unit", javaType = Unit.class,
                one = @One(select = "pl.slupski.model.mappers.UnitMapper.find"))
    })
    public Product find(int id);

    @Select("SELECT * FROM " + Product.TABLE_NAME)
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "unit_id", property = "unit", javaType = Unit.class, one = @One(select = "pl.slupski.model.mappers.UnitMapper.find"))
    })
    public List<Product> findAll();

    @Delete("DELETE FROM " + Product.TABLE_NAME + " WHERE id=" + Product.ID_PARAMETER)
    public void deleteById(int id);

    @Delete("DELETE FROM " + Product.TABLE_NAME + " WHERE id=" + Product.ID_PARAMETER)
    public void delete(Product item);

    @Delete("DELETE FROM " + Product.TABLE_NAME)
    public void deleteAll();
    
    @UpdateProvider(type = ProductSqlBuilder.class, method = "generateUpdate")
    public void update(Product item);
}
