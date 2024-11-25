package hw3;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileIO {
	public static void readCommands(String fileName, Inventory inventory) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				processLine(line, inventory);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void processLine(String line, Inventory inventory) {
		String[] parts = line.split(",");
		String command = parts[0];
		
			if (command.equals("add")) {
				String category = parts[1];
				String product = parts[2];
				double price = Double.parseDouble(parts[3]);
				inventory.addProduct(product, category, price);
			} else if (command.equals("search")) {
				inventory.searchProduct(parts[1]);
			} else if (command.equals("list")) {
				inventory.listProducts();
			} else {
				System.out.println("Invalid command:" + command);
		}
	}
}
