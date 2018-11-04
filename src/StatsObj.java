import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class StatsObj {
    private HashMap<String, Integer> data;
    private ArrayList<String> mostFreq;
    private int size = 0;
    private int n;

    public StatsObj(int n) {
        this.n = n;
        data = new HashMap<String, Integer>();
        mostFreq = new ArrayList<String>();
    }

    public int getCountOf(String string) {
        if (data.containsKey(string)) return data.get(string);
        return 0;
    }

    public int size() {
        return size;
    }

    public void add(String string) {
        size++;
        if (data.containsKey(string)) {
            int num = data.get(string);
            data.put(string, num + 1);
        } else {
            data.put(string, 1);
        }

        updateMostFrequentWith(string);
    }

    private void updateMostFrequentWith(String string) {
        if (mostFreq.contains(string)) {    // if it's already in the list, let's remove it
            mostFreq.remove(string);        // and re-insert it
        }

        for (int i = 0; i < mostFreq.size(); i++) {
            if (getCountOf(string) > getCountOf(mostFreq.get(i))) {
                mostFreq.add(i, string);                     // insert it
                if (mostFreq.size() > n) {
                    mostFreq.remove(mostFreq.size() - 1);  // remove the last one
                }
                return;
            }
        }

        if (mostFreq.size() < this.n) {     // if we didn't insert it yet
            mostFreq.add(string);           // do so!
            return;
        }
    }

    public String getMostFrequent() {
        return this.mostFreq.get(0);
    }

    public List<String> getTopMostFreq() {
        return Collections.unmodifiableList(this.mostFreq);
    }

    public String getRandom() {
        int num = (int) (Math.random() * this.size());

        if (data.keySet().size() == 0) {
            System.out.println("WARNING: statsobj contains no data");
            return null;
        }

        int sum = 0;
        for (String str : data.keySet()) {
            sum += data.get(str);
            if (num < sum) return str;
        }

        return null;
    }

    public String toString() {
        return data.toString();
    }
}
