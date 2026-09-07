
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		allOnions(1,4);				
	}	
	public static void onion (int layers){
		System.out.print("(");
		if(layers>1) {onion(layers-1);} 
		
		System.out.print(")");
		
	}
	public static void allOnions(int n,int num) {
			     
		if(n==num) {
			onion(n);
		}
		else if(n<num) {
			onion(n);
			allOnions(n+1,num);
			onion(n);
		}
	}	
}
