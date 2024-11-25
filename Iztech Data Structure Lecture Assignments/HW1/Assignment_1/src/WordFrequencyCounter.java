public class WordFrequencyCounter {
	public static void main(String[] args) {
		Text<Word> text = new Text<>();
		Dictionary<Word> dictionary = new Dictionary<>();
		RareWordsDictionary<Word> rare = new RareWordsDictionary<>();
		FrequentWordsDictionary<Word> fre = new FrequentWordsDictionary<>();
		MostFrequentWordsDictionary<Word> mostfre = new MostFrequentWordsDictionary<>();
		
		FileIO.readFile(text, dictionary);
		
		
		text.seperate(dictionary, rare, fre, mostfre);
		
        System.out.println("Text: " + text.getCurrentSize() + " words:");
        text.displayItems();
        System.out.println();

        System.out.println("Rare Words Dictionary: " + rare.getCurrentSize() + " words:");
        rare.displayItems();
        System.out.println();

        System.out.println("Frequent Words Dictionary: " + fre.getCurrentSize() + " words:");
        fre.displayItems();
        System.out.println();

        System.out.println("Most Frequent Words Dictionary: " + mostfre.getCurrentSize() + " words:");
        mostfre.displayItems();

	}
}

