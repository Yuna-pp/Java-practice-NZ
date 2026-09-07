import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import ecs100.*;

// Add your fields here - you will need some ArrayLists

// UI setup
void main() {
	UI.initialise();
	UI.addButton("Find by name", this::findByName);
	UI.addButton("List people from place", this::findByPlace);
	UI.addButton("Merge databases", this::mergeNamePlace);
	UI.addButton("Align sequences", this::alignSequences);
	// This is the method you need to fill in to get the data
	loadDatabases();
}

// Core:
// Loads the names-db.txt and places-db.txt files into
// ArrayLists for use by the findByName, findByPlace,
// and mergeNamePlace methods.
// The names-db file has an ID number, a space, and the name of a person.
// The places-db file has an ID number, a space, and the place they're from.
// The ID numbers match between files, but the lines are not in the same order.
// Hint: You will need *four* ArrayLists!
ArrayList<Integer> ID1=new ArrayList<Integer>();
ArrayList<String> idName=new ArrayList<String>();
ArrayList<Integer> ID2=new ArrayList<Integer>();
ArrayList<String> idPlace=new ArrayList<String>();
void loadDatabases() {
	// Your code here...
	try {
		Scanner scan1 = new Scanner(new File("names-db.txt"));
		Scanner scan2=new Scanner(new File("places-db.txt"));
		
		/*while (scan1.hasNext()) {
			String line = scan1.nextLine();
			Scanner lineSc = new Scanner(line);		
			int id1 = lineSc.nextInt(); // you will want to replace this line too
			String n=lineSc.next();
				
			while(lineSc.hasNext()) {
				n = n + " " + lineSc.next();
				// Your code here...			
			}	
			ID1.add(id1);
			idName.add(n);		
		}
		scan1.close();*/
		while (scan1.hasNext()) {
			int id1 = scan1.nextInt(); // you will want to replace this line too
			String n = scan1.nextLine().trim();
			ID1.add(id1);
			idName.add(n);
			
			}
			scan1.close();

		// Your code here...
		/*while(scan2.hasNext()) {
			String line = scan2.nextLine();	
			Scanner lineSc = new Scanner(line);	
			int id2 = lineSc.nextInt();
			String area=lineSc.next();
			while(lineSc.hasNext()) {
				area=area+" "+lineSc.next();
			}
			
			ID2.add(id2);
			idPlace.add(area);
		}
		scan2.close();*/
			while (scan2.hasNext()) {
				int id2 = scan2.nextInt(); // you will want to replace this line too
				String area = scan2.nextLine().trim();
				ID2.add(id2);
				idPlace.add(area);
				}
				scan2.close();
			
	} catch (IOException e) {
		UI.println("Error: " + e);
	}
}

// Core:
// Prints out where a person is from, looked up by name.
void findByName() {
	String name = UI.askString("Enter a name to look up");
	// Your code here...
for(int i=0;i<idName.size();i++) {
		if(name.equals(idName.get(i))) {
			int id=ID1.get(i);
			for(int j=0;j<ID2.size();j++) {
				if(id==ID2.get(j)) {
					String place=idPlace.get(j);
					UI.println(name+" is from"+place);
					return;
				}			
			}
		}
	}
}

// Core:
// Prints out *all* the people from a particular place.
void findByPlace() {
	String place = UI.askString("Enter a place to find people from there");
	// Your code here...

		ArrayList<Integer> newlist = new ArrayList<Integer>();
		for(int i=0;i<idPlace.size();i++) {
			if(place.equalsIgnoreCase(idPlace.get(i))) {
				int id=ID2.get(i);
				for(int j=0;j<ID1.size();j++) {
					if(ID1.get(j)==id) {
						UI.println(ID1.get(j)+" "+idName.get(j));
					}
				}
			}
		}
}

// Completion:
// Loads two files full of tokens into ArrayLists.
// The sequences may overlap in part or in full (that is,
// part of one sequence may also be within another).
// Find the best place to overlap them, where there are
// the most matches and the fewest mismatches between
// the two lists.
// You will need to find the index of one list that
// corresponds to the start of the other, if any.
// Print out the merged list showing the overlap, and
// marking any mismatches with a ?.
// Hint: you will need two lists, and nested for loops.
void alignSequences() {
	String filename1 = UIFileChooser.open("First sequence");
	String filename2 = UIFileChooser.open("Second sequence");
	// Your code here...
	
	
}

// Challenge:
// This method merges the two databases together into a single file.
// The file will contain the ID, name, and place for each person, in
// a way that lets you match them up correctly. It won't repeat
// IDs or names.
// The loadNamePlace method will load this file in, replacing
// loadDatabases (so make sure you factor that in to your output!).
// Hint: You can use multiple lines per person.
//
// You may find it easier to print to the UI first to see what
// you're generating.
void mergeNamePlace() {
	String dest = UIFileChooser.save("Location of merged file");
	// Your code here...
}

// Challenge:
// Loads in the merged database you created in mergeNamePlace.
// This method replaces loadDatabases() once built.
// Hint: You can read from multiple lines within your scanner loop.
void loadNamePlace() {
	String dest = UIFileChooser.open("Location of merged file");
	// Your code here...
}


