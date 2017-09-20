
public class WordGram implements Comparable<WordGram>{
	
	private int myHash;
	
	public WordGram(String[] words, int index, int size) {
		// complete this constructor
		myHash = 17;
	}
	
	@Override
	public int hashCode() {
		return myHash;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || ! (other instanceof WordGram)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(WordGram wg) {
		return -1;
	}
	
	public int length() {
		return 0;
	}
	
	public WordGram shiftAdd(String last) {
		return new WordGram(null,0,0);
	}
}
