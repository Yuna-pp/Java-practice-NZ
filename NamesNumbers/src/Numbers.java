import java.util.ArrayList;
import ecs100.*;
// YOUR CODE HERE

ArrayList<Integer> allNumbers = new ArrayList<Integer>();

void main() {
	// YOUR CODE HERE
	UI.initialise();
	UI.addButton("New", this::newList);
	UI.addButton("Add", this::addNum);//add Positive number
	UI.addButton("List", this::displayList);
	UI.addButton("allRemove", this::allRemove);
	UI.addButton("average", this::calAverage);
	UI.addButton("NegativeNum", this::NegativeNum);
	UI.addButton("doubleNum", this::DoubleList);
	//UI.addButton("Quit", UI::quit);
}

void newList() {
	this.allNumbers = new ArrayList<Integer>();
	// or: this.allNames.clear();
	this.displayList();
}

void addNum() {
	Integer num = UI.askInt("Num");
	
	this.allNumbers.add(num);
	if(num>0) {
		this.displayList();
	}else {
		UI.println("Error");
		this.allNumbers.removeLast();
	}
	
}

void displayList() {
	UI.clearText();
	UI.printf("List has %d numbers:%n", this.allNumbers.size());
	for (int i = 0; i < this.allNumbers.size(); i++) {
		UI.printf("%3d: %s%n", i, this.allNumbers.get(i));
	}
	UI.println("-------");
}

void allRemove() {
	this.allNumbers.clear();
	UI.printf("List has %d numbers:%n", this.allNumbers.size());
}

void calAverage() {
	int sum=0;
	for(int i=0;i<this.allNumbers.size();i++) {
		sum=sum+this.allNumbers.get(i);
	}	
	UI.println("The average is "+sum/this.allNumbers.size());
}

void NegativeNum() {
	
	for(int i=0;i<this.allNumbers.size();i++) {
		int PositiveNum=this.allNumbers.get(i);
		Integer negativeNum=0-PositiveNum;
		this.allNumbers.set(i, negativeNum);
		this.displayList();
	}
}
void DoubleList() {
	for(int i=0;i<this.allNumbers.size();i++) {
		int doubleNum=this.allNumbers.get(i);
		Integer list=doubleNum*2;
		this.allNumbers.set(i, list);
		this.displayList();
	}	
}
