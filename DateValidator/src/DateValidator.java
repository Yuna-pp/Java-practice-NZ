import ecs100.*;

/**
 * Reads a date from the user as three integers, and then checks that the date is valid
 */


/**
 * Asks user for a date, then determines whether the date
 *    specified by the three integers is a valid date.
 * For the Core, you may assume that
 * - All months have 31 days, numbered 1 to 31
 * - The months run from 1 to 12
 * - Years start from 1
 */
void validateDateCore(){
	
    /*# YOUR CODE HERE */
	int day = UI.askInt("Date:");
	int month=UI.askInt("Month:");
	int year=UI.askInt("Year:");
	if(day<=0 || month<=0 || year<=0) {
		UI.println("Error");
	}else if(day <=31 && month<=12 && year>=1){
		UI.println("Correct date");		
	}else {
		UI.println("Error");
	}

}

/**
 * Asks user for a date, then determines whether the date
 *    specified by the three integers is a valid date.
 * For the Completion, you should also check that
 * - Months have the correct number of days
 * - On leap years February should have 29 days.
 *    A year is a leap year if:
 *       - The year can be evenly divided by 4 but not 100
 *       - The year can be evenly divided by 400
 */
void validateDateCompletion(){
	
    /*# YOUR CODE HERE */
	int day = UI.askInt("Date:");
	int month=UI.askInt("Month:");
	int year=UI.askInt("Year:");
	if(day<=0 || month<=0 || year<=0) {
		UI.println("Error");
	}else if ((year % 4==0 && year % 100 !=0) || year % 400==0) {
			if( (month==1||month==3||month==5||month==7||month==8||month==10||month==12) && day<=31){
				UI.println("Correct date");	
			}else if(month==2 && day==29){
				UI.println("Correct date");
			}else if ( (month==4||month==6||month==9||month==11) && day<=30) {
				UI.println("Correct date");
			}else {
				UI.println("Error");
			}
	}else if ((year % 4==0 && year % 100 !=0) || year % 400==0) {
				if( (month==1||month==3||month==5||month==7||month==8||month==10||month==12) && day<=31){
					UI.println("Correct date");	
				}else if(month==2 && day==28){
					UI.println("Correct date");
				}else if ( (month==4||month==6||month==9||month==11) && day<=30) {
					UI.println("Correct date");
				}else {
					UI.println("Error");
				}			
		
	}else {
		UI.println("Error");
	}
}

/**
 * For the challenge, your program should be extended to deal with the transition from the Julian to Gregorian calendar.
 * The program should look at the date, determine whether this should be a Julian or Gregorian date, and test it appropriately.
 * You will need to find the rules of the Julian calendar yourselves.
 *
 */
void validateDateChallenge(){
    /*# YOUR CODE HERE */
	int day = UI.askInt("Date:");
	int month=UI.askInt("Month:");
	int year=UI.askInt("Year:");
	int week=0;
	Boolean inputDate = UI.askBoolean("Are you using Gregorian calendar？Y/N ");
	if (inputDate.equals(true)){
		if(month==1 || month==2){
			month= month+12;
			year=year-1;
			week= (day+13*(month+1)/5+year+year/4-year/100+year/400)%7;
			UI.println("Today is"+week);
			
		}else {
			week= (day+13*(month+1)/5+year+year/4-year/100+year/400)%7;
			UI.println("Today is"+week);	
		}
		
	}else {
		UI.println("Error");
	}

}

/** ---------- The code below is already written for you ---------- **/
/** Constructor: set up user interface */
void main(){
    UI.initialise();
    UI.addButton("Clear", UI::clearText );
    UI.addButton("Validate Date Core", this::validateDateCore );
    UI.addButton("Validate Date Completion", this::validateDateCompletion );
    UI.addButton("Validate transition", this::validateDateChallenge);
    UI.addButton("Quit", UI::quit );
    UI.setDivider(1);       // Expand the text area
}



