package pl.slupski.controller.pojo;

import java.io.Serializable;

/**
 *
 * @author Przemysław Słupski <przemyslaw.slupski.98@gmail.com>
 */
public abstract class Entity implements Serializable {
    public static final String TABLE_NAME = "";
    public static final String COLUMNS = "";
    public static final String PARAMETERS = "";
    public static final String ID_PARAMETER = "#{id}";
    
    private int id;

    public Entity() {
    }

    public Entity(int id){
        this.id = id;
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public boolean isPersist(){
        return id != 0;
    }
}
