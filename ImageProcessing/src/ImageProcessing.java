import ecs100.UI;
import ecs100.UIFileChooser;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImageProcessing {

	public ImageProcessing() {
		UI.initialise();
		UI.addButton("Load file", this::loadFileHandler);
		UI.setMouseMotionListener(this::mouseMotionListener);
	}
	int width;
	int height;
    int colDepth;
    int photo[][];
	
	private void loadFileHandler() {
		UI.setColor(new Color(/* red */ 1.0f, /* green */ 1.0f, /* blue */ 1.0f));
		UI.fillRect(0, 0, 1000, 1000);
		
		// *** YOUR CODE HERE ***		
		try {
			Scanner scanner = new Scanner(new File(UIFileChooser.open()));
			scanner.next();
			width=scanner.nextInt();
			height=scanner.nextInt();
			photo=new int[height][width];
			colDepth = scanner.nextInt();
			for(int i=0;i<photo.length;i++) {       //row
				for(int j=0;j<photo[i].length;j++) {   //col
					photo[i][j]=scanner.nextInt();
				}
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		drawImageArrayToScreen();
	}
	
	private void drawImageArrayToScreen() {	
		for(int i=0;i<photo.length;i++) {
			for(int j=0;j<photo[i].length;j++) {
			  float gray=(float)photo[i][j]/colDepth;
			  Color c=new Color(gray, gray, gray);
			  UI.setColor(c);
			  UI.fillRect(j, i, 1, 1);
			}		
		}
	}
	
	public static void main(String[] args) {
		new ImageProcessing();
	}

	private void mouseMotionListener(String action, double x, double y) {
		// You might need to use this for some of the extension. Don't worry about
		// it until then.
		// Documentation is at
		// https://ecs.victoria.ac.nz/foswiki/pub/Main/JavaResources/UI.html#setMouseMotionListener(ecs100.UIMouseListener)
	}
	
}
