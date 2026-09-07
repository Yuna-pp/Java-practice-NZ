import java.util.ArrayList;

import ecs100.UI;

public class Authors {
	private String name;
	private int birthYear;
	private int deathYear;
	private ArrayList<Books> books;
	
	
	public Authors(String name,int birthYear,int deathYear) {
			
		this.name=name;
		this.birthYear=birthYear;
		this.deathYear=deathYear;
		this.books = new ArrayList<>();
	}
	public void addBook(Books book) {
        this.books.add(book);
    }
	
	public int getLifetime() {
        return deathYear - birthYear;
    }
	
	public ArrayList<Books> getBooks() {
		return books;
	}


	public void setBooks(ArrayList<Books> books) {
		this.books = books;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public int getDeathYear() {
		return deathYear;
	}
	public void setDeathYear(int deathYear) {
		this.deathYear = deathYear;
	}
	
	public String toString() {
		return name+" ("+birthYear+" - "+deathYear+") ";
	}
	
}
