package funWithWords;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "lib/100k-AnneOfGreenGables.txt";
		System.out.println("---ArrayList---");
        useArrayList(filePath);

        System.out.println("\n---HashSet---");
        useHashSet(filePath);
        wordTimes(filePath);
	}	
	public static void useArrayList(String filePath) {
		long s=System.currentTimeMillis();
		ArrayList<String> newList=new ArrayList<String>();
		try {
			Scanner scan=new Scanner(new File(filePath));
			while(scan.hasNext()) {
				String word = scan.next().toLowerCase();
			if(!newList.contains(word)) {
				newList.add(word);
			}
		}
			System.out.println("不重复的单词数量: " + newList.size());
           // System.out.println(newList); // 打印所有单词          
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long t=System.currentTimeMillis();
		long time=t-s;
		System.out.println(time+" Millis");
		
	}
	
	public static void useHashSet(String filePath) {
		long s=System.currentTimeMillis();
		Set<String> newList=new HashSet<>();
		try {
			Scanner scan= new Scanner(new File(filePath));
			while(scan.hasNext()) {
				String word = scan.next().toLowerCase();
				newList.add(word);
			}
			System.out.println("不重复的单词数量: " + newList.size());
            //System.out.println(newList); // 打印所有单词
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long t=System.currentTimeMillis();
		long time=t-s;
		System.out.println(time+" Millis");
	}
	
	public static void wordTimes(String filePath) {
		Map<String, Integer> wordCounts = new HashMap<String, Integer>(); 
		try {
			Scanner scan= new Scanner(new File(filePath));
			while(scan.hasNext()) {
				String word = scan.next().toLowerCase();
				if(wordCounts.containsKey(word)) {
					int num=wordCounts.get(word)+1;	
					wordCounts.put(word,num);
				}else {
					wordCounts.put(word, 1);
				}			
			}
			for (String c : wordCounts.keySet()) {
				System.out.println(c+" : "+wordCounts.get(c));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
