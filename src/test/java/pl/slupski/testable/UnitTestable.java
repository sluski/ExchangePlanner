package pl.slupski.testable;

import java.util.UUID;
import org.springframework.stereotype.Service;
import pl.slupski.controller.pojo.Unit;
import pl.slupski.model.mappers.UnitMapper;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class UnitTestable extends Testable<Unit> {

    private UnitMapper unitMapper;

    public UnitTestable(UnitMapper unitMapper) {
        this.unitMapper = unitMapper;
    }

    @Override
    public Unit randomize(boolean save) {
        Unit result = new Unit(UUID.randomUUID().toString(), UUID.randomUUID().toString().substring(0, 5));
        if (save) {
            unitMapper.insert(result);
        }
        return result;
    }

}
