
// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN501 exercise.
// You may not distribute it in any other way without permission.

import ecs100.*;
import java.io.*;
import java.util.*;
import java.awt.Color;

/**
 * This program will read the data from a file into an ArrayList, which means
 * that it can analyse the numbers more easily and in more different ways. It
 * can also cope with much larger sets of numbers. The numbers are guaranteed to
 * be integers but the values can be negative and the signal swings above and
 * below zero.
 *
 * There are 11 methods you are to complete, all focusing on the ArrayList of
 * data.
 * 
 * CORE
 * 
 * doRead: reads numbers into an ArrayList.
 * 
 * doDisplay: displays the waveform.
 * 
 * doReportDistortion: prints out the fraction of time the signal is
 * distorted.
 * 
 * COMPLETION
 * 
 * doSpread: displays the spread with two horizontal lines
 * and returns its value.
 * 
 * doDisplayDistortion: shows in red the distorted part
 * of the signal.
 * 
 * doHighlightPeaks: plots the peaks with small green circles.
 * 
 * CHALLENGE
 * 
 * doNormalise: normalises all the values down so there is no
 * distortion.
 * 
 * upperEnvelope: displays the upper envelope.
 * 
 * lowerEnvelope: displays the lower envelope.
 * 
 * doSave: saves the current waveform values into a
 * file.
 * 
 * select and edit: let the user select a regions of the waveform with the
 * mouse to remove them. Add a save button to save the edited values.
 */

// Fields
ArrayList<Double> waveform; // the field to hold the ArrayList of
									// values

// Constant: the threshold for the distortionLevel and showDistortion
// methods
final double THRESHOLD = 200;

// Constants: the dimensions of the graph for the displayWaveform method
final int GRAPH_LEFT = 10;
final int ZERO_LINE = 360;

// Constant fields holding the size of the circles for the highlightPeaks
// method
final int SIZE_CIRCLE = 10;

/**
 * [CORE] Clears the panes, Creates an ArrayList stored in a field, then
 * Asks user for a waveform file (eg waveform1.txt) Reads data from the file
 * into the ArrayList
 */
void doRead() {
	try {
		UI.clearPanes();
		
		// These variables will be useful (give them real values!):
		String fileName = UIFileChooser.open();
		
		File myFile = new File(fileName);
		
		Scanner scanner = new Scanner(myFile);	
		
		// Create a new ArrayList
		waveform = new ArrayList<Double>();
		
		/* # YOUR CODE HERE */

		// * Ask user for a file to read
		// * Open that file
		// * As long as there's another Double to read from it:
		//   - Take that double from the file
		//   - And put it into the list
		while(scanner.hasNextDouble()) {
			double d=scanner.nextDouble();
			waveform.add(d);		
		}
		UI.println(waveform);
		
		/* # YOUR CODE HERE */

		UI.println("Read " + this.waveform.size() + " data points from " + fileName);
		scanner.close();
	} catch (FileNotFoundException e) {
		// The line above should be marked as an error when you start out,
		// but it will go away once you fill in your code above.
		e.printStackTrace();
	}
}

/**
 * [CORE] Displays the waveform as a line graph, The n'th value in waveform
 * is displayed at x-position is GRAPH_LEFT + n y-position is ZERO_LINE -
 * the value Plots a line graph of all the points with a blue line between
 * each pair of adjacent points Draw the horizontal line representing the
 * value zero. Uses GRAPH_LEFT and ZERO_LINE for the dimensions and
 * positions of the graph. Don't worry if the lines go off the window
 */
void doDisplay() {
		
		if (this.waveform == null) { // there is no data to display
			UI.println("No waveform to display");
			return;
		}
		else {
			// plot points: blue line between each pair of values
			/* # YOUR CODE HERE */
			UI.clearGraphics();
			// draw x axis (showing where the value 0 will be)
			UI.setColor(Color.black);
			UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size(), ZERO_LINE);
			UI.setColor(Color.blue);
			for(int i=0;i<waveform.size()-1;i++) {
				double x0=GRAPH_LEFT+i;
				double y0=ZERO_LINE-waveform.get(i);
				double xn=GRAPH_LEFT+i+1;
				double yn=ZERO_LINE-waveform.get(i+1);
				UI.drawLine(x0, y0, xn, yn);			
			}					
		}		
	
	
		
}

