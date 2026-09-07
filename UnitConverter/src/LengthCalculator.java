// 1 inch is 2.54 centimetres

import ecs100.*;
/** Convert from inch to centimetres */
void main() {
	UI.initialise();
	UI.addButton("inch to CM", this::inchToCentimetres);
	UI.addButton("Formula",this::printFormula);
}
public void inchToCentimetres() {
	double inch = UI.askDouble("inch:");
	double centimetres = inch * 2.54;
	UI.println(inch+ "inch is " + centimetres + " cm");
}
public void printFormula() {
	UI.println("inch= centimetres*2.54");
}