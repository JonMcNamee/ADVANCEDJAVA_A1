package entity;

public class Monitor {

    private int partNum;
    private String description;
    private String resolution;
    private double size;
    private String refreshRate;
    private boolean ips;
    private double price;

    public Monitor(int partNum, String description, String resolution, double size, String refreshRate, boolean ips, double price) {
        this.partNum = partNum;
        this.description = description;
        this.resolution = resolution;
        this.size = size;
        this.refreshRate = refreshRate;
        this.ips = ips;
        this.price = price;
    }

    public int getPartNum() {
        return partNum;
    }

    public void setPartNum(int partNum) {
        this.partNum = partNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(String refreshRate) {
        this.refreshRate = refreshRate;
    }

    public boolean isIps() {
        return ips;
    }

    public void setIps(boolean ips) {
        this.ips = ips;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
} // end class Monitor