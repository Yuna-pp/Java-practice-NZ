import java.util.ArrayList;

import ecs100.UI;

public class MainDriver {
	
	public MainDriver()
	{
		UI.initialise();
		
//		ArrayList<Object> l = new ArrayList<Object>();
		ArrayList<Balloon> l = new ArrayList<Balloon>();
		
		
		l.add(new NormalBalloon());
		l.add(new NormalBalloon());
		l.add(new LongBalloon());
		l.add(new NormalBalloon());
		l.add(new LongBalloon());
		
		for(Balloon o : l)
		{
			UI.println(o);
			o.pop();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainDriver();
	}

}
