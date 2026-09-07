import java.util.HashMap;
import java.util.Map;

public class Course {
	private String courseCode;
	private Map<Student, String> studentGrades;
	
	public Course(String courseCode) {
		this.courseCode=courseCode;
		this.studentGrades=new HashMap<Student,String>();
	}
	
	public String toString() {
		return courseCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Map<Student, String> getStudentGrades() {
		return studentGrades;
	}

	public void setStudentGrades(Map<Student, String> studentGrades) {
		this.studentGrades = studentGrades;
	}
}
