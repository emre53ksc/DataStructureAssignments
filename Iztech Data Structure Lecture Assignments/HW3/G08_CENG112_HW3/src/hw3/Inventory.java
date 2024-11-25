package hw3;

public class Inventory implements InventoryInterface {
    private Tree<Product> productTree;

    public Inventory() {
        productTree = new Tree<>();
    }

    public void addProduct(String name, String category, double price) {
        Product product = new Product(name, category, price);
        productTree.add(product);
        System.out.println("Adding:\n" + product.toString() + "\n");
    }

    
    public void searchProduct(String name) {
        boolean found = productTree.containsNode(new Product(name, "", 0));
        if (found) {
            System.out.println("Searching:\nFound: " + name + "\n");
        } else {
            System.out.println("Searching:\nNot Found: " + name + "\n");
        }
    }

    public void listProducts() {
        System.out.println("Listing:");
        productTree.traverseInOrder(productTree.getRoot());
        System.out.println("");
    }
}
