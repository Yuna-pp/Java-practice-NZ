import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<String, Student> studentsByName = new HashMap<>();
    private static Map<Integer, Student> studentsById = new HashMap<>();
    private static Map<String, Course> coursesByCode = new HashMap<>();
    public static int stuId=1000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		loadData();
		getStudentByName("Donald Harris");
		getStudentsById(1000025); 
		addCourse("AAAA01");
	}
	public static void loadData() {
		String filePath = "lib/data.txt";
		List<Student> student=new ArrayList<Student>();
		
		try {
			Scanner scan= new Scanner(new File(filePath));
			while(scan.hasNextLine()) {
				String line = scan.nextLine().trim();
				String[] parts = line.split("\\s+");
				if (parts.length < 3) {
                    continue;
                }
				String courseCode = parts[0];
				String grade = parts[1];
				
				StringBuilder nameBuilder = new StringBuilder();
				for (int i = 2; i < parts.length; i++) {
					nameBuilder.append(parts[i]);
					if((i < parts.length - 1)) {
						nameBuilder.append(" ");
					}
				}
				String stuName = nameBuilder.toString();
				
				Student stu = studentsByName.get(stuName);
				if(stu==null){
					stu= new Student(stuName, stuId);
					stuId++;
					studentsByName.put(stuName, stu);
                    studentsById.put(stu.getId(), stu);
				}
				
				Course course = coursesByCode.get(courseCode);
                if (course == null) {
                    course = new Course(courseCode);
                    coursesByCode.put(courseCode, course);
                }
                
                if(grade.equals("-")) {
                	stu.getCurrentCourses().add(course);
                }else {
                	stu.getCompletedCourses().put(courseCode, grade);
                	course.getStudentGrades().put(stu, grade);
                }         			
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addStudent(String name) {
		if(name.equals(studentsByName)) {
			System.out.println("The student already exists in the list");
			return;
		}
		Student student = new Student(name, stuId);
		studentsByName.put(name, student);
		studentsById.put(stuId,student);
		stuId++;
		System.out.println(name + "，student Id: " + (stuId - 1));
	}
	public static void getStudentByName(String name) {
		Student s=studentsByName.get(name);
		if(s==null){
			System.out.println("not found");
			return;
		}
		System.out.println(s.getName()+" "+s.getId());
		System.out.println(s.getCompletedCourses());
		System.out.println("The current Course is "+s.getCurrentCourses());		
	}
	public static void getStudentsById(int id) {
		Student s=studentsById.get(id);
		if(s==null) {
			System.out.println("not found");
			return;
		}
		System.out.println(s.getName());
		System.out.println(s.getCompletedCourses());
		System.out.println(s.getCurrentCourses());		
	}
	
	public static void addCourse(String courseCode) {
		if(coursesByCode.equals(courseCode)) {
			System.out.println("The student already exists in the list");
			return;
		}
		Course course=new Course(courseCode);
		coursesByCode.put(courseCode, course);
		System.out.println("Add new course is "+ courseCode);
	}
	public static void assignGrade(String name,String courseCode, String grade) {
		Student s=studentsByName.get(name);
		Course c=coursesByCode.get(courseCode);
		if(s==null||c==null) {
			System.out.println("not found");
			return;
		}
		s.getCurrentCourses().remove(courseCode);
		s.getCompletedCourses().put(courseCode, grade);
		
		c.getStudentGrades().put(s, grade);
		System.out.println(name+"'s grade is "+grade);
	}
	public static void getCourse(String courseCode) {
		Course c=coursesByCode.get(courseCode);
		if(c==null) {
			System.out.println("not found");
			return;
		}
		System.out.println("The number of this course is "+c.getStudentGrades().size());		
	}		
}
