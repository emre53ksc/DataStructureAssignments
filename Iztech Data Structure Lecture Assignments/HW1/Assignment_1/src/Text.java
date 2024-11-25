@SuppressWarnings("hiding")
public class Text<Word> extends Bag<Word> {

	
	public void seperate(Dictionary<Word> dictionary,RareWordsDictionary<Word> rare,FrequentWordsDictionary<Word> fre,MostFrequentWordsDictionary<Word> mostfre) {
		
		
		Word[] ourdict = dictionary.toArray();
		
		
		for(int i = 0;i < dictionary.getCurrentSize();i++) {
			int counter = 0;
			int text_item_count = this.getCurrentSize();
			for(int j = 0;j < text_item_count;j++) {
				if(dictionary.toArray()[i].equals(this.toArray()[j].toString())) {
					counter++;		
				}
			}

			if(counter > 8) {
				mostfre.add(ourdict[i]);
			}else if(counter > 4) {
				fre.add(ourdict[i]);
			}else {
				rare.add(ourdict[i]);
			}
		}
	}
}
