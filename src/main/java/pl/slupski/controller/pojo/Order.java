package pl.slupski.controller.pojo;

import java.util.Date;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class Order extends Entity {

    public static final String TABLE_NAME = "t_order";
    public static final String COLUMNS = "client_id, realization_date";
    public static final String PARAMETERS = "#{client.id}, #{realizationDate}";

    private Client client;
    private Date realizationDate;

    public Order() {
    }

    public Order(Client client, Date realizationDate) {
        this.client = client;
        this.realizationDate = realizationDate;
    }

    public Order(Client client, Date realizationDate, int id) {
        super(id);
        this.client = client;
        this.realizationDate = realizationDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Order object = (Order) obj;
        if (!this.client.equals(object.client)) {
            return false;
        }
        if (!this.realizationDate.equals(object.realizationDate)) {
            return false;
        }
        return true;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(Date realizationDate) {
        this.realizationDate = realizationDate;
    }
}
