package entities;

import org.bson.types.ObjectId;

/**
 *
 * @author TeLesheo
 */
public class Administrator {

    private String names;

    public Administrator() {
    }

    public Administrator(String names) {
        this.names = names;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

}
