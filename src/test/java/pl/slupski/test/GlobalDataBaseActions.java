package pl.slupski.test;

import org.springframework.stereotype.Service;
import pl.slupski.model.mappers.ClientMapper;
import pl.slupski.model.mappers.OrderItemMapper;
import pl.slupski.model.mappers.OrderMapper;
import pl.slupski.model.mappers.ProductMapper;
import pl.slupski.model.mappers.UnitMapper;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class GlobalDataBaseActions {

    private final OrderMapper orderMapper;
    private final ProductMapper productMapper;
    private final ClientMapper clientMapper;
    private final UnitMapper unitMapper;
    private final OrderItemMapper orderItemMapper;

    public GlobalDataBaseActions(OrderMapper orderMapper, ProductMapper productMapper, ClientMapper clientMapper, UnitMapper unitMapper, OrderItemMapper orderItemMapper) {
        this.orderMapper = orderMapper;
        this.productMapper = productMapper;
        this.clientMapper = clientMapper;
        this.unitMapper = unitMapper;
        this.orderItemMapper = orderItemMapper;
    }

    public void fullClearDataBase() {
        orderItemMapper.deleteAll();
        orderMapper.deleteAll();
        clientMapper.deleteAll();
        productMapper.deleteAll();
        unitMapper.deleteAll();
    }
}
