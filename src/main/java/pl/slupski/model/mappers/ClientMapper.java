package pl.slupski.model.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import pl.slupski.controller.pojo.Client;
import pl.slupski.model.sqlbuilder.ClientSqlBuilder;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Mapper
public interface ClientMapper {

    @Insert("INSERT INTO " + Client.TABLE_NAME + "(" + Client.COLUMNS + ") VALUES (" + Client.PARAMETERS + ")")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    public int insert(Client item);

    @Select("SELECT * FROM " + Client.TABLE_NAME + " WHERE id = " + Client.ID_PARAMETER)
    public Client find(final int id);

    @Select("SELECT * FROM " + Client.TABLE_NAME)
    public List<Client> findAll();

    @Delete("DELETE FROM " + Client.TABLE_NAME + " WHERE id=" + Client.ID_PARAMETER)
    public void deleteById(int id);

    @Delete("DELETE FROM " + Client.TABLE_NAME + " WHERE id=" + Client.ID_PARAMETER)
    public void delete(Client item);

    @Delete("DELETE FROM " + Client.TABLE_NAME)
    public void deleteAll();

    @UpdateProvider(type = ClientSqlBuilder.class, method = "generateUpdate")
    public void update(Client item);
}
