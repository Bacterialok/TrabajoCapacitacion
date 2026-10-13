public class Product {
    private int id;
    private String name;
    private double price;
    private boolean active;
    private String category;

    public Product(int id, String name, double price, boolean active, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.active = active;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", category="
                + category + "]";
    }

    @Override 
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (!(obj instanceof Product)) {
            return false;
        }

        Product other = (Product) obj;

        return this.id == other.id;
    }

    @Override 
    public int hashCode() {
        return Integer.hashCode(id);
    }
}