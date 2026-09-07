import ecs100.*;

/**
 * Asks user for a guess.
 * Tells them if the target is higher or lower than the guess.
 * If they guessed the target correctly, they win.
 * Otherwise, asks for another guess until they get the right answer.
 */
void higherLowerCore(){
	// Target is a random number from 1 to 100 for the user to guess.
	int target = (int)Math.floor(Math.random() * 100) + 1;
    /*# YOUR CODE HERE */
	int inputNum=UI.askInt("please input number between 1 to 100:");
	while (inputNum!=target) {
		if(inputNum>target) {
			UI.println("higher");
			inputNum=UI.askInt("please input number between 1 to"+inputNum);	
		}
		if(inputNum<target) {
			UI.println("lower");
			inputNum=UI.askInt("please input number between "+inputNum+" to 100");		
		}
		if(inputNum==target) {
			UI.println("bingo！The number is "+ target);
		}
	}		
		
}

/**
 * Asks user for the number of rounds to play, then lets them play the
 * guessing game that many times.
 * Each game has a new target and the player has 10 guesses.
 * At the end, reports to the user how many times they guessed correctly
 * and how many guesses they used in total.
 */
void higherLowerCompletion(){
    /*# YOUR CODE HERE */	
	int guessMax=10;
	int win=0;// win times
	int round=UI.askInt("how many rounds they want to play?");
	int count=1;
	for(int i=0; i<round;i++) {
		int target = (int)Math.floor(Math.random() * 100) + 1;
		
		UI.println(target);
		int inputNum=UI.askInt("please input number between 1 to 100:");	
 
		//while (inputNum != target && count < guessMax) {
		for(int j=0;j<guessMax;j++) {
			if(inputNum>target) {
				UI.println("higher");			
				inputNum=UI.askInt("please input number:");		
				count++;
			}
			else if(inputNum<target) {
				UI.println("lower");				
				inputNum=UI.askInt("please input number:");	
				count++;
			}
			else if(inputNum==target) {
				UI.println("bingo!");
				count++;
				UI.println("you guessed "+count+"times");
				win++;
				break;
			}
		}
			
		UI.println("this round is over");
		
		// break;						
	}UI.println("game over! you wined "+win+"times and you guessed "+ count +"times");	

}

/**
 * Make the game more complicated and record more information about the game.
 *
 */
public void higherLowerChallenge(){
    /*# YOUR CODE HERE */

}

/** ---------- The code below is already written for you ---------- **/
/** Constructor: set up user interface */
void main(){
    UI.initialise();
    UI.addButton("Clear", UI::clearText );
    UI.addButton("Higher or Lower Core", this::higherLowerCore );
    UI.addButton("Higher or Lower Completion", this::higherLowerCompletion );
    UI.addButton("Quit", UI::quit );
    UI.setDivider(1);       // Expand the text area
}
