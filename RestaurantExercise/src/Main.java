import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static Map<String, Integer> stock=new HashMap<>();
	private static Map<String, Dish> menu=new HashMap<>();
	private static Map<String, Set<String>> sales=new HashMap<>();
	
	public static void main(String[] args){
		stock.put("Beef", 200);
		stock.put("Tomato", 20);
		stock.put("Lamb", 150);
		stock.put("Cucumber", 30);
		stock.put("Eggplant", 50);
		stock.put("Egg", 30);
		stock.put("Chicken", 100);
		stock.put("Garlic", 10);
		stock.put("Fish", 100);
		
		Dish tomatoEgg=new Dish("tomatoEgg");
		menu.put("tomatoEgg", tomatoEgg);
		tomatoEgg.addIngredient("Egg", 3);
		tomatoEgg.addIngredient("Tomato", 3);
		
		Dish beefDish=new Dish("beefDish");
		menu.put("beefDish", beefDish);
		beefDish.addIngredient("Beef", 10);
		
		Dish cucumberDish=new Dish("CucumberDish");
		menu.put("CucumberDish", cucumberDish);
		cucumberDish.addIngredient("Cucumber", 3);
		cucumberDish.addIngredient("Garlic", 5);
		
		Dish fishDish = new Dish("Fish");
		menu.put("fishDish", fishDish);
		fishDish.addIngredient("Fish", 10);
		fishDish.addIngredient("Garlic", 2);
		

		displayStock();
		addIngredient();
		addStock();
		displayMenu();
		orderDish();
		reportDishSales();
		updateDish();
	}
	
	public static void displayStock() {
		for(String name: stock.keySet()) {
			int count=stock.get(name);
			System.out.println(name +"  "+ count);
		}
	}
	
	public static void displayMenu() {
		for(String name: menu.keySet()) {
			System.out.println(name);
		}
	}
	
	public static void addIngredient() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the ingredient name: ");
		String name=scan.nextLine().trim();
		for(String n: stock.keySet()) {
			if(name.equalsIgnoreCase(n)) {
				System.out.println("The ingredient already exists in the list");
				return;
			}
		}		
		System.out.println("Please input the ingredient count: ");
		int count=scan.nextInt();
		stock.put(name, count);
		System.out.println("Successful");
		displayStock();
	}
	
	public static void addStock() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the ingredient name which you want to replenish: ");
		String name=scan.nextLine().trim();
		String actualName = null; 
		for(String n: stock.keySet()) {
			if(name.equalsIgnoreCase(n)) {
				actualName=n;
				break;	
			}
		}
		if(actualName==null) {
			System.out.println("The ingredient does not exist in the list.");
			addIngredient();
			return;
		}
		System.out.println("Please input the ingredient count: ");
		int count=scan.nextInt();
		int stockCount=stock.get(actualName);
		stock.put(actualName, count+stockCount);
		System.out.println("Successful");
		displayStock();
	}
	
	public static void orderDish() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the day of week: ");
		String date=scan.nextLine().trim();
		System.out.println("Please input the dish name:  ");
		String dishName=scan.nextLine().trim();
		
		for(String n:menu.keySet()) {//menu中找匹配的菜名
			if(dishName.equalsIgnoreCase(n)) {
				Map<String, Integer> recipe = menu.get(n).getUseIngrendient();//map菜谱，获得食材名字+所用食材数量
				for (String ingName : recipe.keySet()) {
					
					int need=recipe.get(ingName);
					int has=stock.get(ingName);
					if (has<need) {
						 System.out.println(ingName + " not enough");
						 return;
				    }		
				}	
				 System.out.println("Order sucessfully");
				
				 for (String ingName : recipe.keySet()) {
					    int need = recipe.get(ingName);
					    int has = stock.get(ingName);
					    stock.put(ingName, has - need); 
					} 
				 if(!sales.containsKey(date)) {
					 sales.put(date, new HashSet<>());
				 }
				 sales.get(date).add(n);
			}
		}	
		askToContinue(scan);
	}
	
	private static void askToContinue(Scanner scan) {
	    System.out.println("Do you want to continue ordering dishes? Y/N");
	    String choice = scan.nextLine().trim();
	    if (choice.equalsIgnoreCase("Y")) {
	        orderDish();
	    } 
	}
	
	public static void reportDishSales() {
		if (sales.isEmpty()) {
	        System.out.println("No sales records found.");
	        return;
	    }
		for(String date: sales.keySet()) {
			Set<String> dishes = sales.get(date);
	        
	        if (dishes == null || dishes.isEmpty()) {
	            System.out.println(date + ": no sale record");
	        } else {
	            System.out.println(date + ": " + dishes);
	        }
		}
	}
	
	public static void updateDish() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the dish name which you want to add/update: ");
		String name=scan.nextLine().trim();
		
		Dish dish=new Dish(name);
		boolean found = false;
		//调整菜品所需要的食材数量
		for(String n: menu.keySet()) {
			if(name.equalsIgnoreCase(n)) {
				found = true;
				for(String ingName: menu.get(n).getUseIngrendient().keySet()) {
					System.out.println("Please input new ingredient count of this dish: ");
					int count=scan.nextInt();
					menu.get(n).addIngredient(ingName, count);
				}
				System.out.println("Dish updated successfully!");
				break;	
			}			
		}
		//没找到菜名，新增菜
		if(!found) {
			System.out.println("Please input ingredient name of this dish: ");
			String newName=scan.nextLine().trim();
			System.out.println("Please input new ingredient count of this dish: ");
			int count=scan.nextInt();
			menu.put(name, dish);
			dish.addIngredient(newName, count);
		}
	}
}
