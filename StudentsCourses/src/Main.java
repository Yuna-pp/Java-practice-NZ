import ecs100.UI;

public class Main {
	public static void main(String[] args) { 
		
		Student s1=new Student("A","International");
		Student s2=new Student("B","Domestic");
		
		Course course= new Course("Software Engineering","SWEN501",20,5000);
		Lecturer lecturer1=new Lecturer("Prof A", 3000);
		Lecturer lecturer2=new Lecturer("Prof B", 4000);
		
		course.enroll(s1);
		course.enroll(s2);
		
		UI.println("Course " + course.getName() + " has students:");
		for (Student s : course.getStudent()) {
		    UI.println(" - " + s.getName());
		}
		
		UI.println("Student " + s1.getName() + " is enrolled in:");
		for (Course c : s1.getCourses()) {
		    UI.println(" - " + c.getName());
		}
		
		course.addLecturers(lecturer1);
		course.addLecturers(lecturer2);
		UI.println("Course: " + course.getName()+" "+course.getId()+" "
		+course.getPoint()+" "+course.getRoomCost());
		UI.println("Lecture: "+lecturer1.getName()+" && "+lecturer2.getName());
		
        UI.println("Enrolled students count: " + course.getStudent().size());
       
               
        UI.println(s1.getId() +s1.getName() +" (" + s1.getType() + ") Fee: $" + s1.getPrice());
        UI.println(s2.getId() +s2.getName() +" (" + s2.getType() + ") Fee: $" + s2.getPrice());
        UI.println("Course Profit: "+course.getProfit());
        
        
	}
}
