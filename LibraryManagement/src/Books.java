
public class Books {
	String name;
	int pubYear;
	private Authors author;
	private boolean isIssued;
	
	
	public boolean isIssued() {
		return isIssued;
	}


	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}


	public Books(String name,int pubYear,Authors author) {
		this.name=name;
		this.pubYear=pubYear;
		this.author=author;
	}
	
	
	public Authors getAuthor() {
		return author;
	}

	public void setAuthor(Authors author) {
		this.author = author;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPubYear() {
		return pubYear;
	}
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}
	
	public String toString() {
		return name;
	}
	
	
}
