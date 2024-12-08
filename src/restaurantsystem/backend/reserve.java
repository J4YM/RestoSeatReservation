package restaurantsystem.backend;


public class reserve {
    private String name;
    private String resnum;
    private String DaT;
    private String adult;
    private String child;
    private final int incremented = 0;
    
    public reserve(String name, String price, String DaT, String adult, String child) {
        this.name = name;
        this.resnum = price;
        this.DaT = DaT;
        this.adult = adult;
        this.child = child;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResnum() {
        return resnum;
    }

    public void setPrice(String resnum) {
        this.resnum = resnum;
    }

    public String getDaT() {
        return DaT;
    }

    public void setQuantity(String DaT) {
        this.DaT = DaT;
    }
    
    public void setAdult(String adult) {
        this.adult = adult;
    }
    
    public String getAdult() {
        return adult;
    }
    
    public void setChild(String child) {
        this.child = child;
    }
    
    public String getChild() {
        return child;
    }
    
    public int incResnum() {
        int y = this.incremented;
        return y;
    }
}
