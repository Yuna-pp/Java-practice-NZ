import ecs100.*;

/** Convert from Fahrenheit to Celsius */
public void fahrenheitToCelsius() {
	double fahren = UI.askDouble("Fahrenheit:");
	double celsius = (fahren - 32) * 5 / 9;
	UI.println(fahren + "F  is " + celsius + " C");
}
/** Convert from Celsius to Fahrenheit */
public void CelsiusToFahrenheit() {
	double celsius = UI.askDouble("Celsius");
	double fahren = celsius*9/5+32;
	UI.println(celsius + "C  is " + fahren + " F");
}

/** Print conversion formula */
public void printFormula() {
	UI.println("Celsius = (Fahrenheit - 32) * 5/9");
}

void main() {
	UI.initialise();
	UI.addButton("F->C", this::fahrenheitToCelsius);
	UI.addButton("C->F",this::CelsiusToFahrenheit);
	UI.addButton("Formula", this::printFormula);	
	
}
