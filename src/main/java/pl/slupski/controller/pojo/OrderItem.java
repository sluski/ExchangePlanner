package pl.slupski.controller.pojo;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class OrderItem extends Entity {

    public static final String TABLE_NAME = "t_order_item";
    public static final String COLUMNS = "order_id, product_id, quantity";
    public static final String PARAMETERS = "#{order.id}, #{product.id}, #{quantity}";
    
    private Order order;
    private Product product;
    private double quantity;
    

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, double quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public OrderItem(Order order, Product product, double quantity, int id) {
        super(id);
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        OrderItem object = (OrderItem) obj;
        if(!this.order.equals(object.order)) return false;
        if(!this.product.equals(object.product)) return false;
        if(this.quantity != object.quantity) return false;
        return true;
    }
    
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