/**
 * [CORE] Computes and prints out the fraction of time the signal is
 * distorted. This fraction of time is defined as the number of distorted
 * values, divided by the number of values. A distorted value is defined as
 * one whose absolute value is greater than the value of THRESHOLD [Hint]
 * You may find Math.abs() useful for this method - it computes the absolute
 * value
 */
void doReportDistortion() {
	
		if (this.waveform == null) { // there is no data to analyse
			UI.println("No signal to analyse and report on");
			return;
		}
		double fraction = 0;	
		double count=0;		
		/* # YOUR CODE HERE */
		
		 for(int i=0;i<waveform.size();i++) {
			double a=Math.abs(waveform.get(i));
			if(a>THRESHOLD) {
				count++;
			}			
		}
		 double s=waveform.size();		
		 fraction=count/s;
		UI.printf("Fraction of time the signal is distorted %4.3f\n", fraction);
	
}

/**
 * [COMPLETION] The spread is the difference between the maximum and minimum
 * values of the waveform. Finds the maximum and minimum values, then
 * Displays the spread by drawing two horizontal lines on top of the
 * waveform: one green line for the maximum value, and one red line for the
 * minimum value.
 */
void doSpread() {
	
		if (this.waveform == null) { // there is no data to display
			UI.println("No waveform to display");
			return;
		}
		this.doDisplay();
		/* # YOUR CODE HERE */	
		
		double maxWave=waveform.get(0);
		double minWave=waveform.get(0);
		for(int i=1;i<waveform.size();i++) {
			double cn=waveform.get(i);//currentNumber
			if(cn>maxWave) {
				maxWave=cn;
			}if(cn<minWave) {
				minWave=cn;		
			}
		}
		UI.println(maxWave);		
		UI.println(minWave);
		double ymax= ZERO_LINE-maxWave;
		double ymin= ZERO_LINE-minWave;
		UI.setColor(Color.green);
		UI.drawLine(GRAPH_LEFT,ymax, GRAPH_LEFT+this.waveform.size(), ymax);
		UI.setColor(Color.red);
		UI.drawLine(GRAPH_LEFT,ymin, GRAPH_LEFT+this.waveform.size(), ymin);
	
}

/**
 * [COMPLETION] [Fancy version of doDisplay] Display the waveform as a line
 * graph. Draw a line between each pair of adjacent points
 * 
 * * If neither of the points is distorted, the line is BLUE
 * * If either of the two end points is distorted, the line is RED
 * 
 * Draw the horizontal lines representing the value zero and thresholds values.
 * Uses THRESHOLD to determine distorted values.
 * 
 * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
 * 
 * [Hint] You may find Math.abs(int a) useful for this method.
 * You may assume that all the values are between -250 and +250.
 */
void doDisplayDistortion() {
	
		if (this.waveform == null) { // there is no data to display
			UI.println("No waveform to display");
			return;
		}
		UI.clearGraphics();
		// draw zero axis
		UI.setColor(Color.black);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size(), ZERO_LINE);
		// draw thresholds
		/* # YOUR CODE HERE */
		for(int i=0;i<waveform.size()-1;i++) {
			double x0=GRAPH_LEFT+i;
			double y0=ZERO_LINE-waveform.get(i);
			double xn=GRAPH_LEFT+i+1;
			double yn=ZERO_LINE-waveform.get(i+1);
			double a=Math.abs(waveform.get(i));
			double b=Math.abs(waveform.get(i+1));
			if(a>THRESHOLD||b>THRESHOLD) {
				UI.setColor(Color.red);
				UI.drawLine(x0,y0,xn,yn);
			}		
			else {
				UI.setColor(Color.blue);	
				UI.drawLine(x0,y0,xn,yn);
			}	
		}
		UI.setColor(Color.black);
		UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size(), ZERO_LINE);
		UI.drawLine(GRAPH_LEFT,ZERO_LINE-THRESHOLD,GRAPH_LEFT + this.waveform.size(),ZERO_LINE-THRESHOLD);
		UI.drawLine(GRAPH_LEFT,ZERO_LINE+THRESHOLD,GRAPH_LEFT + this.waveform.size(),ZERO_LINE+THRESHOLD);
	
}

