import java.util.HashMap;
import java.util.Map;

public class Dish {
	private String name;
	private Map<String, Integer> useIngrendient;
	
	
	public Dish(String name) {
		this.name=name;
		this.useIngrendient=new HashMap<String,Integer>();
		
	}
	
	public void addIngredient(String name, int amount) {
        this.useIngrendient.put(name, amount);
   }
	
	
	//public int getNumIngredient(String name) {
		//return useIngrendient.get(name);
	//}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getUseIngrendient() {
		return useIngrendient;
	}

	public void setUseIngrendient(Map<String, Integer> useIngrendient) {
		this.useIngrendient = useIngrendient;
	}
	
	public String toString() {
		return name;
	}
	
	
}
