import ecs100.UI;

public class Staff implements Contact{
	private String name;
	private int age;
	private double totalSalaryPaid = 0.0;
	
	public Staff(String name, int age) {
        this.name = name;
        this.age = age;
    }
	
	public void paySalary(double amount) {
        this.totalSalaryPaid += amount;
        UI.println("Paid $" + amount + " salary to " + name);
    }
	
	public double getTotalSalaryPaid() {
		return totalSalaryPaid;
	}


	public void setTotalSalaryPaid(double totalSalaryPaid) {
		this.totalSalaryPaid = totalSalaryPaid;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public void recordPurchase(String product, double price) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void recordSale(String product, double price) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return -totalSalaryPaid;
	}
	@Override
	public void printTransactions() {
		// TODO Auto-generated method stub
		UI.println("--- Staff: " + name + " ---");
        UI.println("Total salary paid: $" + totalSalaryPaid);
	}
	
	
}
