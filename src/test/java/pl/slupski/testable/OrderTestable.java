package pl.slupski.testable;

import java.util.Date;
import org.springframework.stereotype.Service;
import pl.slupski.controller.pojo.Order;
import pl.slupski.model.mappers.OrderMapper;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class OrderTestable extends Testable<Order> {

    private final ClientTestable clientTestable;
    private final OrderMapper orderMapper;

    public OrderTestable(ClientTestable clientTestable, OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
        this.clientTestable = clientTestable;
    }

    @Override
    public Order randomize(boolean save) {
        Order result = new Order(clientTestable.randomize(true), new Date());
        if(save){
            orderMapper.insert(result);
        }
        return result;
    }

}
