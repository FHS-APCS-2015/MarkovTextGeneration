public class Tester {

	private static final int NUM_WORDS_TO_GENERATE = 100;

	public static void main(String[] args) {
		TextModel model = new TextModel(); // create your model
		model.loadData("Siddarta.txt"); // load the data

		String generatedOutput = "";

		String currentWord = "His"; // Choose starting word
		generatedOutput += currentWord;

		for (int i = 0; i < NUM_WORDS_TO_GENERATE; i++) {
			String nextWord = model.predictNextWord(currentWord);

			generatedOutput += " " + nextWord;

			if (i % 8 == 0)
				generatedOutput += "\n"; // add some line breaks in the output

			currentWord = nextWord;
		}

		System.out.println(generatedOutput);
	}
}

