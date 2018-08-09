package pl.slupski.testable;

import java.util.Random;
import org.springframework.stereotype.Service;
import pl.slupski.controller.pojo.OrderItem;
import pl.slupski.model.mappers.OrderItemMapper;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
@Service
public class OrderItemTestable extends Testable<OrderItem> {

    private final OrderItemMapper orderItemMapper;
    private final OrderTestable orderTestable;
    private final ProductTestable productTestable;
    private final Random rand;

    public OrderItemTestable(OrderItemMapper orderItemMapper, OrderTestable orderTestable, ProductTestable productTestable) {
        this.orderItemMapper = orderItemMapper;
        this.orderTestable = orderTestable;
        this.productTestable = productTestable;
        this.rand = new Random();
    }

    @Override
    public OrderItem randomize(boolean save) {
        OrderItem item = new OrderItem(orderTestable.randomize(true), productTestable.randomize(true), rand.nextInt(100));
        if (save) {
            orderItemMapper.insert(item);
        }
        return item;
    }

}
