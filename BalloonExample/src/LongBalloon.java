import ecs100.UI;

public class LongBalloon implements Balloon {

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		UI.println("Popping, Long ballooooooon!");

	}

	@Override
	public boolean on(double x, double y) {
		// TODO Auto-generated method stub
		UI.println("On method, Long ballooooooon!");
		return false;
	}

	@Override
	public void expand() {
		// TODO Auto-generated method stub
		
		UI.println("Expanding, Long ballooooooon!");

	}
	
	public String toString()
	{
		return "Hello, this is a Long balloooooon";
	}
	
	
	
	public void doSomeSpecificStuff()
	{
		UI.println("Something specific, Long Balloon");
	}


}
