import ecs100.UI;

void main() {
		// Your code here!
	UI.println("hello,world");
	String yourName =UI.askString("what is your name?");
	UI.println("Hi,"+yourName);
	int age = UI.askInt("How old are you?");
	UI.println(age);
	
}
