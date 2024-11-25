package hw3;

public interface ProductInterface extends Comparable<Product> {
    String getName();
    void setName(String name);
    String getCategory();
    void setCategory(String category);
    double getPrice();
    void setPrice(double price);
    String toString();
}
