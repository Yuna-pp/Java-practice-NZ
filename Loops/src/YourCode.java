import java.util.ArrayList;

import ecs100.UI;

private static final boolean a = false;
private static final boolean A = false;


// Return an ArrayList that contains the square of each of the numbers
// in the input list.
//
// For example, if input contained [1,2,10] this method should
// return a list with [1,4,100].
//
// You should not modify the input ArrayList.
public ArrayList<Double> mapSquare(ArrayList<Double> input) {
	
	/// YOUR CODE HERE
	ArrayList<Double> newlist = new ArrayList<Double>();
	for (double d : input){
		newlist.add(d*d);
	}
	return newlist;
}


// Return true if word ends with the character 'a' or 'A'.
public boolean isEndingWithA(String word) {
	/// YOUR CODE HERE
	if(word.endsWith("a")||word.endsWith("A")) {
		return true;
	}else {
		return false;
	}
		
}

// Return an ArrayList that contains the strings from the
// input list that contain another string, in the same
// order they appeared.
//
// You should not modify the input ArrayList.
public ArrayList<String> filterContains(ArrayList<String> input, String str) {
	/// YOUR CODE HERE
	ArrayList<String> newlist=new ArrayList<String>();
	for(String d:input) {
		if(d.contains(str)) {
			newlist.add(d);
		}
	}
	return newlist;
}

// Return the average of all numbers in the input list.
//
// For example, if input contained [1,3,8] this method should
// return 4.
//
// You should not modify the input ArrayList.
public double average(ArrayList<Double> input) {
	/// YOUR CODE HERE
	ArrayList<Double> newlist = new ArrayList<Double>();
	double sum=0;
	for(double d:input) {
		sum=sum+d;
	}	
	return sum/input.size();
}

// Return whether the list is ordered from highest to lowest.
//
// For example, if input contained [3,2,1] this method should
// return true, while if input contained [1,3,2] it should
// return false.
//
// You should not modify the input ArrayList.
public boolean isOrderedDescending(ArrayList<Double> input) {
	/// YOUR CODE HERE
	for(int i=0;i<input.size()-1;i++){
		if(input.get(i)<input.get(i+1)) {
			return false;
		}
	}return true;
}


// Return an ArrayList that contains all the words in
// the input2 list that are not in the input1 list.
//
// Hint: You will use nested loops.
// Hint: You will probably need a boolean variable.
//
// You should not modify the input ArrayLists.
public ArrayList<String> notInList(
		ArrayList<String> input1,
		ArrayList<String> input2) {
	/// YOUR CODE HERE
	ArrayList<String> newlist = new ArrayList<String>();
	for(String t:input2) {  
		boolean found=false;
			for(String d:input1) {
					found = true; 
					break; 
			}
		
		if (!found) {
			newlist.add(t);
			}
	}
	 return newlist;
}

// Return an ArrayList that contains all the words in
// the input1 list and all the words in the input2 list.
// Some words will appear more than once.
//
// You should not modify the input ArrayLists.
public ArrayList<String> merged(
		ArrayList<String> input1,
		ArrayList<String> input2) {
	/// YOUR CODE HERE
	ArrayList<String> newlist = new ArrayList<String>();
	for(String d:input1) {
		newlist.add(d);	
	}
	for(String t:input2) {
		newlist.add(t);
	}		
	return newlist;
}

// Reverse the list so that items are in the opposite order.
public void reverseList(ArrayList<String> input) {
	/// YOUR CODE HERE
	ArrayList<String> newlist = new ArrayList<String>();
	for(int i=input.size()-1;i>=0;i--) {
		newlist.add(input.get(i));
	}
	input.clear();
	input.addAll(newlist);
}


void main() {
	UserInterface.start();
}
