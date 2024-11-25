package hw3;

public class Product implements ProductInterface {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    }

    public String toString() {
        return name + " (" + category + "): " + price + "₺";
    }

    public int compareTo(Product other) {
        int categoryComparison = this.category.compareTo(other.category);
        if (categoryComparison == 0) {
            return this.name.compareTo(other.name);
        }
        return categoryComparison;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return name.equals(product.name);
    }
}
