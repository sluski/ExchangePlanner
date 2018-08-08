package pl.slupski.model.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import pl.slupski.controller.pojo.Unit;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Mapper
public interface UnitMapper {

    @Insert("INSERT INTO " + Unit.TABLE_NAME + "(" + Unit.COLUMNS + ") VALUES (" + Unit.PARAMETERS + ")")
    @Options(useGeneratedKeys=true, keyColumn="id")
    public int insert(Unit item);

    @Select("SELECT * FROM " + Unit.TABLE_NAME + " WHERE id = " + Unit.ID_PARAMETR)
    public Unit find(final int id);

    @Select("SELECT * FROM " + Unit.TABLE_NAME)
    public List<Unit> findAll();

    @Delete("DELETE FROM " + Unit.TABLE_NAME + " WHERE id=" + Unit.ID_PARAMETR)
    public void deleteById(int id);

    @Delete("DELETE FROM " + Unit.TABLE_NAME + " WHERE id=" + Unit.ID_PARAMETR)
    public void delete(Unit item);
    
    @Delete("DELETE FROM " + Unit.TABLE_NAME)
    public void deleteAll();

}
