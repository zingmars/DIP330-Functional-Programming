package imperative;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class PerfectNumber {
	enum STATE {
		ABUNDANT,
		PERFECT,
		DEFICIENT,
		ERROR
	}
	public static STATE process(int n) {
		Integer result = detect(n);
		if (result != -1) {
			if (result == 0) return STATE.DEFICIENT;
			else if (result == 1) return STATE.PERFECT;
			else if (result == 2) return STATE.ABUNDANT;
		}
		return STATE.ERROR;
	}

	public static Set<Integer> divisors(Integer n) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
        for(int i = 1; i <= n; i++)
        {
            if(n % i == 0)
            {
                set.add(i);
            }
        }
		return set;
	}
	
	public static Integer detect (Integer n) {
		if (n <= 0) return -1;
		Set<Integer> set = divisors(n);
		
		int sum = 0;
		for (int i : set) {
			if ( i != n ) sum += i;
		}
		if (sum < n) return 0;
		else if (sum == n) return 1;
		else return 2; 
	}
	public static void main(String[] args) {
		Integer num;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number:");
        while (!s.hasNextInt()) s.next();
        num = s.nextInt();
        STATE output = process(num);
        if (output == STATE.ABUNDANT) System.out.println("Number " + num.toString() + " Is abundant.");
        if (output == STATE.DEFICIENT) System.out.println("Number " + num.toString() + " Is deficient.");
        if (output == STATE.PERFECT) System.out.println("Number " + num.toString() + " Is perfect.");
       
	}
}
