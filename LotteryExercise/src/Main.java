import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        LotteryTicket lt = new LotteryTicket();
        ArrayList<LotteryTicket> savedTickets = new ArrayList<>();
        boolean running = true;
		System.out.println("welcome to lottery system");
		while (running) {
			System.out.println("\nPlease choose an option:");
            System.out.println("1. Print current ticket");
            System.out.println("2. Replace a number");
            System.out.println("3. Remove a number");
            System.out.println("4. Insert a number");
            System.out.println("5. Save tickets");
            System.out.println("6. check the previous tickets");
            System.out.println("7. check win");
            System.out.println("8. Exit");
            //System.out.print("Your choice: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
            case 1: lt.printTicket();
            		break;
            		
            case 2:
            	System.out.println("please input the position of the number");
	    		int index1=scanner.nextInt()-1;
	    		System.out.println("please input the replace number");
	    		int num1=scanner.nextInt();
	    		lt.replaceNum(index1, num1);
	    		break;
            case 3:
            	System.out.println("Please enter the location where you want to delete the number ");
        		int index2=scanner.nextInt()-1;
        		lt.removeNum(index2);
        		break;
            case 4:
            	System.out.println("Please enter the location where you want to insert the number ");
        		int index3=scanner.nextInt()-1;
        		System.out.println("please input the insert number");
        		int num3=scanner.nextInt();
        		lt.insertNum(index3, num3);
        		break;
            case 5:
            	LotteryTicket currentTicket=lt.copy();
            	savedTickets.add(currentTicket);
            	System.out.println("Successful");
            	break;
            case 6:
            	if(savedTickets.isEmpty()) {
            		System.out.println("none");
            		break;
            	}else {
            		for(int i=0;i<savedTickets.size();i++) {
            			System.out.println((i + 1) + ". " + savedTickets.get(i));
            			
            		}
            		System.out.println("Please input the tickets order number");
            		int index6=scanner.nextInt();
            		LotteryTicket selected = savedTickets.get(index6-1);
            		lt=selected.copy();
            	}break;
            case 7:
            	lt.checkWin();
            case 8:
                System.out.println("Thank you for using Lottery System.");
                running = false;
                break;        	
            default:
                System.out.println("Invalid choice! Please try again.");
                
            }
            if (running) {
	            System.out.println("Press Enter to continue...");
	            scanner.nextLine();
	        }
			
		}
		scanner.close();
		
	}
	

}
