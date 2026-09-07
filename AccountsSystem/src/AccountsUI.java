import java.util.ArrayList;
import java.util.List;

import ecs100.UI;

public class AccountsUI {

	// You will need to create the "Contact" type!
	private List<Contact> contacts = new ArrayList<>();
		
	public AccountsUI() {
		UI.initialise();
		UI.addButton("Add individual contact", this::addPerson);
		UI.addButton("Add business supplier contact", this::addSupplier);
		UI.addButton("Add business client contact", this::addBusinessClient);
		UI.addButton("Add trading partner contact", this::addTradingPartner);
		UI.addButton("List contacts", this::listContacts);
		UI.addButton("Find contact by name", this::findContact);
		UI.addButton("Record purchase from supplier", this::recordPurchase);
		UI.addButton("Record sale to client", this::recordSale);
		UI.addButton("Report sale/purchase balance for contact", this::reportBalance);
		UI.addButton("Compute total profit", this::computeProfit);
		UI.addButton("List all transactions with a contact", this::listTransactions);
		UI.addButton("Add staff", this::addStaff);
		// Your code here?
	}
	
	private void addPerson() {
		String name = UI.askString("Name: ");
		int age = UI.askInt("Age: ");
		// Your code here...
		Person person=new Person(name,age);
		contacts.add(person);	
	}
	
	private void addSupplier() {
		// Add a supplier to the list of contacts
		String name = UI.askString("Name: ");
		int nbn = UI.askInt("Business number: ");
		// Your code here...
		SupplierBusiness supplier=new SupplierBusiness(name,nbn);
		contacts.add(supplier);	
	}
	
	private void addBusinessClient() {
		// Add a business client to the list of contacts
		String name = UI.askString("Name: ");
		int nbn = UI.askInt("Business number: ");
		// Your code here...
		Client client=new Client(name,nbn);
		contacts.add(client);	
	}
	
	private void addTradingPartner() {
		// Add someone who is both a buyer and a seller to the list of contacts
		String name = UI.askString("Name: ");
		// Your code here...
		TradingPartner tp=new TradingPartner(name);
		contacts.add(tp);
	}
	private void addStaff() {
		String name=UI.askString("Name: ");
		int age = UI.askInt("age: ");
		Staff staff=new Staff(name,age);
		contacts.add(staff);		
	} 
	
	private void listContacts() {
		// List all contacts in the system
		// Your code here...
		for(Contact c:contacts){
			UI.println(c);
		}
	}
	
	private void findContact() {
		// Find one of the contacts by name and report on them
		String name = UI.askString("Name: ");
		// Your code here...
		for(Contact c:contacts) {
			if(name.equalsIgnoreCase(c.getName())) {
				UI.println(c);
				return;
			}					
		}	UI.println("not found");
	}
	
	private void recordPurchase() {
		// Record a purchase from a supplier
		String name = UI.askString("Supplier: ");
		String product = UI.askString("Purchased: ");
		double price = UI.askInt("Price: ");
		// Your code here...
		for (Contact c : contacts) {
	        if (name.equalsIgnoreCase(c.getName())) {
	              c.recordPurchase(product, price);
	            return;
	        }
	    }
		
	    UI.println("Supplier not found!");				
	}
	
	private void recordSale() {
		// Record a sale to a customer
		String name = UI.askString("Customer: ");
		String product = UI.askString("Purchased: ");
		double price = UI.askInt("Price: ");
		// Your code here...
		for (Contact c : contacts) {
	        if (name.equalsIgnoreCase(c.getName())) {
	            c.recordSale(product, price);
	            return;
	        }
	    }
	    UI.println("Client not found!");	
	}
	
	
	private void reportBalance() {
		// Report how much has been paid by/to a contact
		String name = UI.askString("Name: ");
		// Your code here...
		for(Contact c:contacts) {
			 if (name.equalsIgnoreCase(c.getName())) {
				 double balance = c.getBalance();
				 UI.println(c.getName()+" balance is $"+balance);
				 return;
			 }
		}
		 UI.println("Contact not found!");	
	}
	
	private void computeProfit() {
		// Compute the total profit of the business (sales - purchases)
		// Your code here...
		double profit=0.0;
		for(Contact c:contacts){
			profit+=c.getBalance();
		}
		UI.println("The profit is $"+profit);
	}
	
	private void listTransactions() {
		String name = UI.askString("Name: ");
		
		for(Contact c:contacts){
			 if (name.equalsIgnoreCase(c.getName())) {
				 c.printTransactions();
				 return;
			 }		 
		}if (name.equalsIgnoreCase("All")) {
	        for (Contact c : contacts) {
	            c.printTransactions();
	        }
	        return; 
	    }
		UI.println("Contact not found!");	
	}	

	public static void main(String[] args) {
		new AccountsUI();
	}
}
