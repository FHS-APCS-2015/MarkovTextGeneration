public class BagExample {
	public static void main(String[] args) {
		// This file reminds you how Bags work.
		
		Bag b = new Bag();
		
		// Add things to the bag
		b.add("a");
		b.add("a");
		b.add("a");
		b.add("a");
		b.add("a");
		b.add("a");
		
		b.add("b");
		b.add("b");
		
		b.add("x");
		b.add("w");
		b.add("p");
		b.add("q");
		
		// You can then get the frequency of each thing
		System.out.println("Freq of a: " + b.getFrequency("a"));
		System.out.println("Freq of q: " + b.getFrequency("q"));
		System.out.println("Freq of g: " + b.getFrequency("g"));
		
		// You can get the most frequently occuring thing
		System.out.println("Most frequent is: "+ b.getMostFrequent());
		
		// Or you can get a random element according to its frequency in the bag.
		// In this example I get 100 random elements.  notice that the most freqent
		// thing occurs most often in the results:
		for (int i = 0; i < 100; i++) {
			System.out.print( b.getRandomByFrequency() );
		}
	}
}