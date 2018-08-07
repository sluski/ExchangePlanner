package pl.slupski.model.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Mapper
public interface UnitMapper {
    
    @Select("SELECT * FROM " + Unit.TABLE_NAME + " WHERE id = " + Unit.ID_PARAMETR)
    public Unit find(final int id);
    
    
}
