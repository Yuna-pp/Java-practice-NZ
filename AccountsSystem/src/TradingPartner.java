import ecs100.UI;

public class TradingPartner implements Contact {
	private String name;
	private double totalPurchases = 0.0;
	private double totalprice = 0.0;
	

	
	public TradingPartner(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "TradingPartner: " + name ;
	}
	
	
	@Override
	public void recordPurchase(String product, double price) {
		// TODO Auto-generated method stub
		 this.totalPurchases += price; 
	        UI.println("Name: "+name+ "Recorded purchase: " + product + "Price: "+totalPurchases );
	}

	@Override
	public void recordSale(String product, double price) {
		// TODO Auto-generated method stub
		this.totalprice+=price;
		
		 UI.println("Name: "+name+ "Recorded sales: " + product + "Price: "+totalprice );
	}

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return totalprice - totalPurchases;
	}
	@Override
	public void printTransactions() {
		// TODO Auto-generated method stub
		UI.println("--- Transactions for tradingPartner: " + name);
		UI.println("Total purchases: $" + totalPurchases);
		UI.println("Total price: $" + totalprice);
	}	
	
}
