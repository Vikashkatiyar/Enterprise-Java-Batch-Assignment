import java.util.*;
//Vikash Katiyar
public class patternPrinting {
	
	public static void question1() {
		// TODO Auto-generated method stub
		System.out.println("INEURON Pattern :-\n");
		int n = 9;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i == 0 || i == n-1 || j == n/2) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			} 
			System.out.print("\t");
			
			for(int j=0;j<n;j++) {
				if(j == 0 || j == n-1 || j == i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.print("\t");
			
			for(int j=0;j<n;j++) {
				if(i == 0 || i == n/2 || i == n-1 || j==0){
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.print("\t");
			
			for(int j=0;j<n;j++) {
				if(((j == 0 || j == n-1 ) && (i != n-2) && (i != n-1)) || (((i == n-2) && (j== 1 || j == n-2))) || ((i == n-1) && (j>1 && j< n-2 )))  {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.print("\t");
			
			for(int j=0;j<n;j++) {
				if(j==0 || i == 0 || i == n/2 || ((j == n-1) && (i<n/2)) || ((i>n/2) && (i==j) ) ){
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.print("\t");
			
			for(int j=0;j<n;j++) {
				if((((j == 0 || j == n-1) && i!=0 ) &&  (i != n-1)) || ( i== 0 && (j != 0 && j != n - 1)) || ((i == n-1) && (j>0 && j< n-1 )))  {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			
			System.out.print("\t");
			
			for(int j=0;j<n;j++) {
				if(j == 0 || j == n-1 || j == i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			
			System.out.println();
					
		}
	}
	
	public static void question2() {
		// TODO Auto-generated method stub	 	
		System.out.print("\nPattern 2: \n");
		
		for(int i=1;i<=4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(Integer.toString(i) + " ");
			}
			System.out.println();
		}
	}
	
	public static void question3() {
		// TODO Auto-generated method stub
		System.out.print("\nPattern 3: \n");		
		for(int i=0;i<14;i++) {
			for(int j=0;j<13;j++) {
				
				if(j == 0 || j == 12 || i == 0 || i == 13 || j-i>=(13/2) || i+j <=(13/2)) {
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void question4() {
		// TODO Auto-generated method stub
		System.out.print("\nPattern 4: \n");
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<14;j++) {
				
				if(j == 0 || j == 13 || j<=i || i+j>=13) {
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void question5() {
		// TODO Auto-generated method stub	 
		System.out.print("\nPattern 5: \n");		
		for(int i=0;i<13;i++) {
			for(int j=0;j<13;j++) {
				
				if(i == 0 || i == 12 || i+j <=(13/2) ||  i - j > (13/2) - 1) {
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		question1();
		question2();
		question3();
		question4();
		question5();
	}
}
