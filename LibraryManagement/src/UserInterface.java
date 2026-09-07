import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ecs100.UI;

public class UserInterface {
	ArrayList<Authors> auList = new ArrayList<>();
	ArrayList<Books> bookList = new ArrayList<>();
	public UserInterface() {
		UI.initialise();
		UI.addButton("List authors", this::listAuthors);
		UI.addButton("List all books", this::listBooks);
		UI.addButton("List books of author", this::listAuthorBooks);
		UI.addButton("Look up book by title", this::lookUpBook);
		UI.addButton("Issue book", this::issueBook);
		// Write code here to load books.txt into objects
					// and lists you design. You will need to make
					// classes, write loops to load the file,
					// and store objects made from your classes into
					// lists.
					//
					// The file is organised in blocks by author.
					// The first line is an author's name, then
					// either one or two numbers for birth and death years.
					// Following that, two lines for each book containing
					// the title and the year of publication.
					// A line containing "---" is the end of a block,
					// and then the next line (if any) starts the next block.		
		
		try {
			Scanner scan = new Scanner(new File("books.txt"));
			while (scan.hasNext()) {			
				String s = scan.nextLine();//第一行name
				String y= scan.nextLine();//出生年月
				Scanner yearScan = new Scanner(y);
				int birthYear = 0;
		        int deathYear = 0;
		        if(yearScan.hasNext()) { //判断有没有出生日期
		        	birthYear = yearScan.nextInt();
		        }
		        if(yearScan.hasNext()) { //判断是不是还活着
		        	deathYear = yearScan.nextInt();
		        }
		        Authors author = new Authors(s, birthYear, deathYear);
		        auList.add(author);
				//UI.println(s);	
		 
		        while(scan.hasNext()) {//继续扫描book
		        	String bookTitle = scan.nextLine().trim();
		        	
		        	if (bookTitle.equals("---")) {
		                break;
		            }   	
		        	int pubYear = scan.nextInt();
		        	scan.nextLine();
		        	Books book = new Books(bookTitle, pubYear,author);
		        	author.addBook(book);
		            bookList.add(book);
		            
		        }
			}
		} catch (IOException e) {
			UI.println("File error: " + e);
			e.printStackTrace();
		}
	}
	
	public void listAuthors() {
		// List names, lifetimes, and number of books
		// in the library for all authors
		for(Authors a: auList) {
			UI.println("Author: "+a.getName());
			if (a.getDeathYear()>a.getBirthYear()) {
	            int lifetime = a.getDeathYear() - a.getBirthYear();
	            UI.println("Lifetime: " + lifetime+ "years");
			}else {
				UI.println("Birth Year is  "+a.getBirthYear()+", still alive.");		
			}
			int count = a.getBooks().size();
			UI.println("Number of books: " + count);
	        UI.println("-------------------------");			
		}			
	}
	
	public void listBooks() {
		for(Books b:bookList) {
			UI.println("Book Title: "+b.getName());		
		}	
	}
	
	public void listAuthorBooks() {
		// List titles of all books by a chosen author
		String name=UI.askString("Please enter the author name:");
		for(Authors a:auList) {
			if(a.getName().equalsIgnoreCase(name.trim())) {
				UI.println(a.getBooks());
				return;
			}		
		}UI.println("Author not found");		
	}
	
	public void lookUpBook() {
		// Show book, publication date, and author information
		String title=UI.askString("Please enter the book name:");
		for(Books b:bookList) {
			if(b.getName().equalsIgnoreCase(title.trim())) {
				UI.println("Book title is "+b.getName());
				UI.println("The publication year is "+b.getPubYear());
				UI.println("The author infomation is "+b.getAuthor());
				return;
			}
		}UI.println("Book not found");		
		
	}
	
	public void issueBook() {
		// Issue a book to a patron.
		String title=UI.askString("Please enter the book name:");
		boolean found = false; //false 还没找到
		for(Books b:bookList) {
			if (b.getName().equalsIgnoreCase(title.trim())) {
				
	           found = true; //找到了
	           /*String status = b.isIssued()
	            ?"[On Loan]'"+ b.getName() + "' is already issued."
	            : "[Available]"+ b.getName();
	           UI.println(status);
	            if (!b.isIssued()) {
                b.setIssued(true);
            }*/
	           
	            if (b.isIssued()) {
	                UI.println("Sorry, '" + b.getName() + "' is already issued.");
	            } else {
	                b.setIssued(true);
	                UI.println("Successfully issued: " + b.getName());
	            }
	            break;
	        }
		}if (!found) {
		    UI.println("Book not found");
		}
	}
	
	public static void main(String[] args) {
		new UserInterface();
	}
}
