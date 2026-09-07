import ecs100.UI;

public class SupplierBusiness implements Contact {
	private String name;
	private int nbn;
	private double totalPurchases = 0.0;
	private String product;
	
	
	public SupplierBusiness(String name,int nbn) {
		this.name=name;
		this.nbn=nbn;
	}
	public void recordPurchase(String product, double price) {
        this.totalPurchases += price; 
        UI.println("Name: "+name+ "Recorded purchase: " + product + "Price: "+totalPurchases );
    }
	//只有支出，没有入账
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return -totalPurchases;
	}
	@Override
	public void printTransactions() {
		// TODO Auto-generated method stub
		UI.println("--- Transactions for Supplier: " + name );
		UI.println("Total purchases: $" + totalPurchases);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNbn() {
		return nbn;
	}
	public void setNbn(int nbn) {
		this.nbn = nbn;
	}
	

	public double getTotalPurchases() {
		return totalPurchases;
	}
	public void setTotalPurchases(double totalPurchases) {
		this.totalPurchases = totalPurchases;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String toString() {
	    return "Supplier: " + name + " (nbn: " + nbn + ")";
	}
	@Override
	public void recordSale(String product, double price) {
		// TODO Auto-generated method stub		
	}
	
	
	
}