/**
 * [COMPLETION] Plots the peaks with small green circles. A peak is defined
 * as a value that is greater or equals to both its neighbouring values.
 * Note the size of the circle is in the constant SIZE_CIRCLE
 * 
 * You may assume
 * that peak values differ from their neighbouring points.
 */
void doHighlightPeaks() {
	this.doDisplayDistortion(); // use doDisplay if doDisplayDistortion
								// isn't complete
	/* # YOUR CODE HERE */
	double size_circle=5;
	for(int i=0;i<waveform.size()-2;i++) {
		double x0=GRAPH_LEFT+i;
		double y0=waveform.get(i);
		double xm=GRAPH_LEFT+i+1;
		double ym=waveform.get(i+1);
		double xn=GRAPH_LEFT+i+2;
		double yn=waveform.get(i+2);
		if(y0<=ym&&ym>=yn) {
			UI.setColor(Color.green);
			UI.fillOval(xm-size_circle/2, ZERO_LINE-ym-size_circle/2, size_circle,size_circle);
		}
	}
}

/**
 * [CHALLENGE] Finds the largest value (positive or negative) in the
 * waveform, and normalises all the values down so that the largest value is
 * now equal to the distortion threshold. Then redraws the waveform.
 */
void doNormalise() {
	/* # YOUR CODE HERE */

	this.doDisplayDistortion(); // use doDisplay if doDisplayDistortion
								// isn't complete
}

void doEnvelope() {
	if (this.waveform == null) { // there is no data to display
		UI.println("No waveform to display");
		return;
	}
	this.doDisplay(); // display the waveform
	this.upperEnvelope();
	this.lowerEnvelope();
}

/**
 * [CHALLENGE] Displays the upper envelope with GREEN lines connecting all
 * the peaks. A peak is defined as a point that is greater or equal to
 * *both* neighbouring points. DO NOT clear the graphics as we also want to
 * view the waveform.
 */
void upperEnvelope() {
	/* # YOUR CODE HERE */
}

/**
 * [CHALLENGE] Displays the lower envelope with RED lines connecting all the
 * "negative" peaks. A "negative" peak is defined as a point that is smaller
 * or equal to *both* neighbouring points. DO NOT clear the graphics as we
 * also want to view the waveform.
 */
void lowerEnvelope() {
	/* # YOUR CODE HERE */

}

/**
 * [CHALLENGE] Saves the current waveform values into a file
 */
void doSave() {
	/* # YOUR CODE HERE */

}

int index1;

/**
 * [CHALLENGE] Lets user select a region of the waveform with the mouse and
 * deletes that section of the waveform.
 */
void doMouse(String action, double x, double y) {
	/* # YOUR CODE HERE */

}

/** ---------- The code below is already written for you ---------- **/

void main() {
	// core
	UI.addButton("Read Data", this::doRead);
	UI.addButton("Display Waveform", this::doDisplay);
	UI.addButton("Report Distortion", this::doReportDistortion);
	// completion
	UI.addButton("Spread", this::doSpread);
	UI.addButton("Display Distortion", this::doDisplayDistortion);
	UI.addButton("Peaks", this::doHighlightPeaks);
	// challenge
	UI.addButton("Normalise", this::doNormalise);
	UI.addButton("Envelope", this::doEnvelope);
	UI.addButton("Save", this::doSave);
	UI.addButton("Quit", UI::quit);
	UI.setMouseListener(this::doMouse); // only for challenge

}

