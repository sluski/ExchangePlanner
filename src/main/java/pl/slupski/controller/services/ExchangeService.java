package pl.slupski.controller.services;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.slupski.controller.interfaces.ExchangeServiceInterface;
import pl.slupski.controller.pojo.Client;
import pl.slupski.controller.pojo.Order;
import pl.slupski.controller.pojo.OrderItem;
import pl.slupski.controller.pojo.Product;
import pl.slupski.controller.pojo.Unit;
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
public class ExchangeService implements ExchangeServiceInterface {

    private final ClientMapper clientMapper;
    private final OrderMapper orderMapper;
    private final OrderItemMapper orderItemMapper;
    private final UnitMapper unitMapper;
    private final ProductMapper productMapper;

    public ExchangeService(final ClientMapper clientMapper, final OrderMapper orderMapper, final OrderItemMapper orderItemMapper, final UnitMapper unitMapper, final ProductMapper productMapper) {
        this.clientMapper = clientMapper;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
        this.unitMapper = unitMapper;
        this.productMapper = productMapper;
    }

    @Override
    public int insert(final Client item) {
        clientMapper.insert(item);
        return item.getId();
    }
    @Override
    public Client findClient(final int id) {
        return clientMapper.find(id);
    }
    @Override
    public List<Client> findClients() {
        return clientMapper.findAll();
    }
    @Override
    public void update(final Client item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(final Client item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int insert(final Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Order findOrder(final int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Order> findOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void update(final Order item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(final Order item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int insert(final OrderItem orderItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public OrderItem findOrderItem(final int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<OrderItem> findOrderItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void update(final OrderItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(final OrderItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int insert(final Product product) {
        return productMapper.insert(product);
    }
    @Override
    public Product findProduct(final int id) {
        return productMapper.find(id);
    }
    @Override
    public List<Product> findProducts() {
        return productMapper.findAll();
    }
    @Override
    public void update(final Product item) {
        productMapper.update(item);
    }
    @Override
    public void delete(final Product item) {
        productMapper.delete(item);
    }
    @Override
    public int insert(final Unit unit) {
        return unitMapper.insert(unit);
    }
    @Override
    public Unit findUnit(final int id) {
        return unitMapper.find(id);
    }
    @Override
    public List<Unit> findUnits() {
        return unitMapper.findAll();
    }
    @Override
    public void update(final Unit item) {
        unitMapper.update(item);
    }
    @Override
    public void delete(final Unit item) {
        unitMapper.delete(item);
    }

}
