import ecs100.UI;

public class Client implements Contact {
	private String name;
	private int nbn;
	private double totalprice = 0.0;
	private String product;
	
	public Client(String name,int nbn) {
		this.name=name;
		this.nbn=nbn;
	}
	
	public void recordSale(String product, double price) {
		this.totalprice+=price;
		
		 UI.println("Name: "+name+ "Recorded sales: " + product + "Price: "+totalprice );
		
	}
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return totalprice;
	}
	@Override
	public void printTransactions() {
		// TODO Auto-generated method stub
		UI.println("--- Transactions for Client: " + name);
		UI.println("Total price: $" + totalprice);
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
	
	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String toString() {
	    return "Client: " + name + " (nbn: " + nbn + ")";
	}

	@Override
	public void recordPurchase(String product, double price) {
		// TODO Auto-generated method stub
		
	}


}
