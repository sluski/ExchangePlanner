package pl.slupski.controller.services;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.slupski.controller.interfaces.UnitServiceInterface;
import pl.slupski.controller.pojo.Unit;
import pl.slupski.model.mappers.UnitMapper;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class UnitService implements UnitServiceInterface {

    private UnitMapper unitMapper;
    
    public UnitService(UnitMapper mapper){
        this.unitMapper = mapper;
    }
    
    @Override
    public int add(Unit item) {
        return unitMapper.insert(item);
    }

    @Override
    public Unit find(int id) {
        return unitMapper.find(id);
    }

    @Override
    public List<Unit> findAll() {
        return unitMapper.findAll();
    }

    @Override
    public void update(Unit item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        unitMapper.deleteById(id);
    }

    @Override
    public void delete(Unit item) {
        unitMapper.delete(item);
    }

}
