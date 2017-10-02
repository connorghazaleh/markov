import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Random;



public class EfficientMarkov extends MarkovModel{
	HashMap<String,ArrayList<String>> myMap; 
	  
	
	public EfficientMarkov(int order){
		super(order);
		myMap = new HashMap<String,ArrayList<String>>();
	}
	
	@Override
	public void setTraining(String text) {
		myText = text;
		myMap.clear();
		ArrayList<String> dummy;
		
		for (int i = 0; i <= (myText.length()-myOrder);i++) {
			dummy = new ArrayList<String>();
			String next = "";
			String gram = myText.substring(i,i+myOrder);
			if (i<myText.length()-myOrder){
				next = myText.substring(i+myOrder,i+myOrder+1);
			}
			if (i==myText.length()-myOrder){
				next = PSEUDO_EOS;
			}
			
			if (!myMap.containsKey(gram)) {
				dummy.add(next);
				myMap.put(gram,dummy);
			}else if (myMap.containsKey(gram)){
				dummy = myMap.get(gram);
				dummy.add(next);
				myMap.put(gram, dummy);
			}
			//System.out.println(gram);
			
		}
		//System.out.println(myMap);
	}
	
	@Override
	public ArrayList<String> getFollows(String key){
		
		if (myMap.get(key) == null) {
			throw new NoSuchElementException();
		}else {
			return myMap.get(key);
		}
		
	}

}


