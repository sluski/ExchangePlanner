package pl.slupski.controller;

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
    
    public ExchangeService(ClientMapper clientMapper, OrderMapper orderMapper, OrderItemMapper orderItemMapper, UnitMapper unitMapper, ProductMapper productMapper) {
        this.clientMapper = clientMapper;
        this.orderMapper = orderMapper;
        this.orderItemMapper = orderItemMapper;
        this.unitMapper = unitMapper;
        this.productMapper = productMapper;
    }
    
    
    @Override
    public int insert(Client item) {
        clientMapper.insert(item);
        return item.getId();
    }
    @Override
    public Client findClient(int id) {
        return clientMapper.find(id);
    }
    @Override
    public List<Client> findClients() {
        return clientMapper.findAll();
    }
    @Override
    public void update(Client item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(Client item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int insert(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Order findOrder(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Order> findOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void update(Order item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(Order item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int insert(OrderItem orderItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public OrderItem findOrderItem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<OrderItem> findOrderItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void update(OrderItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(OrderItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int insert(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Product findProduct(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Product> findProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void update(Product item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(Product item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public int insert(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Unit findUnit(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<Unit> findUnits() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void update(Unit item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void delete(Unit item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
