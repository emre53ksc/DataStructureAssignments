package hw3;

public interface InventoryInterface {
    void addProduct(String name, String category, double price);
    void searchProduct(String name);
    void listProducts();
}
