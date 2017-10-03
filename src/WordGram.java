

public class WordGram implements Comparable<WordGram>{
	
	private int myHash;
	private String[] myWords;
	private int mySize;

		
	public WordGram(String[] words, int index, int size) {
		// complete this constructor
		
		// generates myWords by storing each value from words[] into a corresponding value in myWords[].
		myWords = new String[size];
		mySize = size;
		for (int i = 0; i < size; i++) {
			myWords[i] = words[index];
			index++;
		}
	}
	
	@Override
	public int hashCode() {
		//generates hashCode by creating the string hashCode for each 
		//element in the gram and then multiplying that by 31 to the power of the index 
		int hash = 0;
		for (int k = 0; k < myWords.length; k++) {
			hash += myWords[k].hashCode()*Math.pow(31,k+1);

		}
		myHash = hash;
		return myHash;
	}
	
	@Override
	public String toString() {
		//joins all the strings in myWords separated by spaces
		return String.join(" ",myWords);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null || ! (other instanceof WordGram)) {
			//checks to make sure object is an instance of WordGram
			return false;
		}else{
			//casts object to a WordGram and then uses .equals() to see if corresponding
			//words in each string array myWords[] are the same or different. Returns false
			//if even 1 is different.
			WordGram wg = (WordGram) other;
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
		//uses the string compareTo() method to compare all the strings in two
		//WordGrams concatenated into two larger strings
		return this.toString().compareTo(wg.toString());
	}
	
	public int length() {
		//returns the number of words in a WordGram
		return myWords.length;
	}
	
	public WordGram shiftAdd(String last) {
		//shifts all of the strings in a WordGram back 1 index, 
		//deleting the first one, and adding one to the end
		WordGram A = new WordGram(this.myWords,0,this.myWords.length);
		for(int k = 0; k < this.myWords.length-1; k++) {
			A.myWords[k] = this.myWords[k+1];
		}
		A.myWords[A.myWords.length-1] = last;
		return A;
	}
}
