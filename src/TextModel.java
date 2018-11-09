import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class TextModel {
	private HashMap<String, StatsObj> map;

	public TextModel() {
		map = new HashMap<String, StatsObj>();
	}

	private StatsObj getStatsObjForWord(String word) {
		StatsObj b = null;
		if (map.containsKey(word)) {
			b = map.get(word);
		} else {
			b = new StatsObj(3);
			map.put(word, b);
		}
		
		return b;
	}
	
	// Adds the observed word pair word and followingWord to the Markov model data
	public void addWordPair(String word, String followingWord) {
		/* you implement this one! */
	}

	public void loadData(String filename) {
		String text = getFileAsString(filename);
		text = text.replaceAll("\\s+", " ").trim();  // collapse whitespace to single spaces
		String[] words = text.split(" ");  // split by space

		// Add all words in text to your model
		// words is a String array of individual words from your input text.

	}
	
	public String simulateNextWord(String word) {
		/* you implement this! */
		
		return "IMPLEMENT PREDICTNEXTWORD";
	}

	public static String getFileAsString(String path) {
		StringBuilder b = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while (line != null) {
				b.append(line + "\n");
				line = br.readLine();
			}
		} catch (Exception e) {
			System.out.println("Something wrong: " + e.getMessage());
		}

		return b.toString();
	}
}
