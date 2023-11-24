package entity;

/**
 * An order consists of a Monitor and a quantity.
 */
public class Order {

    private Monitor monitor;
    private int quantity;

    /**
     * Creates a new Order object with the specified values.
     * 
     * @param monitor the Monitor object
     * @param quantity how many monitors
     */
    public Order(Monitor monitor, int quantity) {
        this.monitor = monitor;
        this.quantity = quantity;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
} // end class Order
