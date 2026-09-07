import java.util.ArrayList;
import java.util.Random;

public class LotteryTicket {
	private int[] numbers;
	private int currentSize;
	
		
	public LotteryTicket() {
		this.numbers=new int[8];
		this.randomTicket();
	}
	
	public void randomTicket() {
		Random rand = new Random();
		this.currentSize = 4 + rand.nextInt(5);
		for (int i = 0; i < this.currentSize; i++) {
			this.numbers[i] = 1 + rand.nextInt(99);	
		}
		
	}
	
	public void printTicket() {
		for(int i = 0;i<this.currentSize;i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
	}
	
	public void replaceNum(int index,int num) {
		if (index < 0 || index >= this.currentSize) {
	        System.out.println("Invalid position!");
	        return;
	    }
	    if (num < 1 || num > 99) {
	        System.out.println("Number must be between 1 and 99!");
	        return;
	    }
		this.numbers[index]=num;
		this.printTicket();
	}
	
	public void removeNum(int index) {
		if (index < 0 || index >= this.currentSize) {
	        System.out.println("Invalid position!");
	        return;
	    }
		
		if (this.currentSize <= 4) {
	        System.out.println("Cannot remove! Minimum ticket size is 4.");
	        return;
	    }
		for (int i = index; i < this.currentSize - 1; i++) {
	        this.numbers[i] = this.numbers[i + 1];
	    }
		
		this.currentSize--;
		this.printTicket();		
	}
	
	public void insertNum(int index,int num) {
		if (index < 0 || index > this.currentSize) {
	        System.out.println("Invalid position!");
	        return;
	    }
		if (this.currentSize >=8) {
	        System.out.println("Cannot remove! Maximum ticket size is 8.");
	        return;
	    }
		
		for (int i = this.currentSize - 1; i >= index; i--) {
			this.numbers[i+1]=this.numbers[i];
		}
		this.currentSize++;
		this.numbers[index]=num;
		this.printTicket();	
	}
	
	public LotteryTicket copy() {
		LotteryTicket copyTicket = new LotteryTicket();
		copyTicket.currentSize=this.currentSize;
		for(int i=0;i<currentSize;i++) {
			copyTicket.numbers[i]=this.numbers[i];
		}
		
		return copyTicket;	
	}
	
	public void checkWin() {
		
		Random winRand = new Random();
		int winSize = currentSize;
		int[] winNumbers = new int[winSize];
		System.out.println("Winning numbers: ");
		for (int i = 0; i < winSize; i++) {
			winNumbers[i] = 1 + winRand.nextInt(99);
			System.out.print(winNumbers[i] + " ");
		}	
		
		boolean isWin=true;
		for(int i=0;i<winSize;i++) {
			if(winNumbers[i]!=this.numbers[i]) {
				isWin=false;
				break;
			}
		}
		if(isWin) {
			System.out.println("Win!");
		}else {
			System.out.println("Sorry!");
		}
	}
	
	
	public String toString() {
		String result = "";
	    for (int i = 0; i < this.currentSize; i++) {
	        result += this.numbers[i] + " ";
	    }
	    return result;
		
	}

}
