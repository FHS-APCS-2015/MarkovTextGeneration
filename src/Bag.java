import java.util.HashMap;
import java.util.Set;

public class Bag {
	private HashMap<String, Integer> data;
	private String mostFrequent;
	private int size = 0;
	
	public Bag() {
		data = new HashMap<String, Integer>();
	}
	
	public int getFrequency(String string) {
		if (data.containsKey(string)) return data.get(string);
		return 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public void add(String string) {
		size++;
		if (data.containsKey(string)) {
			int num = data.get(string);
			data.put(string, ++num);
		} else {
			data.put(string, 1);
		}
		
		if (getFrequency(string) > getFrequency(mostFrequent)) {
			mostFrequent = string;
		}
	}
	
	public String getMostFrequent() {
		return mostFrequent;
	}
	
	public String getRandom() {
		Set<String> s = data.keySet();
		String[] letters = s.toArray(new String[0]);
		
		if (letters == null || letters.length == 0) {
			System.out.println("WARNING: bag contains no data");
			return null;
		}
		
		return letters[(int)(Math.random()*letters.length)];
	}
	
	public String getRandomByFrequency() {
		int num = (int)(Math.random()*getSize());
		
		if (data.keySet().size() == 0) {
			System.out.println("WARNING: bag contains no data");
			return null;
		}
		
		int sum = 0;
		for (String letter:data.keySet()) {
			sum += data.get(letter);
			if (num < sum) return letter;
		}
		
		return "ERROR!";
	}
	
	public String toString() {
		return data.toString();
	}
}
