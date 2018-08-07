package pl.slupski.model.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pl.slupski.controller.pojo.Product;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Mapper
public interface ProductMapper {

    @Select("SELECT * FROM t_product where id=#{id}")
    @Results({
        @Result(column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "unit_id", property = "unit", javaType = Unit.class, 
                one = @One(select = "pl.slupski.model.mappers.UnitMapper.find"))
    })
    public Product find(int id);
}
