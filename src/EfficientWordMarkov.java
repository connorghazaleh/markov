import java.util.*;
//import java.util.Random;

public class EfficientWordMarkov extends WordMarkovModel {

	public HashMap<WordGram, ArrayList<String>> myMap = new HashMap<>(); 
	
	public EfficientWordMarkov(int order){
		//constructor
		super(order);
		myMap = new HashMap<>();
	}
	
	@Override
	public void setTraining(String text){
		myWords = text.split("\\s+");
		myMap.clear();
		ArrayList<String> dummy;
		
		//cycles through an entire text and creates a map value for every WordGram and 
		//saves corresponding values (the next array element)
		for (int i = 0; i <= myWords.length-myOrder; i++) {
			WordGram gram = new WordGram(myWords, i, myOrder);
			dummy = new ArrayList<String>();
			//defines cases for what the next array element is
			String next = "";
			if (i<myWords.length-myOrder){
				//if location in array is not at end, the next = next array element
				next = myWords[i+myOrder];
			}
			if (i==myWords.length-myOrder){
				//if location in array is at end, then next = PSEUDO_EOS
				next = PSEUDO_EOS;
			}
			
			//puts values in map
			if (!myMap.containsKey(gram)) {
				//if map doesn't contain key, then input new key with new arraylist as value
				dummy.add(next);
				myMap.put(gram,dummy);
			}else{
				//if map contains key, add value to existing arraylist for that key
				myMap.get(gram).add(next);
			} 
		}
		

	}
	
	
	@Override
	public ArrayList<String> getFollows(WordGram kGram) {
		
		if (!myMap.containsKey(kGram)) {
			//if map does not contain key "kGram" then throw error
			throw new NoSuchElementException();
		}else {
			//if map contains key "kGram" then return corresponding value
			return myMap.get(kGram);
		}
		
	}
	
}
