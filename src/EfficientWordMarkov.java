import java.util.*;
//import java.util.Random;

public class EfficientWordMarkov extends WordMarkovModel {

	public HashMap<WordGram, ArrayList<String>> myMap = new HashMap<>(); 
	
	public EfficientWordMarkov(int order){
		super(order);
		//myRandom = new Random(RANDOM_SEED);
		myMap = new HashMap<>();
	}
	
	@Override
	public void setTraining(String text){
		myWords = text.split("\\s+");
		myMap.clear();
		ArrayList<String> dummy;
		
		for (int i = 0; i <= myWords.length-myOrder; i++) {
			WordGram gram = new WordGram(myWords, i, myOrder);
			dummy = new ArrayList<String>();
			String next = "";
			if (i<myWords.length-myOrder){
				next = myWords[i+myOrder];
			}
			if (i==myWords.length-myOrder){
				next = PSEUDO_EOS;
			}
			
			if (!myMap.containsKey(gram)) {
				dummy.add(next);
				myMap.put(gram,dummy);
			}else{
				myMap.get(gram).add(next);
			} 
		}
		String[] arr= {"do"};
		System.out.println(myMap.get(new WordGram(arr,0,1)));
		
	}
		
		//System.out.println(myMap);
		
	
	
	@Override
	public ArrayList<String> getFollows(WordGram kGram) {
		System.out.print(kGram);
		System.out.println(myMap.get(kGram));
		if (!myMap.containsKey(kGram)) {
			throw new NoSuchElementException();
		}else {
			return myMap.get(kGram);
		}
		
	}
	
}
