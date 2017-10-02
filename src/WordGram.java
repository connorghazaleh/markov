

public class WordGram implements Comparable<WordGram>{
	
	private int myHash;
	private String[] myWords;
	private int mySize;

		
	public WordGram(String[] words, int index, int size) {
		// complete this constructor
		myWords = new String[size];
		mySize = size;
		for (int i = 0; i < size; i++) {
			myWords[i] = words[index];
			index++;
		}
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		for (int k = 0; k < myWords.length; k++) {
			hash += myWords[k].hashCode()*Math.pow(31,k+1);

		}
		myHash = hash;
		return myHash;
	}
	
	@Override
	public String toString() {
		return String.join(" ",myWords);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || ! (other instanceof WordGram)) {
			return false;
		}else{
			WordGram wg = (WordGram) other;
			//if(wg.hashCode()!=hashCode())
			//	return false;
			for (int b = 0; b < this.length(); b++) {
				if (!this.myWords[b].equals(wg.myWords[b])) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public int compareTo(WordGram wg) {
		return this.toString().compareTo(wg.toString());
	}
	
	public int length() {
		return myWords.length;
	}
	
	public WordGram shiftAdd(String last) {
		WordGram A = new WordGram(this.myWords,0,this.myWords.length);
		for(int k = 0; k < this.myWords.length-1; k++) {
			A.myWords[k] = this.myWords[k+1];
		}
		A.myWords[A.myWords.length-1] = last;
		return A;
	}
}
