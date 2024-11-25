import java.io.BufferedReader;
import java.io.FileReader;


public class FileIO {

	public static void readFile(Text<Word> text,Dictionary<Word> dictionary) {
		
		try {
            FileReader fileReader = new FileReader("src\\text.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line;
            
            
            while ((line = bufferedReader.readLine()) != null) {
            	
            	line = line.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
            	String[] items = line.split("\\s+");

                for (String item : items) {
                	
                    Word word = new Word(item);
                    text.add(word);
                    
                    if(!dictionary.contains(word)) {
                		dictionary.add(word);
                	}
                }
            }
            
            bufferedReader.close();
            fileReader.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	

	
}
