import ecs100.UI;

public interface Contact{
	public String getName();
	
	 //public int getAge();
	void recordPurchase(String product, double price);
	void recordSale(String product, double price);
	
	public double getBalance();
	void printTransactions();
	
}