import java.util.ArrayList;
import java.util.List;

import ecs100.UI;

public class Course {
	private String name;
	private String id;
	private List<Student> students;	
	private List<Lecturer> lecturers=new ArrayList<Lecturer>();
	private int point;
	private double roomCost;
	private double profit;

	
	public double getProfit() {
		double totalIncome = 0;
		for (Student stu : students) {
	        totalIncome += stu.getPrice() * this.point;
	    }
		
		double totalLecCost = 0;
	    for (Lecturer l : lecturers) {
	        totalLecCost += l.getCost();
	    }
		profit=totalIncome-roomCost-totalLecCost;
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public Course(String name,String id,int point,double roomCost) {
		this.name=name;
		this.id=id;
		this.roomCost = roomCost;
		this.setPoint(point);
		this.students=new ArrayList<Student>();
	}
	
	public List<Lecturer> getLecturers() {
		return lecturers;
	}
	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}
	public void addLecturers(Lecturer lecturers) {
		this.lecturers.add(lecturers);
	}
	public double getRoomCost() {
		return roomCost;
	}

	public void setRoomCost(double roomCost) {
		this.roomCost = roomCost;
	}

	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		   switch (point) {
		        case 15,20,30,40,45,60 -> this.point = point;
		        default -> UI.println("Error");
		    }
	}
	
	public String getName() {
		return name;
	}	
	
	public void setName(String name) {
		this.name=name;
	}
	public String getId() {
		return id;	
	}
	public void setId(String id) {
		this.id=id;
	}
	public List<Student> getStudent(){
		return students;		
	}
	public void setStudents(List<Student> students) {
	    this.students = students;
	}
	public void enroll(Student student) {
		if (student != null && !this.students.contains(student)) {
	        // 1. 课程添加该学生
	        this.students.add(student);
	        
	        // 2. 关键点：同步让学生也添加这门课程，保持两边一致！
	        student.addCourse(this);
	    }
	}
	
}
