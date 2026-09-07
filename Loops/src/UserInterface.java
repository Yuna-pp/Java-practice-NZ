import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ecs100.UI;
import ecs100.UIFileChooser;

// This file contains code to set up the user interface.
// You don't need to touch or look at this code and it uses
// advanced features that we haven't covered yet.

public class UserInterface {
	public static void start() {
		new UserInterface();
	}

	private YourCode yc;
	private ArrayList<String> wordList;
	private ArrayList<String> wordList2;
	private ArrayList<Double> numList;
	
	public ArrayList<String> readWordFile(String filename) {
		ArrayList<String> words = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File(filename));
			while (scanner.hasNext()) {
				String nextWord = scanner.next();
				words.add(nextWord);
			}
			scanner.close();
		} catch (IOException ex) {
	
		}
		return words;
	}
	
	/// ********************************************************
	/// The code below is provided for you, and sets up the user
	/// interface to use the methods you wrote above.
	public void loadWordFile() {
		String filename = UIFileChooser.open();
		wordList = readWordFile(filename);
		UI.println("Loaded " + wordList.size() + " words from " + filename + ".");
	}
	
	public void loadWordFile2() {
		String filename = UIFileChooser.open();
		wordList2 = readWordFile(filename);
		UI.println("Loaded " + wordList2.size() + " words from " + filename + ".");
	}
	
	public void listWords() {
		UI.clearText();
		for (int i = 0; i < wordList.size(); i++) {
			UI.println(wordList.get(i));
		}
	}
	
	public void listNumbers() {
		UI.clearText();
		for (int i = 0; i < numList.size(); i++) {
			UI.println(numList.get(i));
		}
	}
	
	public void enterNumbers() {
		UI.clearText();
		String text = UI.askString("Enter numbers, separated by spaces:");
		numList = new ArrayList<Double>();
		for (String s : text.split(" "))
			try {
				numList.add(Double.parseDouble(s));
			} catch (NumberFormatException ignored) {
				UI.println("Bad number '" + s + "'.");
			}
		UI.println("Loaded " + numList.size() + " numbers.");
	}
	
	interface ListFunc<T> {
		public ArrayList<T> run(ArrayList<T> input);
	}
	
	interface ListFunc1<T> {
		public ArrayList<T> run(ArrayList<T> input, T start);
	}
	
	interface ListFuncRet<T,R> {
		public R run(ArrayList<T> input);
	}
	
	interface ListsFunc<T> {
		public ArrayList<T> run(ArrayList<T> input1,
				ArrayList<T> input2);
	}
	
	public <T> void processList(ArrayList<T> input,
			ListFunc<T> func) {
		Iterator<T> iter = input.iterator();
		ArrayList<T> out = func.run(input);
		UI.clearText();
		iter.next();
		if (out == null) {
			UI.println("(not implemented)");
			return;
		}
		for (T d : out)
			UI.println(d);
	}
	
	public <T> void processListArg(ArrayList<T> input,
			T arg,
			ListFunc1<T> func) {
		Iterator<T> iter = input.iterator();
		ArrayList<T> out = func.run(input, arg);
		UI.clearText();
		iter.next();
		if (out == null) {
			UI.println("(not implemented)");
			return;
		}
		for (T d : out)
			UI.println(d);
	}
	
	public <T,R> void processListRet(ArrayList<T> input,
			ListFuncRet<T,R> func) {
		Iterator<T> iter = input.iterator();
		R out = func.run(input);
		UI.clearText();
		iter.next();
		if (out == null) {
			UI.println("(not implemented)");
			return;
		}
		UI.println(out);
	}
	
	public <T> void processLists(ArrayList<T> input1,
			ArrayList<T> input2,
			ListsFunc<T> func) {
		Iterator<T> iter1 = input1.iterator();
		Iterator<T> iter2 = input2.iterator();
		ArrayList<T> out = func.run(input1, input2);
		UI.clearText();
		iter1.next();
		iter2.next();
		if (out == null) {
			UI.println("(not implemented)");
			return;
		}
		for (T d : out)
			UI.println(d);
	}
	
	public void mapSquare() {
		this.processList(numList, yc::mapSquare);
	}
	
	
	public void isEndingWithA() {
		UI.clearText();
		String word = UI.askString("Enter a word to check ends with a or A:");
		boolean ret = yc.isEndingWithA(word);
		UI.println(ret ? "yes" : "no");
	}
	
	public void filterContains() {
		UI.clearText();
		String start = UI.askString("String to filter: ");
		processListArg(wordList, start, yc::filterContains);
	}
	
	public void average() {
		UI.clearText();
		processListRet(numList, yc::average);
	}
	
	public void isOrderedDescending() {
		UI.clearText();
		processListRet(numList, yc::isOrderedDescending);
	}
	
	public void notInList() {
		processLists(wordList, wordList2, yc::notInList);
	}
	
	public void merged() {
		processLists(wordList, wordList2, yc::merged);
	}
	
	public void reverseList() {
		yc.reverseList(wordList);
		UI.clearText();
		for (String d : wordList)
			UI.println(d);
	}
	
	public ArrayList<Double> generateDoubleList() {
		ArrayList<Double> nums = new ArrayList<Double>();
		int rd = 1433 * 17;
		for (int i = 0; i < 100; i++) {
			rd = (rd * 2347 + 1741) % 1000;
			nums.add(rd / 10.0);
		}
		return nums;
	}
	
	private UserInterface() {
		yc = new YourCode();
		UI.initialise();
		UI.setDivider(1.0);
		UI.addButton("Load words file", this::loadWordFile);
		UI.addButton("Load secondary words file", this::loadWordFile2);
		UI.addButton("List words", this::listWords);
		UI.addButton("List numbers", this::listNumbers);
		UI.addButton("Enter new numbers", this::enterNumbers);
		UI.addButton("Call mapSquare", this::mapSquare);
		UI.addButton("Call isEndingWithA", this::isEndingWithA);
		UI.addButton("Call filterContains", this::filterContains);
		UI.addButton("Call average", this::average);
		UI.addButton("Call isOrderedDescending", this::isOrderedDescending);
		UI.addButton("Call notInList", this::notInList);
		UI.addButton("Call merged", this::merged);
		UI.addButton("Call reverseList", this::reverseList);
		wordList = readWordFile("defaultwordsa.txt");
		UI.println("Loaded default words file with "
				+ wordList.size() + " words.");
		wordList2 = readWordFile("defaultwordsb.txt");
		UI.println("Loaded default secondary words file with "
				+ wordList2.size() + " words.");
		numList = generateDoubleList();
		UI.println("Loaded default number list.");
	}
}