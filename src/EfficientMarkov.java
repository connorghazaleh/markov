import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Random;



public class EfficientMarkov extends MarkovModel{
	HashMap<String,ArrayList<String>> myMap; 
	  
	
	public EfficientMarkov(int order){
		//constructor
		super(order);
		myMap = new HashMap<String,ArrayList<String>>();
	}
	
	@Override
	public void setTraining(String text) {
		myText = text;
		myMap.clear();
		ArrayList<String> dummy;
		
		//cycles through an entire text and creates a map value for every WordGram and 
		//saves corresponding values (the next array element)
		for (int i = 0; i <= (myText.length()-myOrder);i++) {
			dummy = new ArrayList<String>();
			//defines cases for what the next character is
			String next = "";
			String gram = myText.substring(i,i+myOrder);
			if (i<myText.length()-myOrder){
				//if location in string is not at end, the next = next character (as string)
				next = myText.substring(i+myOrder,i+myOrder+1);
			}
			if (i==myText.length()-myOrder){
				//if location in string is at end, then next = PSEUDO_EOS
				next = PSEUDO_EOS;
			}
			
			//puts values in map
			if (!myMap.containsKey(gram)) {
				//if map doesn't contain key, then input new key with new arraylist as value
				dummy.add(next);
				myMap.put(gram,dummy);
			}else if (myMap.containsKey(gram)){
				//if map contains key, add value to existing arraylist for that key
				dummy = myMap.get(gram);
				dummy.add(next);
				myMap.put(gram, dummy);
			}

			
		}

	}
	
	@Override
	public ArrayList<String> getFollows(String key){
		
		if (myMap.get(key) == null) {
			//if map does not contain key "kGram" then throw error
			throw new NoSuchElementException();
		}else {
			//if map contains key "kGram" then return corresponding value
			return myMap.get(key);
		}
		
	}

}


