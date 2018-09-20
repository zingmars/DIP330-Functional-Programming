// 161RDB280 % 2 = 0.var
package recursive;

import java.util.Scanner;

public class Recursive {
	private static Integer input(Scanner s) {
		Integer num;
		System.out.print("Enter a number: ");
		while (!s.hasNextInt()) s.next();
		num = s.nextInt();
		return num;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Power sum (1) or super digit (2)?");
		int choice = 0;
		while (choice != 1 && choice != 2) {
			choice = input(s);
		}

		if (choice == 1) {
			System.out.println("What number should we generate the powersum for?");
			choice = input(s);
			System.out.println("What should be the power of the numbers we test?");
			Integer power = input(s);
			System.out.println("Result = " + powerSum(choice,power,1));			
		} else if (choice == 2) {
			System.out.println("Enter a number to calculate the super digit from - ");
			System.out.println("Result = " + superDigit(input(s)));
		}
		s.close();
	}
	static Integer powerSum(int X, int N, int output) {
	    if(Math.pow(output,N)<X)
	    	return powerSum(X,N,output+1) + powerSum((int)(X-Math.pow(output,N)),N,output+1);
	    else if(Math.pow(output,N)==X)
	        return 1;
	    else
	        return 0;
	}

	static long superDigit(long x) {
		if(x<10 && x >=0) return x;
		return (x % 10) + superDigit(x / 10);
	}
}
