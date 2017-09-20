
public class WordGram implements Comparable<WordGram>{
	
	private String[] myWords;
	private int myHash;
	
	public WordGram(String[] words, int index, int size) {
		myWords = new String[size];
		for(int k=index; k < index+size; k++) {
			myWords[k-index] = words[k];
		}
	}
	
	@Override
	public int hashCode() {
		if (myHash == 0) {
			for(int k=0; k < myWords.length; k++) {
				myHash = 31 * myHash + myWords[k].hashCode();
			}
		}
		return myHash;
	}
	
	@Override
	public String toString() {
		return String.join(" ", myWords);
	}
	@Override
	public boolean equals(Object other) {
		if (other == null || ! (other instanceof WordGram)) {
			return false;
		}
		WordGram wg = (WordGram) other;
		for(int k=0; k < myWords.length; k++) {
			if (! myWords[k].equals(wg.myWords[k])) return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(WordGram wg) {
		int mlen = Math.min(myWords.length, wg.myWords.length);
		for(int k=0; k < mlen; k++) {
			int sub = myWords[k].compareTo(wg.myWords[k]);
			if (sub != 0) return sub;
		}
		return myWords.length - wg.myWords.length;
	}
	
	public int length() {
		return myWords.length;
	}
	
	public WordGram shiftAdd(String last) {
		String[] words = new String[myWords.length];
		System.arraycopy(myWords, 1, words, 0, words.length-1);
		words[words.length-1] = last;
		WordGram wg = new WordGram(words,0,words.length);
		return wg;
	}
}
