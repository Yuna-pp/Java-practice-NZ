import java.util.ArrayList;



public class Student {

	private String name;
	private int id;
	private String type;
	private int price;
	private static int nextId = 1;
	
	private ArrayList<Course> courses = new ArrayList<>();

	public String getType() {
		return type;
	}
	
	public void addCourse(Course course) {
        if (!this.courses.contains(course)) {
            this.courses.add(course);
        }
    }
	
	
	
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public int getPrice() {
		return price;
	}

	public Student(String name,String type) {
		this.name=name;
		
		this.type = type;
		this.id = nextId++;
		
		if(type.equals("Domestic")) {
			this.price=200;
		}
		else if(type.equals("International")) {
			this.price=2000;
		}else {
			this.price=0;
		}
	}	
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	
}

