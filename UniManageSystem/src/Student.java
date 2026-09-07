import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {
	private String name;
	private int Id;//from1000000至4000000之间的数字查找
	private Map<String, String> completedCourses;
	private List<Course> currentCourses;
	
	public Student(String name,int Id){
		this.name=name;
		this.Id=Id;
		this.completedCourses=new HashMap<String,String>();
		this.currentCourses=new ArrayList<Course>(); 
	}
	public String toString() {
		return name+Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Map<String, String> getCompletedCourses() {
		return completedCourses;
	}
	public void setCompletedCourses(Map<String, String> completedCourses) {
		this.completedCourses = completedCourses;
	}
	public List<Course> getCurrentCourses() {
		return currentCourses;
	}
	public void setCurrentCourses(List<Course> currentCourses) {
		this.currentCourses = currentCourses;
	}
	
}
