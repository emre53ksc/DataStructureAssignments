package hw3;

public class Main {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		FileIO.readCommands("src/hw3/hw3_example_inputs.csv", inventory);
		
	}
	

}
