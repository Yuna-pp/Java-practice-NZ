import ecs100.*;

public void TimesTables() {
	
		int count=0;
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				count=i*j;
				UI.println(i+"*"+j+"="+count);
			}
		}
		

}

void main() {
	UI.initialise();
	UI.addButton("Timestables", this::TimesTables);
}