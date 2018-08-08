package pl.slupski.controller.pojo;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public class Client extends Entity {

    public static final String TABLE_NAME = "t_client";
    public static final String COLUMNS = "name, address";
    public static final String PARAMETERS = "#{name}, #{address}";

    private String name;
    private String address;

    public Client() {
    }

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public Client(int id, String name, String address) {
        super(id);
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Client object = (Client) obj;
        if (!this.name.equals(object.name)) {
            return false;
        }
        if (!this.address.equals(object.address)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
