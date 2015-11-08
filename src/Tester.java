public class Tester {

	private static final int MAX_WORD_LENGTH = 100;

	public static void main(String[] args) {
		TextModel model = new TextModel();	// create your model
		model.loadData("Siddarta.txt");		// load the data

		String output = "";

		String word = "His";			// Choose starting word
		output += word;

		for (int i = 0; i < MAX_WORD_LENGTH; i++) {
			String nextWord = model.predictNextWord(word);
			
			output += " " + nextWord ;
			
			if (i % 8 == 0) output += "\n";    // add some line breaks in the output
			
			word = nextWord;
		}

		System.out.println(output);
	}
}