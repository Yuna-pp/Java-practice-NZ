import ecs100.UI;

public class Person implements Contact{
	private String name;
	private int age;
	private double totalPurchases = 0.0;
	private String purchaseProduct;
	private double totalSales = 0.0;
	private String salesProduct;
	
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
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
	
	public String toString() {
	    return "Person: " + name + " (Age: " + age + ")";
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
		return 0;
	}



	@Override
	public void printTransactions() {
		// TODO Auto-generated method stub
		
	}
}